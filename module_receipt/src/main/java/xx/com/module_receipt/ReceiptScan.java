package xx.com.module_receipt;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.android.volley.Request;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.reflect.TypeToken;
import com.xx.chinetek.chineteklib.base.BaseActivity;
import com.xx.chinetek.chineteklib.base.BaseApplication;
import com.xx.chinetek.chineteklib.base.ToolBarTitle;
import com.xx.chinetek.chineteklib.model.ReturnMsgModel;
import com.xx.chinetek.chineteklib.model.ReturnMsgModelList;
import com.xx.chinetek.chineteklib.util.Network.NetworkError;
import com.xx.chinetek.chineteklib.util.Network.RequestHandler;
import com.xx.chinetek.chineteklib.util.dialog.MessageBox;
import com.xx.chinetek.chineteklib.util.dialog.ToastUtil;
import com.xx.chinetek.chineteklib.util.function.ArithUtil;
import com.xx.chinetek.chineteklib.util.function.CommonUtil;
import com.xx.chinetek.chineteklib.util.function.GsonUtil;
import com.xx.chinetek.chineteklib.util.log.LogUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import xx.com.Adapter.ReceiptScanAdapter;
import xx.com.Model.InStockDetailInfo;
import xx.com.Model.InStockInfo;
import xx.com.lib_common.Common_Model.Action.ReceiptActions;
import xx.com.lib_common.Common_Model.CommonModel;
import xx.com.lib_common.Common_Model.Model.Area.AreaInfo;
import xx.com.lib_common.Common_Model.Model.Base_Model;
import xx.com.lib_common.Common_Model.Model.Material.MaterialInfo;
import xx.com.lib_common.Common_Model.URLModel;

import static xx.com.lib_common.Common_Model.URLModel.RESULT_GetAreaModelADF;
import static xx.com.lib_common.Common_Model.URLModel.RESULT_GetT_InStockDetailListByHeaderIDADF;
import static xx.com.lib_common.Common_Model.URLModel.RESULT_GetT_PalletDetailByBarCode;
import static xx.com.lib_common.Common_Model.URLModel.RESULT_SaveT_InStockDetailADF;
import static xx.com.lib_common.Common_Model.URLModel.TAG_GetAreaModelADF;
import static xx.com.lib_common.Common_Model.URLModel.TAG_GetT_InStockDetailListByHeaderIDADF;
import static xx.com.lib_common.Common_Model.URLModel.TAG_GetT_PalletDetailByBarCodeADF;
import static xx.com.lib_common.Common_Model.URLModel.TAG_SaveT_InStockDetailADF;

@Route(path= ReceiptActions.Action_Receipt_Scan)
public class ReceiptScan extends BaseActivity implements View.OnKeyListener{

    Context context=ReceiptScan.this;

    @BindView(R2.id.txt_VoucherNo)
    TextView txtVoucherNo;
    @BindView(R2.id.txt_ItemName)
    TextView txtMeterialName;
    @BindView(R2.id.rv_ReceiptDetail)
    RecyclerView rvReceiptDetail;
    @BindView(R2.id.edt_Scanbarcode)
    EditText edtScanbarcode;
    @BindView(R2.id.edt_ScanQty)
    EditText edtScanQty;
    @BindView(R2.id.contact_fab)
    FloatingActionButton contactFab;

    ReceiptScanAdapter receiptScanAdapter;
    ArrayList<InStockDetailInfo> inStockDetailInfos;//单据明细

    ArrayList<InStockDetailInfo> inStockDetailInfosUnit;//合并数量单据明细

    ArrayList<MaterialInfo> materialInfos;//扫描物料

    @Override
    public void onHandleMessage(Message msg) {
        receiptScanAdapter.setEnableLoadMore(true);
        switch (msg.what) {
            case RESULT_GetT_InStockDetailListByHeaderIDADF:
                AnalysisGetT_InStockDetailListJson((String) msg.obj);
                break;
            case RESULT_GetT_PalletDetailByBarCode:
                AnalysisGetT_PalletDetailByNoADF((String) msg.obj);
                break;
            case RESULT_GetAreaModelADF:
                AnalysisGetAreaModelADFJson((String) msg.obj);
                break;
            case RESULT_SaveT_InStockDetailADF:
                AnalysisSaveT_InStockDetailADFJson((String) msg.obj);
                break;
            case NetworkError.NET_ERROR_CUSTOM:
                ToastUtil.show("获取请求失败_____"+ msg.obj);
                CommonUtil.setEditFocus(edtScanbarcode);
                break;
        }
    }


    @Override
    protected void initViews() {
        BaseApplication.toolBarTitle = new ToolBarTitle(getString(R.string.receipt_title), getString(R.string.receiptscan_title_sub));
        setContentView(R.layout.activity_receipt_scan);
        super.initViews();
        rvReceiptDetail.setLayoutManager(new LinearLayoutManager(this));
        edtScanQty.setVisibility(CommonModel.IsInputQty?View.VISIBLE:View.GONE);
        edtScanbarcode.setOnKeyListener(this);
        edtScanQty.setOnKeyListener(this);
    }

    @Override
    protected void initData() {
        super.initData();
        InStockInfo inStockInfo=getIntent().getParcelableExtra("inStockInfo");
        txtVoucherNo.setText(inStockInfo.getErpVoucherNo()==null?inStockInfo.getVoucherNo():inStockInfo.getErpVoucherNo());
        initAdapter();
        GetT_InStockDetailInfo(inStockInfo);
   }

   @OnClick(R2.id.contact_fab)
   public void contactfabClick(View view){
       final EditText et = new EditText(this);
       et.setTextColor(getResources().getColor(R.color.black));
       et.setSingleLine(true);
       new AlertDialog.Builder(this).setTitle(getString(R.string.Msg_dialog_uploadArea))
               .setView(et)
               .setPositiveButton(getString(R.string.receipt_scan_upload), new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int which) {
                        String AreaNo=et.getText().toString();
                       AreaInfo areaInfo=new AreaInfo();
                       areaInfo.setAreaNo(AreaNo);
                       areaInfo.setWarehouseID(CommonModel.userInfo.getWarehouseID());
                       String  ModelDetailJson=GsonUtil.parseModelToJson(areaInfo);
                       LogUtil.WriteLog(ReceiptScan.class, TAG_GetAreaModelADF, ModelDetailJson);
                       RequestHandler.addRequest(Request.Method.POST, TAG_GetAreaModelADF, mHandler, RESULT_GetAreaModelADF, null,
                               URLModel.GetURL().GetAreaModelADF, ModelDetailJson, null);

                   }
               })
               .setNegativeButton(getString(R.string.common_cancel), null)
               .show();
   }

    @Override
    public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
        if (keyCode == KeyEvent.KEYCODE_ENTER && keyEvent.getAction() == KeyEvent.ACTION_UP) {
            int vid = view.getId();
            keyBoardCancle();
            if (vid == R.id.edt_Scanbarcode) {
                String code=edtScanbarcode.getText().toString().trim();
                DealBarcode(code);
            } else if (vid == R.id.edt_ScanQty) {
                String code=edtScanQty.getText().toString();
                if(!CommonUtil.isFloat(code)){
                    MessageBox.Show(context,getString(R.string.Error_isnotnum));
                    CommonUtil.setEditFocus(edtScanQty);
                    return true;
                }
                Float scanQty=Float.parseFloat(code);
                CheckOrderQtyByMaterial(materialInfos,scanQty);
                edtScanQty.setText("1");
                CommonUtil.setEditFocus(edtScanbarcode);
            }
            return true;
        }
        return false;
    }

    private void DealBarcode(String code){
       if(TextUtils.isEmpty(code)){
           MessageBox.Show(context,getString(R.string.hint_scan_barcode));
           return;
       }
        materialInfos=new ArrayList<>();
        MaterialInfo materialInfo=new MaterialInfo();
        materialInfo.setBarCodeEAN(code);
        materialInfo.setUserID(CommonModel.userInfo.getID());
        String  ModelDetailJson=GsonUtil.parseModelToJson(materialInfo);
        LogUtil.WriteLog(ReceiptScan.class, TAG_GetT_PalletDetailByBarCodeADF, ModelDetailJson);
        RequestHandler.addRequestWithDialog(Request.Method.POST, TAG_GetT_PalletDetailByBarCodeADF,
                getString(R.string.Msg_GetT_PalletDetailByBarCodeADF), context, mHandler,
                RESULT_GetT_PalletDetailByBarCode, null,
                URLModel.GetURL().GetT_PalletDetailByBarCodeADF, ModelDetailJson, null);
    }

    private void initAdapter() {
        receiptScanAdapter = new ReceiptScanAdapter();
        receiptScanAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
        InitFrm();
//            InStockDetailInfo inStockDetailInfo = new InStockDetailInfo();
//            inStockDetailInfo.setMaterialNo("241-179938(63-01)");
//            inStockDetailInfo.setMaterialDesc("T-shirt");
//            inStockDetailInfo.setRemainQty(120f);
//            inStockDetailInfo.setScanQty(0f);
//            inStockDetailInfo.setRowNo("1");
//            inStockDetailInfos.add(inStockDetailInfo);
//
//        inStockDetailInfo = new InStockDetailInfo();
//        inStockDetailInfo.setMaterialNo("240-179935(65-03)");
//        inStockDetailInfo.setMaterialDesc("长绒棉四件套");
//        inStockDetailInfo.setRemainQty(100f);
//        inStockDetailInfo.setScanQty(0f);
//        inStockDetailInfo.setRowNo("1");
//        inStockDetailInfos.add(inStockDetailInfo);
//
//        inStockDetailInfo = new InStockDetailInfo();
//        inStockDetailInfo.setMaterialNo("230-185420(09-01)");
//        inStockDetailInfo.setMaterialDesc("民光全棉印花被套");
//        inStockDetailInfo.setRemainQty(10f);
//        inStockDetailInfo.setScanQty(0f);
//        inStockDetailInfo.setRowNo("1");
//        inStockDetailInfos.add(inStockDetailInfo);
//
//
//        inStockDetailInfo = new InStockDetailInfo();
//        inStockDetailInfo.setMaterialNo("210-082410(11-01)");
//        inStockDetailInfo.setMaterialDesc("全棉时尚四件套");
//        inStockDetailInfo.setRemainQty(19f);
//        inStockDetailInfo.setScanQty(0f);
//        inStockDetailInfo.setRowNo("1");
//        inStockDetailInfos.add(inStockDetailInfo);
//
//        inStockDetailInfo = new InStockDetailInfo();
//        inStockDetailInfo.setMaterialNo("213-072411(12-01)");
//        inStockDetailInfo.setMaterialDesc("凤凰凯杰尔提花毯");
//        inStockDetailInfo.setRemainQty(8f);
//        inStockDetailInfo.setScanQty(0f);
//        inStockDetailInfo.setRowNo("1");

    }

    void  InitFrm(){
        inStockDetailInfos=new ArrayList<>();
        inStockDetailInfosUnit=new ArrayList<>();
        materialInfos=new ArrayList<>();
        edtScanbarcode.setText("");
        edtScanQty.setText("1");
        BindRecycleView();
        CommonUtil.setEditFocus(edtScanbarcode);
    }

    private void BindRecycleView(){
        if(inStockDetailInfos!=null){
            receiptScanAdapter.setNewData(inStockDetailInfos);
            rvReceiptDetail.setAdapter(receiptScanAdapter);
        }
    }

    void GetT_InStockDetailInfo(InStockInfo inStockInfo){
        receiptScanAdapter.setEnableLoadMore(false);
        try {
            final InStockDetailInfo inStockDetailInfo = new InStockDetailInfo();
            inStockDetailInfo.setHeaderID(inStockInfo.getID());
            inStockDetailInfo.setErpVoucherNo(inStockInfo.getErpVoucherNo());
            inStockDetailInfo.setVoucherType(inStockInfo.getVoucherType());
            inStockDetailInfo.setUserID(CommonModel.userInfo.getID());
            String  ModelDetailJson=GsonUtil.parseModelToJson(inStockDetailInfo);
            LogUtil.WriteLog(ReceiptScan.class, TAG_GetT_InStockDetailListByHeaderIDADF, ModelDetailJson);
            RequestHandler.addRequestWithDialog(Request.Method.POST, TAG_GetT_InStockDetailListByHeaderIDADF,
                    getString(R.string.Msg_GetT_InStockDetailListByHeaderIDADF), context, mHandler,
                    RESULT_GetT_InStockDetailListByHeaderIDADF, null,
                    URLModel.GetURL().GetT_InStockDetailListByHeaderIDADF, ModelDetailJson, null);

        } catch (Exception ex) {
            receiptScanAdapter.setEnableLoadMore(true);
            MessageBox.Show(context, ex.getMessage());
        }
    }



    void AnalysisGetT_InStockDetailListJson(String result){
        LogUtil.WriteLog(ReceiptScan.class, TAG_GetT_InStockDetailListByHeaderIDADF,result);
        try {
            ReturnMsgModelList<InStockDetailInfo> returnMsgModel = GsonUtil.getGsonUtil().fromJson(result,
                    new TypeToken<ReturnMsgModelList<InStockDetailInfo>>() {
                    }.getType());
            if (returnMsgModel.getHeaderStatus().equals("S")) {
                inStockDetailInfos = returnMsgModel.getModelJson();
                inStockDetailInfosUnit=new ArrayList<>();
                for (InStockDetailInfo inStockDetailInfo: inStockDetailInfos) {
                   int index= inStockDetailInfosUnit.indexOf(inStockDetailInfo);
                   if(index==-1){
                       inStockDetailInfosUnit.add(inStockDetailInfo);
                   }else{
                       inStockDetailInfosUnit.get(index).setRemainQty(ArithUtil.add(inStockDetailInfosUnit.get(index).getRemainQty(),inStockDetailInfo.getRemainQty()));
                   }
                }
                BindRecycleView();
            } else {
                MessageBox.Show(context,returnMsgModel.getMessage());
            }
        }catch (Exception ex) {
            MessageBox.Show(context,ex.getMessage());
        }
        CommonUtil.setEditFocus(edtScanbarcode);
    }

    void AnalysisGetT_PalletDetailByNoADF(String result){
        LogUtil.WriteLog(ReceiptScan.class, TAG_GetT_InStockDetailListByHeaderIDADF,result);
        try {
            ReturnMsgModelList<MaterialInfo> returnMsgModel = GsonUtil.getGsonUtil().fromJson(result,
                    new TypeToken<ReturnMsgModelList<MaterialInfo>>() {
                    }.getType());
            if (returnMsgModel.getHeaderStatus().equals("S")) {
                materialInfos = returnMsgModel.getModelJson();
                if(CheckMaterial(materialInfos)) {
                    MessageBox.Show(context, getString(R.string.Error_BarcodeNotInList));
                    return;
                }

                if(CommonModel.IsInputQty) {
                    CommonUtil.setEditFocus(edtScanQty);
                    return;
                }
                CheckOrderQtyByMaterial(materialInfos,1f);

            } else {
                MessageBox.Show(context,returnMsgModel.getMessage());
            }
        }catch (Exception ex) {
            MessageBox.Show(context,ex.getMessage());
        }
        CommonUtil.setEditFocus(edtScanbarcode);
    }


    void AnalysisGetAreaModelADFJson(String result){
        try {
            LogUtil.WriteLog(ReceiptScan.class, TAG_GetAreaModelADF, result);
            ReturnMsgModel<AreaInfo> returnMsgModel = GsonUtil.getGsonUtil().fromJson(result, new TypeToken<ReturnMsgModel<AreaInfo>>() {
            }.getType());
            if (returnMsgModel.getHeaderStatus().equals("S")) {
                AreaInfo areaInfoModel = returnMsgModel.getModelJson();
                for(int i=0;i<inStockDetailInfos.size();i++){
                    inStockDetailInfos.get(i).setAreaID(areaInfoModel.getID());
                    inStockDetailInfos.get(i).setUserID(CommonModel.userInfo.getID());
                    inStockDetailInfos.get(i).setWareHouseID(CommonModel.userInfo.getWarehouseID());
                }
                String  ModelDetailJson=GsonUtil.parseModelToJson(inStockDetailInfos);
                RequestHandler.addRequestWithDialog(Request.Method.POST, TAG_SaveT_InStockDetailADF,
                        getString(R.string.Msg_SaveT_InStockDetailADF),
                        context, mHandler, RESULT_SaveT_InStockDetailADF, null,
                        URLModel.GetURL().SaveT_InStockDetailADF, ModelDetailJson, null);

            } else {
                MessageBox.Show(context, returnMsgModel.getMessage());
            }
        }catch (Exception  ex){
            MessageBox.Show(context, ex.getMessage());
        }
    }

    void AnalysisSaveT_InStockDetailADFJson(String result){
        try {
            LogUtil.WriteLog(ReceiptScan.class, TAG_SaveT_InStockDetailADF,result);
            final ReturnMsgModel<Base_Model> returnMsgModel =  GsonUtil.getGsonUtil().fromJson(result, new TypeToken<ReturnMsgModel<Base_Model>>() {
            }.getType());
            if(returnMsgModel.getHeaderStatus().equals("S")){
                InitFrm();

            }else {
                MessageBox.Show(context, returnMsgModel.getMessage());
            }
        } catch (Exception ex) {
            MessageBox.Show(context, ex.getMessage());
        }
    }

    Boolean CheckMaterial(ArrayList<MaterialInfo> materialInfos){
        if(materialInfos==null){
            return false;
        }
        MaterialInfo materialInfo=materialInfos.get(0);
        txtMeterialName.setText(materialInfo.getMaterialDesc());
        InStockDetailInfo inStockDetailInfo=new InStockDetailInfo(materialInfo.getBarCodeEAN());
        int index=inStockDetailInfos.indexOf(inStockDetailInfo);
        return index==-1?true:false;
    }


    void CheckOrderQtyByMaterial(ArrayList<MaterialInfo> materialInfos,Float scanQty){
        if(materialInfos==null){
            return;
        }

        MaterialInfo materialInfo=materialInfos.get(0);
        InStockDetailInfo inStockDetailInfo=new InStockDetailInfo(materialInfo.getBarCodeEAN());
        int index=inStockDetailInfosUnit.indexOf(inStockDetailInfo);
        if(index!=-1){
           Float qty=ArithUtil.sub(inStockDetailInfosUnit.get(index).getRemainQty(),scanQty);
           if(qty<0f){
               MessageBox.Show(context,getString(R.string.Error_Num));
               return;
           }
        }

        Float RemainQty=0f;
        int size=inStockDetailInfos.size();
        for(int i=0;i<size;i++){
            if(inStockDetailInfos.get(i).getBarCodeEAN().equals(materialInfo.getBarCodeEAN())){
                Float canScanQty=ArithUtil.sub(inStockDetailInfos.get(i).getRemainQty(),inStockDetailInfos.get(i).getScanQty()); //可扫描数量
                RemainQty=ArithUtil.sub(canScanQty,scanQty); //扫描之后剩余数量
                Float addQty=ArithUtil.add(inStockDetailInfos.get(i).getScanQty(),(RemainQty>=0f?scanQty:canScanQty)); //扫描之后扫描数量
                if(RemainQty>=0){
                    inStockDetailInfos.get(i).setScanQty(addQty);
                    break;
                }else {
                    inStockDetailInfos.get(i).setScanQty(addQty);
                    scanQty=ArithUtil.sub(scanQty,canScanQty); //赋值后剩余扫描数量
                }
                inStockDetailInfosUnit.get(index).setRemainQty(ArithUtil.sub(inStockDetailInfosUnit.get(index).getRemainQty(),addQty)); //合计数量修改
            }
        }
        BindRecycleView();
    }
}

package xx.com.module_delivery;

import android.content.Context;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
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
import com.xx.chinetek.chineteklib.util.function.DoubleClickCheck;
import com.xx.chinetek.chineteklib.util.function.GsonUtil;
import com.xx.chinetek.chineteklib.util.log.LogUtil;

import java.util.ArrayList;

import butterknife.BindView;
import xx.com.Adapter.DeliveryScanAdapter;
import xx.com.Model.OutStockTaskDetailsInfo;
import xx.com.Model.OutStockTaskInfo;
import xx.com.lib_common.Common_Model.Action.DeliveryActions;
import xx.com.lib_common.Common_Model.CommonModel;
import xx.com.lib_common.Common_Model.Model.Base_Model;
import xx.com.lib_common.Common_Model.Model.Stock.StockInfo;
import xx.com.lib_common.Common_Model.URLModel;

import static xx.com.lib_common.Common_Model.URLModel.RESULT_GetStockModelADF;
import static xx.com.lib_common.Common_Model.URLModel.RESULT_GetT_OutTaskDetailListByHeaderIDADF;
import static xx.com.lib_common.Common_Model.URLModel.RESULT_SaveT_OutStockTaskDetailADF;
import static xx.com.lib_common.Common_Model.URLModel.TAG_GetStockModelADF;
import static xx.com.lib_common.Common_Model.URLModel.TAG_GetT_OutTaskDetailListByHeaderIDADF;
import static xx.com.lib_common.Common_Model.URLModel.TAG_SaveT_OutStockTaskDetailADF;

@Route(path = DeliveryActions.Action_Delivery_Scan)
public class DeliveryScan extends BaseActivity implements View.OnKeyListener{

    Context context = DeliveryScan.this;
    @BindView(R2.id.edt_Scanbarcode)
    EditText edtScanbarcode;
    @BindView(R2.id.edt_ScanQty)
    EditText edtScanQty;
    @BindView(R2.id.txt_SugestStock)
    TextView txtSugestStock;
    @BindView(R2.id.txt_currentPickNum)
    TextView txtCurrentPickNum;
    @BindView(R2.id.txt_VoucherNo)
    TextView txtVoucherNo;
    @BindView(R2.id.txt_ItemName)
    TextView txtItemName;
    @BindView(R2.id.rv_DeliveryDetail)
    RecyclerView rvDeliveryDetail;
    @BindView(R2.id.edt_AreaNo)
    EditText edtAreaNo;


    ArrayList<OutStockTaskDetailsInfo> outStockTaskDetailsInfos;
    ArrayList<OutStockTaskDetailsInfo> outStockTaskDetailsInfosUnit;//合并数量单据明细

    DeliveryScanAdapter deliveryScanAdapter;
    ArrayList<StockInfo> stockInfos; //扫描返回实体类
    int StockScanIndex=-1;//多库位扫描选择项

    @Override
    public void onHandleMessage(Message msg) {
        deliveryScanAdapter.setEnableLoadMore(true);
        switch (msg.what) {
            case RESULT_GetT_OutTaskDetailListByHeaderIDADF:
                Analysis_GetT_OutTaskDetailListJson((String) msg.obj);
                break;
            case RESULT_GetStockModelADF:
                Analysis_GetStockModelADFJson((String) msg.obj);
                break;
            case RESULT_SaveT_OutStockTaskDetailADF:
                AnalysisSaveT_OutStockTaskDetailADFJson((String) msg.obj);
                break;
            case NetworkError.NET_ERROR_CUSTOM:
                ToastUtil.show("获取请求失败_____"+ msg.obj);
                CommonUtil.setEditFocus(edtScanbarcode);
                break;
        }
    }

    @Override
    protected void initViews() {
        BaseApplication.toolBarTitle = new ToolBarTitle(getString(R.string.delivery), getString(R.string.deliveryScan));
        setContentView(R.layout.activity_delivery_scan);
        super.initViews();
        rvDeliveryDetail.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void initData() {
        super.initData();
        OutStockTaskInfo outStockTaskInfo = getIntent().getParcelableExtra("outStockTaskInfo");
        txtVoucherNo.setText(outStockTaskInfo.getTaskNo() == null ? "" : outStockTaskInfo.getTaskNo());
        initAdapter();
        GetT_OutTaskDetailInfo(outStockTaskInfo);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_deliveryscan, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_Submit) {
            if (DoubleClickCheck.isFastDoubleClick(context)) {
                return false;
            }
            String  ModelDetailJson=GsonUtil.parseModelToJson(outStockTaskDetailsInfos);
            LogUtil.WriteLog(DeliveryScan.class, TAG_SaveT_OutStockTaskDetailADF,ModelDetailJson);
            RequestHandler.addRequestWithDialog(Request.Method.POST, TAG_SaveT_OutStockTaskDetailADF,
                    getString(R.string.Msg_SaveT_OutStockTaskDetailADF),
                    context, mHandler, RESULT_SaveT_OutStockTaskDetailADF, null,
                    URLModel.GetURL().SaveT_OutStockTaskDetailADF, ModelDetailJson, null);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
        if (keyCode == KeyEvent.KEYCODE_ENTER && keyEvent.getAction() == KeyEvent.ACTION_UP) {
            int vid = view.getId();
            keyBoardCancle();
            if (vid == R.id.edt_Scanbarcode) {
                String code=edtScanbarcode.getText().toString().trim();
                DealBarcode(code);
            } else if (vid == R.id.edt_AreaNo) {
                String Areano=edtAreaNo.getText().toString().trim();
                if (stockInfos != null && stockInfos.size() != 0) {
                    StockScanIndex=-1;
                    //判断库位是否存在
                    for (int i=0;i<stockInfos.size();i++) {
                        if(stockInfos.get(i).getAreaNo().equals(Areano)){
                            StockScanIndex=i;
                            break;
                        }
                    }
                    if(StockScanIndex==-1){
                        MessageBox.Show(context,getString(R.string.Msg_AreaNoNotINStock));
                        CommonUtil.setEditFocus(edtAreaNo);
                        return true;
                    }
                    edtScanQty.setText(stockInfos.get(StockScanIndex).getQty()+"");
                    CommonUtil.setEditFocus(edtScanQty);
                }

            }else if (vid == R.id.edt_ScanQty) {
                //判断数量超出，自动分配数量
                String code=edtScanQty.getText().toString();
                if(!CommonUtil.isFloat(code)){
                    MessageBox.Show(context,getString(R.string.Error_isnotnum));
                    CommonUtil.setEditFocus(edtScanQty);
                    return true;
                }
                Float scanQty=Float.parseFloat(code);
                CheckOrderQtyByMaterial(scanQty);
                edtScanQty.setText("1");
                CommonUtil.setEditFocus(edtScanbarcode);
            }
            return true;
        }
        return false;
    }

    private void initAdapter() {
        deliveryScanAdapter = new DeliveryScanAdapter();
        deliveryScanAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
        InitFrm();
    }

    private void BindRecycleView(){
        if(outStockTaskDetailsInfos!=null){
            deliveryScanAdapter.setNewData(outStockTaskDetailsInfos);
            rvDeliveryDetail.setAdapter(deliveryScanAdapter);
        }
    }

    void CheckOrderQtyByMaterial( Float scanQty){
        if(stockInfos==null){
            return;
        }

        StockInfo stockInfo=stockInfos.get(StockScanIndex);
        if(scanQty>stockInfo.getQty()){
            MessageBox.Show(context,getString(R.string.Error_StockIsNotMore));
            return;
        }

        OutStockTaskDetailsInfo outStockTaskDetailsInfo=new OutStockTaskDetailsInfo(stockInfo.getBarCodeEAN());
        int index=outStockTaskDetailsInfosUnit.indexOf(outStockTaskDetailsInfo);
        if(index!=-1){
            Float qty=ArithUtil.sub(outStockTaskDetailsInfosUnit.get(index).getRemainQty(),scanQty);
            if(qty<0f){
                MessageBox.Show(context,getString(R.string.Error_Num));
                return;
            }
        }

        Float RemainQty=0f;
        int size=outStockTaskDetailsInfos.size();
        for(int i=0;i<size;i++){
            if(outStockTaskDetailsInfos.get(i).getBarCodeEAN().equals(stockInfo.getBarCodeEAN())){
                Float canScanQty=ArithUtil.sub(outStockTaskDetailsInfos.get(i).getRemainQty(),outStockTaskDetailsInfos.get(i).getScanQty()); //可扫描数量
                RemainQty=ArithUtil.sub(canScanQty,scanQty); //扫描之后剩余数量
                Float addQty=ArithUtil.add(outStockTaskDetailsInfos.get(i).getScanQty(),(RemainQty>=0f?scanQty:canScanQty)); //扫描之后扫描数量
                if(outStockTaskDetailsInfos.get(i).getLstStockInfo()==null)
                    outStockTaskDetailsInfos.get(i).setLstStockInfo(new ArrayList<StockInfo>());
                stockInfo.setScanQty(addQty);
                outStockTaskDetailsInfos.get(i).getLstStockInfo().add(stockInfo);
                if(RemainQty>=0){
                    outStockTaskDetailsInfos.get(i).setScanQty(addQty);
                    break;
                }else {
                    outStockTaskDetailsInfos.get(i).setScanQty(addQty);
                    scanQty=ArithUtil.sub(scanQty,canScanQty); //赋值后剩余扫描数量
                }
                outStockTaskDetailsInfosUnit.get(index).setRemainQty(ArithUtil.sub(outStockTaskDetailsInfosUnit.get(index).getRemainQty(),addQty)); //合计数量修改
            }
        }
        BindRecycleView();
    }




    void GetT_OutTaskDetailInfo(OutStockTaskInfo outStockTaskInfo) {
        deliveryScanAdapter.setEnableLoadMore(false);
        if (outStockTaskInfo != null) {
            String ModelDetailJson = GsonUtil.parseModelToJson(outStockTaskInfo);
            LogUtil.WriteLog(DeliveryScan.class, TAG_GetT_OutTaskDetailListByHeaderIDADF, ModelDetailJson);
            RequestHandler.addRequestWithDialog(Request.Method.POST, TAG_GetT_OutTaskDetailListByHeaderIDADF,
                    getString(R.string.Msg_GetT_OutTaskDetailListByHeaderIDADF), context, mHandler,
                    RESULT_GetT_OutTaskDetailListByHeaderIDADF, null,
                    URLModel.GetURL().GetT_OutTaskDetailListByHeaderIDADF, ModelDetailJson, null);
        }
    }

    void  Analysis_GetT_OutTaskDetailListJson(String result){
        LogUtil.WriteLog(DeliveryScan.class, TAG_GetT_OutTaskDetailListByHeaderIDADF,result);
        try {
            ReturnMsgModelList<OutStockTaskDetailsInfo> returnMsgModel = GsonUtil.getGsonUtil()
                    .fromJson(result, new TypeToken<ReturnMsgModelList<OutStockTaskDetailsInfo>>() {
                    }.getType());
            if (returnMsgModel.getHeaderStatus().equals("S")) {
                outStockTaskDetailsInfos = returnMsgModel.getModelJson();
                if (outStockTaskDetailsInfos != null && outStockTaskDetailsInfos.size() > 0)
                    outStockTaskDetailsInfosUnit = new ArrayList<>();
                for (OutStockTaskDetailsInfo outStockTaskDetailsInfo : outStockTaskDetailsInfos) {
                    int index = outStockTaskDetailsInfosUnit.indexOf(outStockTaskDetailsInfo);
                    if (index == -1) {
                        outStockTaskDetailsInfosUnit.add(outStockTaskDetailsInfo);
                    } else {
                        outStockTaskDetailsInfosUnit.get(index).setRemainQty(ArithUtil.add(
                                outStockTaskDetailsInfosUnit.get(index).getRemainQty(), outStockTaskDetailsInfo.getRemainQty()));
                    }
                }

                BindRecycleView();
                ShowPickMaterial(outStockTaskDetailsInfos.get(0));
            } else {
                MessageBox.Show(context, returnMsgModel.getMessage());
            }
        }catch (Exception ex) {
            MessageBox.Show(context,ex.getMessage());
        }
        CommonUtil.setEditFocus(edtScanbarcode);
    }


    private void DealBarcode(String code){
        if(TextUtils.isEmpty(code)){
            MessageBox.Show(context,getString(R.string.hint_scan_barcode));
            return;
        }
        stockInfos=new ArrayList<>();
        StockInfo stockInfo=new StockInfo();
        stockInfo.setSerialNo(code);
        stockInfo.setUserID(CommonModel.userInfo.getID());
        stockInfo.setMoveType("1");//1：下架 2:移库
        String  ModelDetailJson=GsonUtil.parseModelToJson(stockInfo);
        LogUtil.WriteLog(DeliveryScan.class, TAG_GetStockModelADF, ModelDetailJson);
        RequestHandler.addRequestWithDialog(Request.Method.POST, TAG_GetStockModelADF,
                getString(R.string.Msg_GetStockModelADF), context, mHandler,
                RESULT_GetStockModelADF, null,
                URLModel.GetURL().GetStockModelADF, ModelDetailJson, null);
    }

    void Analysis_GetStockModelADFJson(String result){
        LogUtil.WriteLog(DeliveryScan.class, TAG_GetStockModelADF, result);
        try {
            ReturnMsgModelList<StockInfo> returnMsgModel = GsonUtil.getGsonUtil().fromJson(result, new TypeToken<ReturnMsgModelList<StockInfo>>() {
            }.getType());
            if (returnMsgModel.getHeaderStatus().equals("S")) {
                stockInfos = returnMsgModel.getModelJson();
                if (stockInfos != null && stockInfos.size() != 0) {
                    txtItemName.setText(stockInfos.get(0).getMaterialDesc());
                    if(stockInfos.size()==1){
                        StockScanIndex=0;
                        edtAreaNo.setText(stockInfos.get(0).getAreaNo());
                        edtScanQty.setText(stockInfos.get(0).getQty()+"");
                        CommonUtil.setEditFocus(edtScanQty);
                    }else{
                        CommonUtil.setEditFocus(edtAreaNo);
                    }
                }
            } else {
                MessageBox.Show(context, returnMsgModel.getMessage());
                CommonUtil.setEditFocus(edtScanbarcode);
            }
        } catch (Exception ex) {
            MessageBox.Show(context, ex.getMessage());
            CommonUtil.setEditFocus(edtScanbarcode);
        }
    }

    void AnalysisSaveT_OutStockTaskDetailADFJson(String result){
        try {
            LogUtil.WriteLog(DeliveryScan.class, TAG_SaveT_OutStockTaskDetailADF,result);
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

    void  InitFrm(){
        outStockTaskDetailsInfos=new ArrayList<>();
        outStockTaskDetailsInfosUnit=new ArrayList<>();
        stockInfos=new ArrayList<>();
        edtScanbarcode.setText("");
        edtScanQty.setText("1");
        edtAreaNo.setText("");
        BindRecycleView();
        CommonUtil.setEditFocus(edtScanbarcode);
    }

    void  ShowPickMaterial(OutStockTaskDetailsInfo outStockTaskDetailsInfo){
        txtItemName.setText(outStockTaskDetailsInfo.getMaterialDesc());
        txtCurrentPickNum.setText(outStockTaskDetailsInfo.getRePickQty()+"");
        txtSugestStock.setText(outStockTaskDetailsInfo.getAreaNo());
    }
    //
//            OutStockTaskDetailsInfo outStockTaskDetailsInfo = new OutStockTaskDetailsInfo();
//            outStockTaskDetailsInfo.setMaterialNo("240-179935(65-03)");
//            outStockTaskDetailsInfo.setMaterialDesc("长绒棉四件套");
//            outStockTaskDetailsInfo.setRePickQty(3f);
//            outStockTaskDetailsInfo.setScanQty(0f);
//            outStockTaskDetailsInfo.setAreaNo("A0101");
//            outStockTaskDetailsInfo.setRowNo("1");
//            outStockTaskDetailsInfos.add(outStockTaskDetailsInfo);
//
//        outStockTaskDetailsInfo = new OutStockTaskDetailsInfo();
//        outStockTaskDetailsInfo.setMaterialNo("240-179935(65-03)");
//        outStockTaskDetailsInfo.setMaterialDesc("长绒棉四件套");
//        outStockTaskDetailsInfo.setRePickQty(1f);
//        outStockTaskDetailsInfo.setScanQty(0f);
//        outStockTaskDetailsInfo.setAreaNo("A0102");
//        outStockTaskDetailsInfo.setRowNo("2");
//        outStockTaskDetailsInfos.add(outStockTaskDetailsInfo);
//
//        outStockTaskDetailsInfo = new OutStockTaskDetailsInfo();
//        outStockTaskDetailsInfo.setMaterialNo("210-082410(11-01)");
//        outStockTaskDetailsInfo.setMaterialDesc("全棉时尚四件套");
//        outStockTaskDetailsInfo.setRePickQty(10f);
//        outStockTaskDetailsInfo.setScanQty(0f);
//        outStockTaskDetailsInfo.setAreaNo("A0106");
//        outStockTaskDetailsInfo.setRowNo("1");
//        outStockTaskDetailsInfos.add(outStockTaskDetailsInfo);
//
//        outStockTaskDetailsInfo = new OutStockTaskDetailsInfo();
//        outStockTaskDetailsInfo.setMaterialNo("213-072411(12-01)");
//        outStockTaskDetailsInfo.setMaterialDesc("凤凰凯杰尔提花毯");
//        outStockTaskDetailsInfo.setRePickQty(2f);
//        outStockTaskDetailsInfo.setScanQty(0f);
//        outStockTaskDetailsInfo.setAreaNo("A0105");
//        outStockTaskDetailsInfo.setRowNo("1");
//        outStockTaskDetailsInfos.add(outStockTaskDetailsInfo);

}

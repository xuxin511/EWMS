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
import com.alibaba.android.arouter.launcher.ARouter;
import com.android.volley.Request;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.reflect.TypeToken;
import com.xx.chinetek.chineteklib.base.BaseActivity;
import com.xx.chinetek.chineteklib.base.BaseApplication;
import com.xx.chinetek.chineteklib.base.ToolBarTitle;
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
import xx.com.Adapter.CheckScanAdapter;
import xx.com.Model.OutStockDetailInfo;
import xx.com.Model.OutStockInfo;
import xx.com.Model.OutStockTaskDetailsInfo;
import xx.com.lib_common.Common_Model.Action.DeliveryActions;
import xx.com.lib_common.Common_Model.Model.Stock.StockInfo;
import xx.com.lib_common.Common_Model.URLModel;

import static xx.com.lib_common.Common_Model.URLModel.RESULT_GetT_OutStockReviewDetailListByHeaderIDADF;
import static xx.com.lib_common.Common_Model.URLModel.RESULT_ScanOutStockReviewByBarCodeADF;
import static xx.com.lib_common.Common_Model.URLModel.TAG_GetT_OutStockReviewDetailListByHeaderIDADF;
import static xx.com.lib_common.Common_Model.URLModel.TAG_ScanOutStockReviewByBarCodeADF;

@Route(path = DeliveryActions.Action_Check_Scan)
public class CheckScan extends BaseActivity implements View.OnKeyListener {

    Context context=CheckScan.this;

    @BindView(R2.id.edt_Scanbarcode)
    EditText edtScanbarcode;
    @BindView(R2.id.edt_ScanQty)
    EditText edtScanQty;
    @BindView(R2.id.txt_CustomName)
    TextView txtCustomName;
    @BindView(R2.id.txt_VoucherNo)
    TextView txtVoucherNo;
    @BindView(R2.id.txt_ItemName)
    TextView txtItemName;
    @BindView(R2.id.rv_CheckDetail)
    RecyclerView rvCheckDetail;

    CheckScanAdapter checkScanAdapter;
    ArrayList<OutStockDetailInfo> outStockDetailInfos;
    ArrayList<OutStockDetailInfo> outStockDetailInfosUnit; //合并数量单据明细
    ArrayList<StockInfo> stockInfos;//扫描条码结果

    @Override
    public void onHandleMessage(Message msg) {
        switch (msg.what) {
            case RESULT_GetT_OutStockReviewDetailListByHeaderIDADF:
                Analysis_GetT_OutStockReviewDetailListByHeaderIDADFJson((String) msg.obj);
                break;
            case RESULT_ScanOutStockReviewByBarCodeADF:
                AnalysiseScanOutStockReviewByBarCodeADFJson((String) msg.obj);
                break;
            case NetworkError.NET_ERROR_CUSTOM:
                ToastUtil.show("获取请求失败_____"+ msg.obj);
                CommonUtil.setEditFocus(edtScanbarcode);
                break;
        }
    }

    @Override
    protected void initViews() {
        BaseApplication.toolBarTitle = new ToolBarTitle(getString(R.string.check), getString(R.string.checkScan));
        setContentView(R.layout.activity_check_scan);
        super.initViews();
        rvCheckDetail.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void initData() {
        super.initData();
        OutStockInfo outStockInfo = getIntent().getParcelableExtra("outStockInfo");
        txtVoucherNo.setText(outStockInfo.getVoucherNo());
        txtCustomName.setText(outStockInfo.getCustomerName());
      //  txtItemName.setText("长绒棉四件套");
        initAdapter();
        GetT_CheckDetailInfo(outStockInfo);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_checkscan, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_Weigh) {
            if (DoubleClickCheck.isFastDoubleClick(context)) {
                return false;
            }
//            Boolean isFinishReceipt = true;
//            for (OutStockDetailInfo outStockDetailInfoModel : outStockDetailInfos) {
//                outStockDetailInfoModel.setUserID(CommonModel.userInfo.getID());
//                if (outStockDetailInfoModel.getScanQty().compareTo(outStockDetailInfoModel.getOutStockQty()) != 0) {
//                    MessageBox.Show(context, getString(R.string.Error_CannotReview));
//                    isFinishReceipt = false;
//                    break;
//                }
//            }
//            if (isFinishReceipt) {
//                String  ModelDetailJson=GsonUtil.parseModelToJson(outStockDetailInfos);
//                LogUtil.WriteLog(CheckScan.class, TAG_SaveT_OutStockReviewDetailADF,ModelDetailJson);
//                RequestHandler.addRequestWithDialog(Request.Method.POST, TAG_SaveT_OutStockReviewDetailADF,
//                        getString(R.string.Msg_SaveT_OutStockTaskDetailADF),
//                        context, mHandler, RESULT_SaveT_OutStockReviewDetailADF, null,
//                        URLModel.GetURL().SaveT_OutStockReviewDetailADF, ModelDetailJson, null);
//            }


            ARouter.getInstance().build(DeliveryActions.Action_Check_Weigh)
                    .navigation();
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
                if(TextUtils.isEmpty(code)){
                    MessageBox.Show(context,getString(R.string.hint_scan_barcode));
                    return true;
                }
                stockInfos=new ArrayList<>();
                LogUtil.WriteLog(DeliveryScan.class, TAG_ScanOutStockReviewByBarCodeADF, code);
                RequestHandler.addRequestWithDialog(Request.Method.POST, TAG_ScanOutStockReviewByBarCodeADF,
                        getString(R.string.Msg_ScanOutStockReviewByBarCodeADF), context, mHandler,
                        RESULT_ScanOutStockReviewByBarCodeADF, null,
                        URLModel.GetURL().ScanOutStockReviewByBarCodeADF, code, null);
            } else if (vid == R.id.edt_ScanQty) {
                //判断数量超出，自动分配数量
                String code=edtScanQty.getText().toString();
                if(!CommonUtil.isFloat(code)){
                    MessageBox.Show(context,getString(R.string.Error_isnotnum));
                    CommonUtil.setEditFocus(edtScanQty);
                    return true;
                }
                Float scanQty=Float.parseFloat(code);
                CheckOrderQtyByMaterial(scanQty);
                edtScanQty.setText("");
                CommonUtil.setEditFocus(edtScanbarcode);
            }
            return true;
        }
        return false;
    }

    void GetT_CheckDetailInfo(OutStockInfo outStockInfo) {
        if (outStockInfo != null) {
            final OutStockDetailInfo outStockDetailInfo = new OutStockDetailInfo();
            outStockDetailInfo.setHeaderID(outStockInfo.getID());
            outStockDetailInfo.setErpVoucherNo(outStockInfo.getErpVoucherNo());
            outStockDetailInfo.setVoucherType(outStockInfo.getVoucherType());
            String ModelDetailJson = GsonUtil.parseModelToJson(outStockDetailInfo);
            LogUtil.WriteLog(DeliveryScan.class, TAG_GetT_OutStockReviewDetailListByHeaderIDADF, ModelDetailJson);
            RequestHandler.addRequestWithDialog(Request.Method.POST, TAG_GetT_OutStockReviewDetailListByHeaderIDADF,
                    getString(R.string.Msg_GetT_OutStockReviewDetailListByHeaderIDADF), context, mHandler,
                    RESULT_GetT_OutStockReviewDetailListByHeaderIDADF, null,
                    URLModel.GetURL().GetT_OutStockReviewDetailListByHeaderIDADF, ModelDetailJson, null);
        }
    }

    void Analysis_GetT_OutStockReviewDetailListByHeaderIDADFJson(String result){
        LogUtil.WriteLog(CheckScan.class, TAG_GetT_OutStockReviewDetailListByHeaderIDADF,result);
        try {
            ReturnMsgModelList<OutStockDetailInfo> returnMsgModel = GsonUtil.getGsonUtil()
                    .fromJson(result, new TypeToken<ReturnMsgModelList<OutStockDetailInfo>>() {
                    }.getType());
            if (returnMsgModel.getHeaderStatus().equals("S")) {
                outStockDetailInfos = returnMsgModel.getModelJson();
                if (outStockDetailInfos != null && outStockDetailInfos.size() > 0)
                    outStockDetailInfosUnit = new ArrayList<>();
                for (OutStockDetailInfo outStockDetailInfo : outStockDetailInfos) {
                    int index = outStockDetailInfosUnit.indexOf(outStockDetailInfo);
                    if (index == -1) {
                        outStockDetailInfosUnit.add(outStockDetailInfo);
                    } else {
                        outStockDetailInfosUnit.get(index).setRemainQty(ArithUtil.add(
                                outStockDetailInfosUnit.get(index).getRemainQty(), outStockDetailInfo.getRemainQty()));
                    }
                }
                BindRecycleView();
            } else {
                MessageBox.Show(context, returnMsgModel.getMessage());
            }
        }catch (Exception ex) {
            MessageBox.Show(context,ex.getMessage());
        }
        CommonUtil.setEditFocus(edtScanbarcode);
    }

    void AnalysiseScanOutStockReviewByBarCodeADFJson(String result){
        try {
            LogUtil.WriteLog(CheckScan.class, TAG_ScanOutStockReviewByBarCodeADF,result);
            ReturnMsgModelList<StockInfo> returnMsgModel =  GsonUtil.getGsonUtil()
                    .fromJson(result, new TypeToken<ReturnMsgModelList<StockInfo>>() {
            }.getType());
            if(returnMsgModel.getHeaderStatus().equals("S")){
               stockInfos=returnMsgModel.getModelJson();
               CommonUtil.setEditFocus(edtScanQty);
            }else
            {
                MessageBox.Show(context,returnMsgModel.getMessage());
                CommonUtil.setEditFocus(edtScanbarcode);
            }
        } catch (Exception ex) {
            MessageBox.Show(context, ex.getMessage());
            CommonUtil.setEditFocus(edtScanbarcode);
        }

    }

    void CheckOrderQtyByMaterial( Float scanQty){
        if(stockInfos==null){
            return;
        }

        StockInfo stockInfo=stockInfos.get(0);
        if(scanQty>stockInfo.getQty()){
            MessageBox.Show(context,getString(R.string.Error_StockIsNotMore));
            return;
        }

        OutStockTaskDetailsInfo outStockTaskDetailsInfo=new OutStockTaskDetailsInfo(stockInfo.getBarCodeEAN());
        int index=outStockDetailInfos.indexOf(outStockTaskDetailsInfo);
        if(index!=-1){
            Float qty=ArithUtil.sub(outStockDetailInfos.get(index).getRemainQty(),scanQty);
            if(qty<0f){
                MessageBox.Show(context,getString(R.string.Error_Num));
                return;
            }
        }

        Float RemainQty=0f;
        int size=outStockDetailInfos.size();
        for(int i=0;i<size;i++){
            if(outStockDetailInfos.get(i).getBarCodeEAN().equals(stockInfo.getBarCodeEAN())){
                Float canScanQty=ArithUtil.sub(outStockDetailInfos.get(i).getRemainQty(),outStockDetailInfos.get(i).getScanQty()); //可扫描数量
                RemainQty=ArithUtil.sub(canScanQty,scanQty); //扫描之后剩余数量
                Float addQty=ArithUtil.add(outStockDetailInfos.get(i).getScanQty(),(RemainQty>=0f?scanQty:canScanQty)); //扫描之后扫描数量
                if(RemainQty>=0){
                    outStockDetailInfos.get(i).setScanQty(addQty);
                    break;
                }else {
                    outStockDetailInfos.get(i).setScanQty(addQty);
                    scanQty=ArithUtil.sub(scanQty,canScanQty); //赋值后剩余扫描数量
                }
                outStockDetailInfosUnit.get(index).setRemainQty(ArithUtil.sub(outStockDetailInfosUnit.get(index).getRemainQty(),addQty)); //合计数量修改
            }
        }
        BindRecycleView();
    }

    private void initAdapter() {
        checkScanAdapter = new CheckScanAdapter();
        checkScanAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
        InitFrm();
        OutStockDetailInfo outStockTaskDetailsInfo = new OutStockDetailInfo();
        outStockTaskDetailsInfo.setMaterialNo("240-179935(65-03)");
        outStockTaskDetailsInfo.setMaterialDesc("长绒棉四件套");
        outStockTaskDetailsInfo.setRemainQty(3f);
        outStockTaskDetailsInfo.setScanQty(0f);
        outStockTaskDetailsInfo.setRowNo("1");
        outStockDetailInfos.add(outStockTaskDetailsInfo);

        checkScanAdapter.setNewData(outStockDetailInfos);
        rvCheckDetail.setAdapter(checkScanAdapter);
    }

    void  InitFrm(){
        outStockDetailInfos=new ArrayList<>();
        outStockDetailInfosUnit=new ArrayList<>();
        edtScanbarcode.setText("");
        edtScanQty.setText("1");
        BindRecycleView();
        CommonUtil.setEditFocus(edtScanbarcode);
    }

    private void BindRecycleView(){
        if(outStockDetailInfos!=null){
            checkScanAdapter.setNewData(outStockDetailInfos);
            rvCheckDetail.setAdapter(checkScanAdapter);
        }
    }
}

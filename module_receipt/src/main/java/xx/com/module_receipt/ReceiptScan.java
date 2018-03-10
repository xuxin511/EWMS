package xx.com.module_receipt;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import com.xx.chinetek.chineteklib.model.ReturnMsgModelList;
import com.xx.chinetek.chineteklib.util.Network.NetworkError;
import com.xx.chinetek.chineteklib.util.Network.RequestHandler;
import com.xx.chinetek.chineteklib.util.dialog.MessageBox;
import com.xx.chinetek.chineteklib.util.dialog.ToastUtil;
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
import xx.com.lib_common.Common_Model.URLModel;

import static xx.com.lib_common.Common_Model.URLModel.RESULT_Msg_GetT_InStockDetailListByHeaderIDADF;
import static xx.com.lib_common.Common_Model.URLModel.RESULT_Msg_GetT_PalletDetailByBarCode;
import static xx.com.lib_common.Common_Model.URLModel.RESULT_Msg_SaveT_InStockDetailADF;
import static xx.com.lib_common.Common_Model.URLModel.TAG_GetT_InStockDetailListByHeaderIDADF;

@Route(path= ReceiptActions.Action_Receipt_Scan)
public class ReceiptScan extends BaseActivity{

    Context context=ReceiptScan.this;

    @BindView(R2.id.txt_VoucherNo)
    TextView txtVoucherNo;
    @BindView(R2.id.txt_MeterialName)
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


    @Override
    public void onHandleMessage(Message msg) {
        receiptScanAdapter.setEnableLoadMore(true);
        switch (msg.what) {
            case RESULT_Msg_GetT_InStockDetailListByHeaderIDADF:
                AnalysisGetT_InStockDetailListJson((String) msg.obj);
                break;
            case RESULT_Msg_GetT_PalletDetailByBarCode:
               // AnalysisGetT_PalletDetailByNoADF((String) msg.obj);
                break;
            case RESULT_Msg_SaveT_InStockDetailADF:
              //  AnalysisSaveT_InStockDetailADFJson((String) msg.obj);
                break;
            case NetworkError.NET_ERROR_CUSTOM:
                ToastUtil.show("获取请求失败_____"+ msg.obj);
                CommonUtil.setEditFocus(edtScanbarcode);
                break;
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
                BindRecycleView();
            } else {
                MessageBox.Show(context,returnMsgModel.getMessage());
            }
        }catch (Exception ex) {
            MessageBox.Show(context,ex.getMessage());
        }
        CommonUtil.setEditFocus(edtScanbarcode);
    }

    @Override
    protected void initViews() {
        BaseApplication.toolBarTitle = new ToolBarTitle(getString(R.string.receipt_title), getString(R.string.receiptscan_title_sub));
        setContentView(R.layout.activity_receipt_scan);
        super.initViews();
        rvReceiptDetail.setLayoutManager(new LinearLayoutManager(this));
        edtScanQty.setVisibility(CommonModel.IsInputQty?View.VISIBLE:View.GONE);
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
       new AlertDialog.Builder(this).setTitle(getString(R.string.Msg_dialog_uploadArea))
               .setView(et)
               .setPositiveButton(getString(R.string.receipt_scan_upload), new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int which) {

                   }
               })
               .setNegativeButton(getString(R.string.common_cancel), null)
               .show();
   }



    private void initAdapter() {
        inStockDetailInfos=new ArrayList<>();
        receiptScanAdapter = new ReceiptScanAdapter();
        receiptScanAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
        for(int i=0;i<10;i++) {
            InStockDetailInfo inStockDetailInfo = new InStockDetailInfo();
            inStockDetailInfo.setMaterialNo("123333");
            inStockDetailInfo.setMaterialDesc("物料名称");
            inStockDetailInfo.setRemainQty(123f);
            inStockDetailInfo.setScanQty(0f);
            inStockDetailInfos.add(inStockDetailInfo);
        }
        receiptScanAdapter.setNewData(inStockDetailInfos);
        rvReceiptDetail.setAdapter(receiptScanAdapter);

    }


    private void BindRecycleView(){
        if(inStockDetailInfos!=null){
            receiptScanAdapter.notifyDataSetChanged();
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
                    RESULT_Msg_GetT_InStockDetailListByHeaderIDADF, null,
                    URLModel.GetURL().GetT_InStockDetailListByHeaderIDADF, ModelDetailJson, null);

        } catch (Exception ex) {
            receiptScanAdapter.setEnableLoadMore(true);
            MessageBox.Show(context, ex.getMessage());
        }
    }

}

package xx.com.module_wharehousefunc;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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
import com.xx.chinetek.chineteklib.util.function.CommonUtil;
import com.xx.chinetek.chineteklib.util.function.DoubleClickCheck;
import com.xx.chinetek.chineteklib.util.function.GsonUtil;
import com.xx.chinetek.chineteklib.util.log.LogUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import xx.com.Adapter.InnerMoveScanAdapter;
import xx.com.lib_common.Common_Model.Action.MainActions;
import xx.com.lib_common.Common_Model.CommonModel;
import xx.com.lib_common.Common_Model.Model.Area.AreaInfo;
import xx.com.lib_common.Common_Model.Model.Base_Model;
import xx.com.lib_common.Common_Model.Model.Stock.StockInfo;
import xx.com.lib_common.Common_Model.URLModel;

import static xx.com.lib_common.Common_Model.URLModel.RESULT_GetAreaModelADF;
import static xx.com.lib_common.Common_Model.URLModel.RESULT_GetStockModelADF;
import static xx.com.lib_common.Common_Model.URLModel.RESULT_SaveMoveStockToOutADF;
import static xx.com.lib_common.Common_Model.URLModel.TAG_GetAreaModelADF;
import static xx.com.lib_common.Common_Model.URLModel.TAG_GetStockModelADF;
import static xx.com.lib_common.Common_Model.URLModel.TAG_SaveMoveStockToOutADF;
import static xx.com.lib_common.Common_Model.URLModel.TAG_SaveT_OutStockTaskDetailADF;


@Route(path = MainActions.Action_Main_InnerMove)
public class InnerMove extends BaseActivity implements View.OnKeyListener{

    Context context = InnerMove.this;

    InnerMoveScanAdapter innerMoveScanAdapter;
    ArrayList<StockInfo> stockInfos; //扫描实体类
    ArrayList<StockInfo> stockInfosSubmit; //提交实体类

    AreaInfo outAreaInfoModel;
    int StockScanIndex=-1;//多库位扫描选择项

    @BindView(R2.id.edt_ScanAreaNo)
    EditText edtScanAreaNo;
    @BindView(R2.id.edt_Scanbarcode)
    EditText edtScanbarcode;
    @BindView(R2.id.edt_ScanQty)
    EditText edtScanQty;
    @BindView(R2.id.txt_ItemName)
    TextView txtItemName;
    @BindView(R2.id.rv_InnerMoveDetail)
    RecyclerView rvInnerMoveDetail;
    @BindView(R2.id.txt_OutAreaNo)
    TextView txtOutAreaNo;


    @Override
    public void onHandleMessage(Message msg) {
        switch (msg.what) {
            case RESULT_GetAreaModelADF:
                AnalysisGetAreaModelADFJson((String) msg.obj);
                break;
            case RESULT_GetStockModelADF:
                Analysis_GetStockModelADFJson((String) msg.obj);
                break;
            case RESULT_SaveMoveStockToOutADF:
                AnalysisSaveMoveStockToOutADFJson((String) msg.obj);
                break;
            case NetworkError.NET_ERROR_CUSTOM:
                ToastUtil.show("获取请求失败_____"+ msg.obj);
                CommonUtil.setEditFocus(edtScanbarcode);
                break;
        }
    }

    @Override
    protected void initViews() {
        BaseApplication.toolBarTitle = new ToolBarTitle(getString(R.string.innermove), getString(R.string.innermoveScan));
        setContentView(R.layout.activity_inner_move);
        super.initViews();
        rvInnerMoveDetail.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void initData() {
        super.initData();
        initAdapter();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_innermovescan, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_Upload) {
            if (DoubleClickCheck.isFastDoubleClick(context)) {
                return false;
            }
            String  ModelDetailJson=GsonUtil.parseModelToJson(stockInfosSubmit);
            LogUtil.WriteLog(InnerMove.class, TAG_SaveMoveStockToOutADF,ModelDetailJson);
            RequestHandler.addRequestWithDialog(Request.Method.POST, TAG_SaveMoveStockToOutADF,
                    getString(R.string.Msg_SaveMoveStockToOutADF),
                    context, mHandler, RESULT_SaveMoveStockToOutADF, null,
                    URLModel.GetURL().SaveMoveStockToOutADF, ModelDetailJson, null);
        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick(R2.id.txt_OutAreaNo)
    public void txt_OutAreaNoClick(View view) {
        if(stockInfos!=null && stockInfos.size()>1){
            List<String> AreaNos = new ArrayList<String>();
            for (StockInfo stockInfo :stockInfos) {
                if (stockInfo.getAreaNo() != null && !stockInfo.getAreaNo().equals("")) {
                    AreaNos.add(stockInfo.getAreaNo());
                }
            }
            final String[] items = AreaNos.toArray(new String[0]);
            new AlertDialog.Builder(context).setTitle(getResources().getString(R.string.ChoiceMoveAreaNo))// 设置对话框标题
                    .setIcon(android.R.drawable.ic_dialog_info)// 设置对话框图
                    .setItems(items, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // TODO 自动生成的方法存根
                            ShowMoveMaterial(which);
                            dialog.dismiss();
                        }
                    }).show();
        }
    }

    @Override
    public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
        if (keyCode == KeyEvent.KEYCODE_ENTER && keyEvent.getAction() == KeyEvent.ACTION_UP) {
            int vid = view.getId();
            keyBoardCancle();
            if (vid == R.id.edt_ScanAreaNo) {
                String AreaNo=edtScanAreaNo.getText().toString();
                AreaInfo areaInfo=new AreaInfo();
                areaInfo.setAreaNo(AreaNo);
                areaInfo.setWarehouseID(CommonModel.userInfo.getWarehouseID());
                String  ModelDetailJson= GsonUtil.parseModelToJson(areaInfo);
                LogUtil.WriteLog(InnerMove.class, TAG_GetAreaModelADF, ModelDetailJson);
                RequestHandler.addRequest(Request.Method.POST, TAG_GetAreaModelADF, mHandler, RESULT_GetAreaModelADF, null,
                        URLModel.GetURL().GetAreaModelADF, ModelDetailJson, null);

            }else if(vid == R.id.edt_Scanbarcode){
                String code=edtScanbarcode.getText().toString().trim();
                if(TextUtils.isEmpty(code)){
                    MessageBox.Show(context,getString(R.string.hint_scan_barcode));
                    return true;
                }
                StockScanIndex=-1;
                stockInfos=new ArrayList<>();
                StockInfo stockInfo=new StockInfo();
                stockInfo.setSerialNo(code);
                stockInfo.setUserID(CommonModel.userInfo.getID());
                stockInfo.setMoveType("2"); //1：下架 2:移库
                String  ModelDetailJson=GsonUtil.parseModelToJson(stockInfo);
                LogUtil.WriteLog(InnerMove.class, TAG_GetStockModelADF, ModelDetailJson);
                RequestHandler.addRequestWithDialog(Request.Method.POST, TAG_GetStockModelADF,
                        getString(R.string.Msg_InnerMoveGetStockModelADF), context, mHandler,
                        RESULT_GetStockModelADF, null,
                        URLModel.GetURL().GetStockModelADF, ModelDetailJson, null);

            }else if(vid == R.id.edt_ScanQty){
                String code=edtScanQty.getText().toString();
                if(!CommonUtil.isFloat(code)){
                    MessageBox.Show(context,getString(R.string.Error_isnotnum));
                    CommonUtil.setEditFocus(edtScanQty);
                    return true;
                }
                Float scanQty=Float.parseFloat(code);

                //判断是否超过库存数量
                if(StockScanIndex!=-1){
                    if(stockInfos.get(StockScanIndex).getQty()<scanQty){
                        MessageBox.Show(context,getString(R.string.Error_InnerMove_StockIsNotMore));
                        return true;
                    }
                    StockInfo stockInfo=new StockInfo();
                    stockInfo.setVoucherType(9996);
                    stockInfo.setToErpAreaNo(outAreaInfoModel.getAreaNo());
                    stockInfo.setToErpWarehouse(outAreaInfoModel.getWarehouseNo());
                    stockInfo.setFromAreaID(stockInfos.get(StockScanIndex).getID());
                    stockInfo.setWareHouseID(stockInfos.get(StockScanIndex).getWareHouseID());
                    stockInfo.setUserID(CommonModel.userInfo.getID());
                    stockInfo.setScanQty(scanQty);
                    stockInfosSubmit.add(stockInfo);
                    InitFrm();
                }

            }
            return true;
        }
        return false;
    }


    void AnalysisGetAreaModelADFJson(String result) {
        try {
            LogUtil.WriteLog(InnerMove.class, TAG_GetAreaModelADF, result);
            ReturnMsgModel<AreaInfo> returnMsgModel = GsonUtil.getGsonUtil().fromJson(result, new TypeToken<ReturnMsgModel<AreaInfo>>() {
            }.getType());
            if (returnMsgModel.getHeaderStatus().equals("S")) {
                outAreaInfoModel = returnMsgModel.getModelJson();
                CommonUtil.setEditFocus(edtScanbarcode);
            } else {
                MessageBox.Show(context, returnMsgModel.getMessage());
                CommonUtil.setEditFocus(edtScanAreaNo);
            }
        } catch (Exception ex) {
            MessageBox.Show(context, ex.getMessage());
            CommonUtil.setEditFocus(edtScanAreaNo);
        }
    }

    void Analysis_GetStockModelADFJson(String result){
        LogUtil.WriteLog(InnerMove.class, TAG_GetStockModelADF, result);
        try {
            ReturnMsgModelList<StockInfo> returnMsgModel = GsonUtil.getGsonUtil().fromJson(result, new TypeToken<ReturnMsgModelList<StockInfo>>() {
            }.getType());
            if (returnMsgModel.getHeaderStatus().equals("S")) {
                stockInfos = returnMsgModel.getModelJson();
                if (stockInfos != null && stockInfos.size() != 0) {
                    ShowMoveMaterial(0);
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

    void AnalysisSaveMoveStockToOutADFJson(String result){
        try {
            LogUtil.WriteLog(InnerMove.class, TAG_SaveT_OutStockTaskDetailADF,result);
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

    private void BindRecycleView(){
        if(stockInfosSubmit!=null){
            innerMoveScanAdapter.setNewData(stockInfosSubmit);
            rvInnerMoveDetail.setAdapter(innerMoveScanAdapter);
        }
    }

    void  InitFrm(){
        StockScanIndex=-1;
        stockInfos = new ArrayList<>();
        stockInfosSubmit=new ArrayList<>();
        edtScanbarcode.setText("");
        edtScanAreaNo.setText("");
        edtScanQty.setText("1");
        txtOutAreaNo.setText("");
        BindRecycleView();
        CommonUtil.setEditFocus(edtScanbarcode);
    }

    private void initAdapter() {


        innerMoveScanAdapter = new InnerMoveScanAdapter();
        innerMoveScanAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
        InitFrm();
//        StockInfo stockInfo = new StockInfo();
//        stockInfo.setMaterialNo("240-179935(65-03)");
//        stockInfo.setMaterialDesc("长绒棉四件套");
//        stockInfo.setFromAreaNo("A0102");
//        stockInfo.setToAreaNo("A0101");
//        stockInfo.setQty(1f);
//        stockInfos.add(stockInfo);
//        stockInfo = new StockInfo();
//        stockInfo.setMaterialNo("213-072411(12-01)");
//        stockInfo.setMaterialDesc("凤凰凯杰尔提花毯");
//        stockInfo.setFromAreaNo("A0103");
//        stockInfo.setToAreaNo("A0101");
//        stockInfo.setQty(2f);
//        stockInfos.add(stockInfo);



    }
    void  ShowMoveMaterial(int index){
        txtItemName.setText(stockInfos.get(index).getMaterialDesc());
        StockScanIndex = index;
        txtOutAreaNo.setText(stockInfos.get(index).getAreaNo());
        edtScanQty.setText(stockInfos.get(index).getQty() + "");
        CommonUtil.setEditFocus(edtScanQty);
    }

}
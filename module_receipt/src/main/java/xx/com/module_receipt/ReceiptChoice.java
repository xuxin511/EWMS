package xx.com.module_receipt;

import android.content.Context;
import android.os.Message;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

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
import com.xx.chinetek.chineteklib.util.function.CommonUtil;
import com.xx.chinetek.chineteklib.util.function.GsonUtil;
import com.xx.chinetek.chineteklib.util.log.LogUtil;

import java.util.ArrayList;

import butterknife.BindView;
import xx.com.Adapter.ReceiptListAdapter;
import xx.com.Model.InStockInfo;
import xx.com.lib_common.Common_Model.Action.MainActions;
import xx.com.lib_common.Common_Model.Action.ReceiptActions;
import xx.com.lib_common.Common_Model.CommonModel;
import xx.com.lib_common.Common_Model.URLModel;

import static xx.com.lib_common.Common_Model.URLModel.RESULT_GetT_InStockList;
import static xx.com.lib_common.Common_Model.URLModel.TAG_GetT_InStockList;

@Route(path = MainActions.Action_Main_Receipt)
public class ReceiptChoice extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener{

    Context context=ReceiptChoice.this;

    @BindView(R2.id.edt_filterContent)
    EditText edtFilterContent;
    @BindView(R2.id.rv_ReceiptList)
    RecyclerView rvReceiptList;
    @BindView(R2.id.swipeLayout)
    SwipeRefreshLayout swipeLayout;

    ReceiptListAdapter receiptListAdapter;

    ArrayList<InStockInfo> inStockInfos;//单据信息

    @Override
    public void onHandleMessage(Message msg) {
        receiptListAdapter.setEnableLoadMore(true);
        swipeLayout.setRefreshing(false);
        switch (msg.what) {
            case RESULT_GetT_InStockList:
                AnalysisGetT_InStockListJson((String) msg.obj);
                break;
            case NetworkError.NET_ERROR_CUSTOM:
                ToastUtil.show("获取请求失败_____" + msg.obj);
                CommonUtil.setEditFocus(edtFilterContent);
                break;
        }
    }

    @Override
    protected void initViews() {
        BaseApplication.toolBarTitle = new ToolBarTitle(getString(R.string.receipt_title), getString(R.string.receipt_title_sub));
        setContentView(R.layout.activity_receipt_choice);
        super.initViews();
        rvReceiptList.setLayoutManager(new LinearLayoutManager(this));
        swipeLayout.setOnRefreshListener(this);
        edtFilterContent.addTextChangedListener(CustomTextWatcher);
    }

    @Override
    protected void initData() {
        super.initData();
        initAdapter();
    }

    @Override
    protected void onResume() {
        super.onResume();
        InitListView();
    }

    @Override
    public void onRefresh() {
        receiptListAdapter.setEnableLoadMore(false);//这里的作用是防止下拉刷新的时候还可以上拉加载
        GetT_InStockList();
    }

    /**
     * 初始化加载listview
     */
    private void InitListView() {
        inStockInfos=new ArrayList<>();
        edtFilterContent.setText("");
        GetT_InStockList();
    }

    private void BindRecycleView(){
        if(inStockInfos!=null){
            receiptListAdapter.setNewData(inStockInfos);
        }
    }

    void GetT_InStockList(){
        try {
            InStockInfo inStockInfo = new InStockInfo();
            inStockInfo.setStatus(1);
            inStockInfo.setUserID(CommonModel.userInfo.getID());
            String ModelJson = GsonUtil.parseModelToJson(inStockInfo);
            LogUtil.WriteLog(ReceiptChoice.class, TAG_GetT_InStockList, ModelJson);
            RequestHandler.addRequestWithDialog(Request.Method.POST, TAG_GetT_InStockList, getString(R.string.Msg_GetT_InStockListADF), context, mHandler, RESULT_GetT_InStockList, null,
                    URLModel.GetURL().GetT_InStockListADF, ModelJson, null);
        } catch (Exception ex) {
            swipeLayout.setRefreshing(false);
            receiptListAdapter.setEnableLoadMore(true);
            MessageBox.Show(context, ex.getMessage());
        }
    }

    void  AnalysisGetT_InStockListJson(String result){
        try {
            LogUtil.WriteLog(ReceiptChoice.class, TAG_GetT_InStockList, result);
            ReturnMsgModelList<InStockInfo> returnMsgModel = GsonUtil.getGsonUtil().fromJson(result, new TypeToken<ReturnMsgModelList<InStockInfo>>() {
            }.getType());
//            InStockInfo inStockInfo=new InStockInfo();
//            inStockInfo.setErpVoucherNo("SZ201801010001");
//            inStockInfo.setSupplierName("上海闽兴");
//            inStockInfo.setStrVoucherType("杂入");
//            inStockInfos.add(inStockInfo);
//            inStockInfo=new InStockInfo();
//            inStockInfo.setErpVoucherNo("SC201801010002");
//            inStockInfo.setSupplierName("佳轩");
//            inStockInfo.setStrVoucherType("采购");
//            inStockInfos.add(inStockInfo);
//            inStockInfo=new InStockInfo();
//            inStockInfo.setErpVoucherNo("SC201801010003");
//            inStockInfo.setSupplierName("佳轩");
//            inStockInfo.setStrVoucherType("采购");
//            inStockInfos.add(inStockInfo);
//            inStockInfo=new InStockInfo();
//            inStockInfo.setErpVoucherNo("SC201801010004");
//            inStockInfo.setSupplierName("泰宝");
//            inStockInfo.setStrVoucherType("采购");
//            inStockInfos.add(inStockInfo);
//            inStockInfo=new InStockInfo();
//            inStockInfo.setErpVoucherNo("SD201801010005");
//            inStockInfo.setSupplierName("义乌仓");
//            inStockInfo.setStrVoucherType("调拨入");
//            inStockInfos.add(inStockInfo);
//            inStockInfo=new InStockInfo();
//            inStockInfo.setErpVoucherNo("ST201801010006");
//            inStockInfo.setSupplierName("顾客");
//            inStockInfo.setStrVoucherType("销售退");
//            inStockInfos.add(inStockInfo);
//            inStockInfo=new InStockInfo();
//            inStockInfo.setErpVoucherNo("SC201801010007");
//            inStockInfo.setSupplierName("宁夏惠亿");
//            inStockInfo.setStrVoucherType("采购");
//            inStockInfos.add(inStockInfo);
//            inStockInfo=new InStockInfo();
//            inStockInfo.setErpVoucherNo("SC201801010008");
//            inStockInfo.setSupplierName("上海恩氏");
//            inStockInfo.setStrVoucherType("采购");
//            inStockInfos.add(inStockInfo);
//
//            BindRecycleView();
            if (returnMsgModel.getHeaderStatus().equals("S")) {
                inStockInfos = returnMsgModel.getModelJson();
                BindRecycleView();
            } else {
                MessageBox.Show(context,returnMsgModel.getMessage());
            }
        }catch (Exception ex){
            MessageBox.Show(context,ex.getMessage());
        }
        CommonUtil.setEditFocus(edtFilterContent);
    }

    private void initAdapter() {
        receiptListAdapter = new ReceiptListAdapter();
        receiptListAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
        receiptListAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                InStockInfo inStockInfo=(InStockInfo)receiptListAdapter.getItem(position);
                ActivityOptionsCompat compat = ActivityOptionsCompat.
                        makeScaleUpAnimation(view, view.getWidth() / 2, view.getHeight() / 2, 0, 0);
                ARouter.getInstance().build(ReceiptActions.Action_Receipt_Scan)
                        .withParcelable("inStockInfo",inStockInfo)
                        .withOptionsCompat(compat).navigation();
            }
        });
        rvReceiptList.setAdapter(receiptListAdapter);

    }

    TextWatcher CustomTextWatcher=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if(!edtFilterContent.getText().toString().equals(""))
                receiptListAdapter.getFilter().filter(edtFilterContent.getText().toString());
            else{
                BindRecycleView();
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}

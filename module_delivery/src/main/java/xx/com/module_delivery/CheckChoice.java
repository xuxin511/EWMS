package xx.com.module_delivery;

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
import xx.com.Adapter.CheckListAdapter;
import xx.com.Model.OutStockInfo;
import xx.com.lib_common.Common_Model.Action.DeliveryActions;
import xx.com.lib_common.Common_Model.Action.MainActions;
import xx.com.lib_common.Common_Model.CommonModel;
import xx.com.lib_common.Common_Model.URLModel;

import static xx.com.lib_common.Common_Model.URLModel.RESULT_GetT_OutStockReviewListADF;
import static xx.com.lib_common.Common_Model.URLModel.TAG_GetT_OutStockReviewListADF;

@Route(path = MainActions.Action_Main_Check)
public class CheckChoice extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener{

    Context context=CheckChoice.this;

    @BindView(R2.id.edt_filterContent)
    EditText edtFilterContent;
    @BindView(R2.id.rv_CheckList)
    RecyclerView rvCheckList;
    @BindView(R2.id.swipeLayout)
    SwipeRefreshLayout swipeLayout;


    CheckListAdapter checkListAdapter;
    ArrayList<OutStockInfo> outStockInfos;//单据信息


    @Override
    public void onHandleMessage(Message msg) {
        checkListAdapter.setEnableLoadMore(true);
        swipeLayout.setRefreshing(false);
        switch (msg.what) {
            case RESULT_GetT_OutStockReviewListADF:
                AnalysisGetT_OutStockReviewListADFJson((String) msg.obj);
                break;
            case NetworkError.NET_ERROR_CUSTOM:
                ToastUtil.show("获取请求失败_____" + msg.obj);
                CommonUtil.setEditFocus(edtFilterContent);
                break;
        }
    }

    @Override
    protected void initViews() {
        BaseApplication.toolBarTitle = new ToolBarTitle(getString(R.string.check), getString(R.string.checkChoice));
        setContentView(R.layout.activity_check_choice);
        super.initViews();
        rvCheckList.setLayoutManager(new LinearLayoutManager(this));
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
        checkListAdapter.setEnableLoadMore(false);//这里的作用是防止下拉刷新的时候还可以上拉加载
        GetT_OutStockCheckList();
    }


    /**
     * 初始化加载listview
     */
    private void InitListView() {
        outStockInfos=new ArrayList<>();
        edtFilterContent.setText("");
        OutStockInfo outStockInfo=new OutStockInfo();
        outStockInfo.setVoucherNo("DC201801010001");
        outStockInfo.setCustomerName("上海闽兴");
        outStockInfo.setStrVoucherType("杂出");
        outStockInfos.add(outStockInfo);

        BindRecycleView();
        GetT_OutStockCheckList();
//        inStockInfo=new OutStockTaskInfo();
//        inStockInfo.setErpVoucherNo("DS201801010002");
//        inStockInfo.setSupcusName("上海恩氏");
//        inStockInfo.setStrVoucherType("销售");
//        inStockInfo.setErpVoucherNo("DD201801010005");
//        inStockInfo.setSupcusName("义乌仓");
//        inStockInfo.setStrVoucherType("调拨出");
//        outStockTaskInfos.add(inStockInfo);
//        inStockInfo=new OutStockTaskInfo();
//        inStockInfo.setErpVoucherNo("DS201801010006");
//        inStockInfo.setSupcusName("顾客");
//        inStockInfo.setStrVoucherType("销售");
//        outStockTaskInfos.add(inStockInfo);
//        inStockInfo=new OutStockTaskInfo();
//        inStockInfo.setErpVoucherNo("DS201801010007");
//        inStockInfo.setSupcusName("宁夏惠亿");
//        inStockInfo.setStrVoucherType("销售");
//        outStockTaskInfos.add(inStockInfo);
//        inStockInfo=new OutStockTaskInfo();
//        inStockInfo.setErpVoucherNo("DS201801010008");
//        inStockInfo.setSupcusName("上海恩氏");
//        inStockInfo.setStrVoucherType("销售");
//        outStockTaskInfos.add(inStockInfo);

    }

    private void BindRecycleView(){
        if(outStockInfos!=null){
            checkListAdapter.setNewData(outStockInfos);
        }
    }

    private void initAdapter() {
        checkListAdapter = new CheckListAdapter();
        checkListAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
        checkListAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                OutStockInfo outStockInfo=(OutStockInfo)checkListAdapter.getItem(position);
                ActivityOptionsCompat compat = ActivityOptionsCompat.
                        makeScaleUpAnimation(view, view.getWidth() / 2, view.getHeight() / 2, 0, 0);
                ARouter.getInstance().build(DeliveryActions.Action_Check_Scan)
                        .withParcelable("outStockInfo",outStockInfo)
                        .withOptionsCompat(compat).navigation();
            }
        });
        rvCheckList.setAdapter(checkListAdapter);

    }

    void GetT_OutStockCheckList() {
        try {
            OutStockInfo outStockInfo=new OutStockInfo();
            outStockInfo.setStatus(2);
            outStockInfo.setUserID(CommonModel.userInfo.getID());
            String ModelJson = GsonUtil.parseModelToJson(outStockInfo);
            LogUtil.WriteLog(DeliveryChoice.class, TAG_GetT_OutStockReviewListADF, ModelJson);
            RequestHandler.addRequestWithDialog(Request.Method.POST, TAG_GetT_OutStockReviewListADF,
                    getString(R.string.Msg_GetT_OutStockListADF), context, mHandler,
                    RESULT_GetT_OutStockReviewListADF, null,
                    URLModel.GetURL().GetT_OutStockReviewListADF, ModelJson, null);
        } catch (Exception ex) {
            swipeLayout.setRefreshing(false);
            checkListAdapter.setEnableLoadMore(true);
            MessageBox.Show(context, ex.getMessage());
        }
    }

    void AnalysisGetT_OutStockReviewListADFJson(String result) {
        try {
            LogUtil.WriteLog(CheckChoice.class, TAG_GetT_OutStockReviewListADF, result);
            ReturnMsgModelList<OutStockInfo> returnMsgModel = GsonUtil.getGsonUtil().fromJson(result,
                    new TypeToken<ReturnMsgModelList<OutStockInfo>>() {
                    }.getType());
            if (returnMsgModel.getHeaderStatus().equals("S")) {
                outStockInfos = returnMsgModel.getModelJson();
                BindRecycleView();
            } else {
                MessageBox.Show(context, returnMsgModel.getMessage());
            }
        } catch (Exception ex) {
            MessageBox.Show(context, ex.getMessage());
        }
    }


    TextWatcher CustomTextWatcher=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if(!edtFilterContent.getText().toString().equals(""))
                checkListAdapter.getFilter().filter(edtFilterContent.getText().toString());
            else{
                BindRecycleView();
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}

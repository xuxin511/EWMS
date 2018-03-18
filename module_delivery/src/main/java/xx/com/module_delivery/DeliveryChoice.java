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
import xx.com.Adapter.DeliveryListAdapter;
import xx.com.Model.OutStockTaskInfo;
import xx.com.lib_common.Common_Model.Action.DeliveryActions;
import xx.com.lib_common.Common_Model.Action.MainActions;
import xx.com.lib_common.Common_Model.CommonModel;
import xx.com.lib_common.Common_Model.URLModel;

import static xx.com.lib_common.Common_Model.URLModel.RESULT_GetT_OutTaskListADF;
import static xx.com.lib_common.Common_Model.URLModel.TAG_GetT_OutTaskListADF;

@Route(path = MainActions.Action_Main_Delivery)
public class DeliveryChoice extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener{

    Context context=DeliveryChoice.this;

    @BindView(R2.id.edt_filterContent)
    EditText edtFilterContent;
    @BindView(R2.id.rv_DeliveryList)
    RecyclerView rvDeliveryList;
    @BindView(R2.id.swipeLayout)
    SwipeRefreshLayout swipeLayout;

    DeliveryListAdapter deliveryListAdapter;
    ArrayList<OutStockTaskInfo> outStockTaskInfos;//单据信息

    @Override
    public void onHandleMessage(Message msg) {
        deliveryListAdapter.setEnableLoadMore(true);
        swipeLayout.setRefreshing(false);
        switch (msg.what) {
            case RESULT_GetT_OutTaskListADF:
                AnalysisGetT_OutTaskListADFJson((String) msg.obj);
                break;
            case NetworkError.NET_ERROR_CUSTOM:
                ToastUtil.show("获取请求失败_____" + msg.obj);
                CommonUtil.setEditFocus(edtFilterContent);
                break;
        }
    }

    @Override
    protected void initViews() {
        BaseApplication.toolBarTitle = new ToolBarTitle(getString(R.string.delivery), getString(R.string.deliveryChoice));
        setContentView(R.layout.activity_delivery_choice);
        super.initViews();
        rvDeliveryList.setLayoutManager(new LinearLayoutManager(this));
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
        deliveryListAdapter.setEnableLoadMore(false);//这里的作用是防止下拉刷新的时候还可以上拉加载
        GetT_OutStockTaskInfo();
    }
    /**
     * 初始化加载listview
     */
    private void InitListView() {
        outStockTaskInfos=new ArrayList<>();
        edtFilterContent.setText("");

        OutStockTaskInfo outStockTaskInfo=new OutStockTaskInfo();
        outStockTaskInfo.setTaskNo("DS201801020001");
        outStockTaskInfo.setStrVoucherType("拣货单");
        outStockTaskInfo.setStrCreateTime("2018-01-02");
        outStockTaskInfo.setVouUser("朱叶");
        outStockTaskInfo.setPickUserName("张良友");
        outStockTaskInfos.add(outStockTaskInfo);
//        outStockTaskInfo=new OutStockTaskInfo();
//        outStockTaskInfo.setTaskNo("DS201801020002");
//        outStockTaskInfo.setStrVoucherType("拣货单");
//        outStockTaskInfo.setStrCreateTime("2018-01-02");
//        outStockTaskInfo.setVouUser("朱叶");
//        outStockTaskInfo.setPickUserName("王平");
//        outStockTaskInfos.add(outStockTaskInfo);
//
//        outStockTaskInfo=new OutStockTaskInfo();
//        outStockTaskInfo.setTaskNo("DS201801020003");
//        outStockTaskInfo.setStrVoucherType("拣货单");
//        outStockTaskInfo.setStrCreateTime("2018-01-02");
//        outStockTaskInfo.setVouUser("朱叶");
//        outStockTaskInfo.setPickUserName("王平");
//        outStockTaskInfos.add(outStockTaskInfo);
//
//        outStockTaskInfo=new OutStockTaskInfo();
//        outStockTaskInfo.setTaskNo("DS201801020004");
//        outStockTaskInfo.setStrVoucherType("拣货单");
//        outStockTaskInfo.setStrCreateTime("2018-01-02");
//        outStockTaskInfo.setVouUser("朱叶");
//        outStockTaskInfo.setPickUserName("胡慧中");
//        outStockTaskInfos.add(outStockTaskInfo);
        BindRecycleView();
        GetT_OutStockTaskInfo();
    }

    private void BindRecycleView(){
        if(outStockTaskInfos!=null){
            deliveryListAdapter.setNewData(outStockTaskInfos);
        }
    }

    void GetT_OutStockTaskInfo(){
        try {
            OutStockTaskInfo outStockTaskInfo = new OutStockTaskInfo();
            outStockTaskInfo.setStatus(1);
            outStockTaskInfo.setUserID(CommonModel.userInfo.getID());
            String ModelJson = GsonUtil.parseModelToJson(outStockTaskInfo);
            LogUtil.WriteLog(DeliveryChoice.class, TAG_GetT_OutTaskListADF, ModelJson);
            RequestHandler.addRequestWithDialog(Request.Method.POST, TAG_GetT_OutTaskListADF,
                    getString(R.string.Msg_GetT_OutTaskListADF), context, mHandler,
                    RESULT_GetT_OutTaskListADF, null,
                    URLModel.GetURL().GetT_OutTaskListADF, ModelJson, null);
        } catch (Exception ex) {
            swipeLayout.setRefreshing(false);
            deliveryListAdapter.setEnableLoadMore(true);
            MessageBox.Show(context, ex.getMessage());
        }
    }

void AnalysisGetT_OutTaskListADFJson(String result) {
    try {
        LogUtil.WriteLog(DeliveryChoice.class, TAG_GetT_OutTaskListADF, result);
        ReturnMsgModelList<OutStockTaskInfo> returnMsgModel = GsonUtil.getGsonUtil()
                .fromJson(result, new TypeToken<ReturnMsgModelList<OutStockTaskInfo>>() {}.getType());
        if (returnMsgModel.getHeaderStatus().equals("S")) {
            outStockTaskInfos = returnMsgModel.getModelJson();
            BindRecycleView();
        }else {
            MessageBox.Show(context,returnMsgModel.getMessage());
        }
    }catch (Exception ex){
        MessageBox.Show(context, ex.getMessage());
    }
}



    private void initAdapter() {
        deliveryListAdapter = new DeliveryListAdapter();
        deliveryListAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
        deliveryListAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                OutStockTaskInfo outStockTaskInfo=(OutStockTaskInfo)deliveryListAdapter.getItem(position);
                ActivityOptionsCompat compat = ActivityOptionsCompat.
                        makeScaleUpAnimation(view, view.getWidth() / 2, view.getHeight() / 2, 0, 0);
                ARouter.getInstance().build(DeliveryActions.Action_Delivery_Scan)
                        .withParcelable("outStockTaskInfo",outStockTaskInfo)
                        .withOptionsCompat(compat).navigation();
            }
        });
        rvDeliveryList.setAdapter(deliveryListAdapter);

    }

    TextWatcher CustomTextWatcher=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if(!edtFilterContent.getText().toString().equals(""))
                deliveryListAdapter.getFilter().filter(edtFilterContent.getText().toString());
            else{
                BindRecycleView();
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}

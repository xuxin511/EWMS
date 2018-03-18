package xx.com.module_inventory;

import android.content.Context;
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
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.xx.chinetek.chineteklib.base.BaseActivity;
import com.xx.chinetek.chineteklib.base.BaseApplication;
import com.xx.chinetek.chineteklib.base.ToolBarTitle;

import java.util.ArrayList;

import butterknife.BindView;
import xx.com.Adapter.InventoryListAdapter;
import xx.com.Model.Check_Model;
import xx.com.lib_common.Common_Model.Action.InventoryActions;
import xx.com.lib_common.Common_Model.Action.MainActions;

@Route(path = MainActions.Action_Main_Inventory)
public class InventoryChoice extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener{

    Context context = InventoryChoice.this;
    @BindView(R2.id.edt_filterContent)
    EditText edtFilterContent;
    @BindView(R2.id.rv_InventoryList)
    RecyclerView rvInventoryList;
    @BindView(R2.id.swipeLayout)
    SwipeRefreshLayout swipeLayout;

    InventoryListAdapter inventoryListAdapter;

    ArrayList<Check_Model> checkModels;//单据信息

    @Override
    protected void initViews() {
        BaseApplication.toolBarTitle = new ToolBarTitle(getString(R.string.Inventory), getString(R.string.InventoryChoice));
        setContentView(R.layout.activity_inventory_choice);
        super.initViews();
        rvInventoryList.setLayoutManager(new LinearLayoutManager(this));
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
        inventoryListAdapter.setEnableLoadMore(false);//这里的作用是防止下拉刷新的时候还可以上拉加载
        GetT_InvnetoryList();
    }

    /**
     * 初始化加载listview
     */
    private void InitListView() {
        checkModels=new ArrayList<>();
        edtFilterContent.setText("");
        GetT_InvnetoryList();
    }

    void GetT_InvnetoryList(){
        Check_Model checkModel=new Check_Model();
        checkModel.setCHECKNO("P201801010001");
        checkModel.setREMARKS("抽盘单据");
        checkModel.setCHECKSTATUS("未盘");
        checkModels.add(checkModel);
        checkModel=new Check_Model();
        checkModel.setCHECKNO("P201801010002");
        checkModel.setREMARKS("财务盘点单据");
        checkModel.setCHECKSTATUS("盘点中");
        checkModels.add(checkModel);
        checkModel=new Check_Model();
        checkModel.setCHECKNO("P201801010003");
        checkModel.setREMARKS("库位盘点单据");
        checkModel.setCHECKSTATUS("已盘");
        checkModels.add(checkModel);


        BindRecycleView();
    }

    private void BindRecycleView(){
        if(checkModels!=null){
            inventoryListAdapter.setNewData(checkModels);
        }
    }

    private void initAdapter() {
        inventoryListAdapter = new InventoryListAdapter();
        inventoryListAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
        inventoryListAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Check_Model checkModel=(Check_Model)inventoryListAdapter.getItem(position);
                ActivityOptionsCompat compat = ActivityOptionsCompat.
                        makeScaleUpAnimation(view, view.getWidth() / 2, view.getHeight() / 2, 0, 0);
                ARouter.getInstance().build(InventoryActions.Action_Inventory_Scan)
                        .withParcelable("checkModel",checkModel)
                        .withOptionsCompat(compat).navigation();
            }
        });
        rvInventoryList.setAdapter(inventoryListAdapter);

    }

    TextWatcher CustomTextWatcher=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if(!edtFilterContent.getText().toString().equals(""))
                inventoryListAdapter.getFilter().filter(edtFilterContent.getText().toString());
            else{
                BindRecycleView();
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}

package xx.com.ewms;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.xx.chinetek.chineteklib.base.BaseActivity;
import com.xx.chinetek.chineteklib.base.BaseApplication;
import com.xx.chinetek.chineteklib.base.ToolBarTitle;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import xx.com.Adapter.FuncRecyclerAdapter;
import xx.com.Model.FuncModel;
import xx.com.lib_common.Common_Model.Action.MainActions;

//@Route(path = LoginActions.Action_Login_Main)
public class Main extends BaseActivity {

    Context context=Main.this;

    @BindView(R.id.recv_Func)
    RecyclerView recvFunc;

    private List<FuncModel> funcModels=new ArrayList<FuncModel>();

    @Override
    protected void initViews() {
        BaseApplication.toolBarTitle = new ToolBarTitle(getString(R.string.app_name),getString(R.string.Function));
        setContentView(R.layout.activity_main);
        super.initViews();
        recvFunc.setLayoutManager(new GridLayoutManager(this, 3));
    }

    @Override
    protected void initData() {
        super.initData();
        initMenu();
        initAdpater();
    }

    private void initAdpater(){
        //设置adapter
        FuncRecyclerAdapter adapter=new FuncRecyclerAdapter(funcModels);
        adapter.setNotDoAnimationCount(funcModels.size());
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                JumpActivity(position);
            }
        });
        recvFunc.setAdapter(adapter);
    }

    void JumpActivity(int position){
        ARouter.getInstance().build(funcModels.get(position).getAction()).navigation();
    }

    private void initMenu() {
        funcModels.add(new FuncModel(R.drawable.recept,getString(R.string.receipt), MainActions.Action_Main_Receipt));
//        funcModels.add(new FuncModel(R.drawable.upshelf,getString(R.string.upshelf),MainActions.Action_Main_Receipt));
        funcModels.add(new FuncModel(R.drawable.move,getString(R.string.move),MainActions.Action_Main_Receipt));
        funcModels.add(new FuncModel(R.drawable.undercarriage,getString(R.string.undercarriage),MainActions.Action_Main_Delivery));
        funcModels.add(new FuncModel(R.drawable.check,getString(R.string.check),MainActions.Action_Main_Receipt));
        funcModels.add(new FuncModel(R.drawable.trans,getString(R.string.transfor),MainActions.Action_Main_Receipt));
        funcModels.add(new FuncModel(R.drawable.adjust,getString(R.string.adjust),MainActions.Action_Main_Receipt));
        funcModels.add(new FuncModel(R.drawable.inventory,getString(R.string.inventory),MainActions.Action_Main_Receipt));
        funcModels.add(new FuncModel(R.drawable.query,getString(R.string.query),MainActions.Action_Main_Receipt));
    }

}

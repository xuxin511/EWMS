package xx.com.module_delivery;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.xx.chinetek.chineteklib.base.BaseActivity;
import com.xx.chinetek.chineteklib.base.BaseApplication;
import com.xx.chinetek.chineteklib.base.ToolBarTitle;

import butterknife.BindView;
import xx.com.lib_common.Common_Model.Action.MainActions;

@Route(path = MainActions.Action_Main_Delivery)
public class DeliveryChoice extends BaseActivity {

    @BindView(R2.id.edt_filterContent)
    EditText edtFilterContent;
    @BindView(R2.id.rv_DeliveryList)
    RecyclerView rvDeliveryList;
    @BindView(R2.id.swipeLayout)
    SwipeRefreshLayout swipeLayout;

    @Override
    protected void initViews() {
        BaseApplication.toolBarTitle = new ToolBarTitle(getString(R.string.delivery), getString(R.string.deliveryChoice));
        setContentView(R.layout.activity_delivery_choice);
        super.initViews();
    }

    @Override
    protected void initData() {
        super.initData();
    }

}

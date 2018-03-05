package xx.com.module_delivery;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.xx.chinetek.chineteklib.base.BaseActivity;
import com.xx.chinetek.chineteklib.base.BaseApplication;
import com.xx.chinetek.chineteklib.base.ToolBarTitle;

import xx.com.lib_common.Common_Model.Action.MainActions;

@Route(path = MainActions.Action_Main_Delivery)
public class DeliveryChoice extends BaseActivity {

    @Override
    protected void initViews() {
        BaseApplication.toolBarTitle = new ToolBarTitle(getString(R.string.app_name), getString(R.string.app_name));
        setContentView(R.layout.activity_delivery_choice);
        super.initViews();
    }

    @Override
    protected void initData() {
        super.initData();
    }
}

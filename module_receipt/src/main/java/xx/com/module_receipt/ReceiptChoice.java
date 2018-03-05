package xx.com.module_receipt;

import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.xx.chinetek.chineteklib.base.BaseActivity;
import com.xx.chinetek.chineteklib.base.BaseApplication;
import com.xx.chinetek.chineteklib.base.ToolBarTitle;

import butterknife.BindView;
import xx.com.lib_common.Common_Model.Action.MainActions;

@Route(path = MainActions.Action_Main_Receipt)
public class ReceiptChoice extends BaseActivity {


    @BindView(R2.id.txtName)
    TextView txtName;

    @Override
    protected void initViews() {
        BaseApplication.toolBarTitle = new ToolBarTitle(getString(R.string.app_name), getString(R.string.app_name));
        setContentView(R.layout.activity_receipt_choice);
        super.initViews();
    }

    @Override
    protected void initData() {
        super.initData();
        txtName.setText("123113");
    }

}

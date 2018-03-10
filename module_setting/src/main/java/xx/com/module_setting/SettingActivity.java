package xx.com.module_setting;

import android.content.Context;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.xx.chinetek.chineteklib.base.BaseActivity;
import com.xx.chinetek.chineteklib.base.BaseApplication;
import com.xx.chinetek.chineteklib.base.ToolBarTitle;
import com.xx.chinetek.chineteklib.util.function.DoubleClickCheck;

import butterknife.BindView;
import xx.com.lib_common.Common_Model.Action.SettingAction;

@Route(path = SettingAction.Action_Setring_Setting)
public class SettingActivity extends BaseActivity {


    Context context=SettingActivity.this;
    @BindView(R2.id.txt_IPAdress)
    TextView txtIPAdress;
    @BindView(R2.id.layoutIPAdress)
    LinearLayout layoutIPAdress;
    @BindView(R2.id.txt_Port)
    TextView txtPort;
    @BindView(R2.id.layoutPort)
    LinearLayout layoutPort;
    @BindView(R2.id.txt_TimeOut)
    TextView txtTimeOut;
    @BindView(R2.id.layoutTimeOut)
    LinearLayout layoutTimeOut;
    @BindView(R2.id.ckIsuserRemark)
    CheckBox ckIsuserRemark;
    @BindView(R2.id.layoutSysPassword)
    LinearLayout layoutSysPassword;

    @Override
    protected void initViews() {
        BaseApplication.toolBarTitle = new ToolBarTitle(getString(R.string.app_name), getString(R.string.Setting));
        setContentView(R.layout.activity_setting);
        super.initViews();
    }

    @Override
    protected void initData() {
        super.initData();
        txtIPAdress.setText("");
    }

        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_setting, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_Save) {
            if (DoubleClickCheck.isFastDoubleClick(context)) {
                return false;
            }

        }
        return super.onOptionsItemSelected(item);
    }
}

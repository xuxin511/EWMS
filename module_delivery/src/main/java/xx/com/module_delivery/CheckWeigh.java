package xx.com.module_delivery;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.xx.chinetek.chineteklib.base.BaseActivity;
import com.xx.chinetek.chineteklib.base.BaseApplication;
import com.xx.chinetek.chineteklib.base.ToolBarTitle;
import com.xx.chinetek.chineteklib.util.function.DoubleClickCheck;

import butterknife.BindView;
import butterknife.ButterKnife;
import xx.com.lib_common.Common_Model.Action.DeliveryActions;

@Route(path = DeliveryActions.Action_Check_Weigh)
public class CheckWeigh extends BaseActivity {


    Context context = CheckWeigh.this;
    @BindView(R2.id.txt_Weigh)
    TextView txtWeigh;
    @BindView(R2.id.txt_SendTotalNum)
    TextView txtSendTotalNum;
    @BindView(R2.id.txt_SendType)
    TextView txtSendType;

    @Override
    protected void initViews() {
        BaseApplication.toolBarTitle = new ToolBarTitle(getString(R.string.check), getString(R.string.checkWeight));
        setContentView(R.layout.activity_check_weigh);
        super.initViews();
    }

    @Override
    protected void initData() {
        super.initData();
        txtWeigh.setText("2.3KG");
        txtSendTotalNum.setText("6");
        txtSendType.setText("2");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_checkweigh, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_Submit) {
            if (DoubleClickCheck.isFastDoubleClick(context)) {
                return false;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}

package xx.com.module_setting;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.xx.chinetek.chineteklib.base.BaseActivity;
import com.xx.chinetek.chineteklib.base.BaseApplication;
import com.xx.chinetek.chineteklib.base.ToolBarTitle;
import com.xx.chinetek.chineteklib.model.Paramater;
import com.xx.chinetek.chineteklib.util.function.DoubleClickCheck;

import butterknife.BindView;
import butterknife.OnClick;
import xx.com.lib_common.Common_Model.Action.SettingAction;
import xx.com.lib_common.Common_Model.CommUtil.SharePreferUtil;
import xx.com.lib_common.Common_Model.CommonModel;

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
    @BindView(R2.id.ckIsInputNum)
    CheckBox ckIsInputNum;
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
        txtIPAdress.setText(Paramater.IPAdress);
        txtPort.setText(Paramater.Port+"");
        txtTimeOut.setText(Paramater.SOCKET_TIMEOUT/1000+"");
        ckIsInputNum.setChecked(CommonModel.IsInputQty);
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
            Paramater.IPAdress=txtIPAdress.getText().toString();
            Paramater.Port= Integer.parseInt(txtPort.getText().toString().trim());
            Paramater.SOCKET_TIMEOUT = Integer.parseInt(txtTimeOut.getText().toString().trim()) * 1000;
            CommonModel.IsInputQty=ckIsInputNum.isChecked();
            SharePreferUtil.SetShare(context);
            closeActiviry();
        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick(value = {R2.id.layoutIPAdress,R2.id.layoutPort,R2.id.layoutTimeOut})
    public void layoutClick(View view){
        final EditText et = new EditText(this);
        et.setTextColor(getResources().getColor(R.color.black));
        String msg="";
        final View v=view;
        if(v.getId()==R.id.layoutIPAdress){
            et.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
            msg=getString(R.string.Setting_in_ipadress);
            et.setText(Paramater.IPAdress);
        }else if(v.getId()==R.id.layoutPort){
            msg=getString(R.string.Setting_in_port);
            et.setInputType(InputType.TYPE_CLASS_NUMBER);
            et.setText(Paramater.Port+"");
        }else if(v.getId()==R.id.layoutTimeOut){
            et.setInputType(InputType.TYPE_CLASS_NUMBER);
            msg=getString(R.string.Setting_in_timeout);
            et.setText(Paramater.SOCKET_TIMEOUT/1000+"");
        }
        new AlertDialog.Builder(this).setTitle(msg)
                .setIcon(android.R.drawable.ic_dialog_info)
                .setView(et)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        String input = et.getText().toString();
                        if(v.getId()==R.id.layoutIPAdress){
                            txtIPAdress.setText(input);
                        }else if(v.getId()==R.id.layoutPort){
                            txtPort.setText(input);
                        }else if(v.getId()==R.id.layoutTimeOut){
                            txtTimeOut.setText(input);
                        }
                    }
                })
                .setNegativeButton("取消", null)
                .show();
    }
}

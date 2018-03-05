package xx.com.ewms;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.android.volley.Request;
import com.xx.chinetek.chineteklib.base.BaseActivity;
import com.xx.chinetek.chineteklib.model.Paramater;
import com.xx.chinetek.chineteklib.util.Network.NetworkError;
import com.xx.chinetek.chineteklib.util.Network.RequestHandler;
import com.xx.chinetek.chineteklib.util.dialog.MessageBox;
import com.xx.chinetek.chineteklib.util.dialog.ToastUtil;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import xx.com.lib_common.Common_Model.Action.LoginActions;
import xx.com.lib_common.Common_Model.URLModel;

@Route(path = LoginActions.Action_Login_Login)
public class Login extends BaseActivity {


    String TAG="Loagin";

    private static final int RESULT_GET_LOGIN_INFO = 101;



    @Override
    public void onHandleMessage(Message msg) {
        switch (msg.what) {
            case RESULT_GET_LOGIN_INFO:
                AnalysisJson((String) msg.obj);
                break;
            case NetworkError.NET_ERROR_CUSTOM:
                ToastUtil.show("获取请求失败_____"+ msg.obj);
                break;
        }
    }

    void AnalysisJson(String result){

    }

    Context context=Login.this;

    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.iv_logo)
    ImageView ivLogo;
    @BindView(R.id.txt_version)
    TextView txtVersion;
    @BindView(R.id.img_pass)
    ImageView imgPass;
    @BindView(R.id.img_user)
    ImageView imgUser;
    @BindView(R.id.btn_Setting)
    ImageView btnSetting;
    @BindView(R.id.edt_UserName)
    EditText edtUserName;
    @BindView(R.id.edt_Password)
    EditText edtPassword;

    @Override
    protected void initViews() {
        Paramater.IsShowTitleBar=false;
        setContentView(R.layout.activity_login);
        super.initViews();
    }

    @Override
    protected void initData() {
        super.initData();
        txtVersion.setText(updateVersionService.getVersionCode(context)+"");
        initAnims();
    }

    @OnClick(R.id.btn_login)
    public void btn_loginClick(View view){
        if(TextUtils.isEmpty(edtUserName.getText())){
            try {
                MessageBox.Show(context, "用户名为空");
            }catch (Exception ex){
                ToastUtil.show(ex.getMessage());
            }
            return;
        }
        Map<String, String> params = new HashMap<>();
        params.put("UserJson", "1233");
        RequestHandler.addRequestWithDialog(Request.Method.POST, TAG, "登陆。。。", context, mHandler, RESULT_GET_LOGIN_INFO,
                null, URLModel.GetURL().UserLoginADF, params, null);
        ARouter.getInstance().build(LoginActions.Action_Login_Main).navigation();
    }

    @OnClick(R.id.btn_Setting)
    public void btn_SettingClick(View view){
        ARouter.getInstance().build(LoginActions.Action_Login_Setting).navigation();
    }



    /**
     * 初始化logo图片以及底部注册、登录的按钮动画
     */
    private void initAnims() {
        //初始化底部注册、登录的按钮动画
        //以控件自身所在的位置为原点，从下方距离原点200像素的位置移动到原点
        ObjectAnimator tranimgPass = ObjectAnimator.ofFloat(imgPass, "translationY", 200, 0);
        ObjectAnimator tranimgUser = ObjectAnimator.ofFloat(imgUser, "translationY", 200, 0);
        ObjectAnimator tranedtUserName = ObjectAnimator.ofFloat(edtUserName, "translationY", 200, 0);
        ObjectAnimator tranedtPassword = ObjectAnimator.ofFloat(edtPassword, "translationY", 200, 0);
        ObjectAnimator tranRegister = ObjectAnimator.ofFloat(btnLogin, "translationY", 200, 0);
        ObjectAnimator tranbtnSetting = ObjectAnimator.ofFloat(btnSetting, "translationY", 200, 0);
        //将注册、登录的控件alpha属性从0变到1
        ObjectAnimator alphaimgPass = ObjectAnimator.ofFloat(imgPass, "alpha", 0, 1);
        ObjectAnimator alphaimgUser = ObjectAnimator.ofFloat(imgUser, "alpha", 0, 1);
        ObjectAnimator alphaedtUserName = ObjectAnimator.ofFloat(edtUserName, "alpha", 0, 1);
        ObjectAnimator alphaedtPassword = ObjectAnimator.ofFloat(edtPassword, "alpha", 0, 1);
        ObjectAnimator alphaRegister = ObjectAnimator.ofFloat(btnLogin, "alpha", 0, 1);
        ObjectAnimator alphabtnSetting = ObjectAnimator.ofFloat(btnSetting, "alpha", 0, 1);
        final AnimatorSet bottomAnim = new AnimatorSet();
        bottomAnim.setDuration(1000);
        //同时执行控件平移和alpha渐变动画
        bottomAnim.play(tranRegister).with(tranimgPass).with(tranimgUser).with(tranedtUserName).with(tranedtPassword).with(tranbtnSetting)
                .with(alphaRegister).with(alphaimgPass).with(alphaimgUser).with(alphaedtUserName).with(alphaedtPassword).with(alphabtnSetting);

        //获取屏幕高度
        WindowManager manager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics metrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(metrics);
        int screenHeight = metrics.heightPixels;

        //通过测量，获取ivLogo的高度
        int w = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        int h = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        ivLogo.measure(w, h);
        int logoHeight = ivLogo.getMeasuredHeight();

        //初始化ivLogo的移动和缩放动画
        float transY = (screenHeight - logoHeight) * 0.28f;
        //ivLogo向上移动 transY 的距离
        ObjectAnimator tranLogo = ObjectAnimator.ofFloat(ivLogo, "translationY", 0, -transY);
        //ivLogo在X轴和Y轴上都缩放0.75倍
        ObjectAnimator scaleXLogo = ObjectAnimator.ofFloat(ivLogo, "scaleX", 1f, 0.75f);
        ObjectAnimator scaleYLogo = ObjectAnimator.ofFloat(ivLogo, "scaleY", 1f, 0.75f);
        AnimatorSet logoAnim = new AnimatorSet();
        logoAnim.setDuration(1000);
        logoAnim.play(tranLogo).with(scaleXLogo).with(scaleYLogo);
        logoAnim.start();
        logoAnim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                //待ivLogo的动画结束后,开始播放底部注册、登录按钮的动画
                bottomAnim.start();
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //实现只在冷启动时显示启动页，即点击返回键与点击HOME键退出效果一致
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.addCategory(Intent.CATEGORY_HOME);
            startActivity(intent);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }



}
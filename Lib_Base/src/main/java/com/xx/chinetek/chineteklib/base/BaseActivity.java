package com.xx.chinetek.chineteklib.base;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import com.xx.chinetek.chineteklib.R;
import com.xx.chinetek.chineteklib.model.Paramater;
import com.xx.chinetek.chineteklib.util.UpdateVersionService;
import com.xx.chinetek.chineteklib.util.hander.IHandleMessage;
import com.xx.chinetek.chineteklib.util.hander.MyHandler;

import butterknife.ButterKnife;

import static com.xx.chinetek.chineteklib.base.BaseApplication.context;

/**
 * Created by GHOST on 2017/3/15.
 */

public abstract class BaseActivity extends AppCompatActivity implements IHandleMessage {
    private ToolBarHelper mToolBarHelper;
    public Toolbar toolbar;
    public MyHandler<BaseActivity> mHandler;
    private Boolean isCloseActivity = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); //屏幕保持竖屏
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN); //隐藏输入法
        AppManager.getAppManager().addActivity(this); //添加当前Activity到avtivity管理类
        mHandler = new MyHandler<>(this);
        BaseApplication.context = this;
        updateVersionService = new UpdateVersionService(context);// 创建更新业务对象
        Paramater.IsShowTitleBar = true;
        initViews(); //自定义的方法
        initData();
    }

    /**
     * 初始化控件
     */
    protected void initViews() {
        ButterKnife.bind(this);
    }

    /**
     * 初始化数据
     */
    protected void initData() {

        checkUpdate();
    }


    @Override
    public void onHandleMessage(Message msg) {

    }


    @Override
    public void setContentView(int layoutResID) {
        if (Paramater.IsShowTitleBar) {
            mToolBarHelper = new ToolBarHelper(this, layoutResID);
            toolbar = mToolBarHelper.getToolBar();
            setContentView(mToolBarHelper.getContentView());
            if (!TextUtils.isEmpty(BaseApplication.toolBarTitle.Title))
                setTitle(BaseApplication.toolBarTitle.Title);
            if (!TextUtils.isEmpty(BaseApplication.toolBarTitle.subTitle))
                toolbar.setSubtitle(BaseApplication.toolBarTitle.subTitle);
            //toolbar.setLogo(R.mipmap.ic_launcher);
//            if (BaseApplication.toolBarTitle.isShowBack)
//                toolbar.setNavigationIcon(R.drawable.back);
        /*把 toolbar 设置到Activity 中*/
            setSupportActionBar(toolbar);
        /*自定义的一些操作*/
//            if (BaseApplication.toolBarTitle != null) {
//                onCreateCustomToolBar(toolbar);
//            }
        } else {
            isCloseActivity = true;
            getDelegate().setContentView(layoutResID);
        }

    }

//    public void onCreateCustomToolBar(Toolbar toolbar) {
//        toolbar.setContentInsetsRelative(0, 0);
//        toolbar.showOverflowMenu();
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (isCloseActivity)
//                    closeActiviry();
//                else
//                    BackAlter();
//            }
//        });
//    }


    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
            if (isCloseActivity)
                closeActiviry();
            else
                BackAlter();
        }
        return true;
    }


    public void BackAlter() {
        new AlertDialog.Builder(context).setTitle("提示").setCancelable(false).setIcon(android.R.drawable.ic_dialog_info).setMessage("是否返回上一页面？")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO 自动生成的方法
                        closeActiviry();
                    }
                }).setNegativeButton("取消", null).show();
    }

    /**
     * 隐藏键盘
     */
    public void keyBoardCancle() {
        View view = getWindow().peekDecorView();
        if (view != null) {
            InputMethodManager inputmanger = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputmanger.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public void closeActiviry() {
        AppManager.getAppManager().finishActivity();
        if (AppManager.getAppManager().GetActivityCount() != 0)
            context = AppManager.getAppManager().currentActivity();
    }

    /**
     * 左右推动跳转
     *
     * @param intent
     */
    protected void startActivityLeft(Intent intent) {
        startActivity(intent);
        overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    }


    public UpdateVersionService updateVersionService;

    /**
     * 检查更新
     */
    public void checkUpdate() {

        new Thread() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                super.run();
                if (updateVersionService.isUpdate()) {
                    handler.sendEmptyMessage(0);
                }// 调用检查更新的方法,如果可以更新.就更新.不能更新就提示已经是最新的版本了
                else {
                    handler.sendEmptyMessage(1);
                }
            }
        }.start();
    }

    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    updateVersionService.showDownloadDialog();
                    break;
            }
        }

        ;
    };


}

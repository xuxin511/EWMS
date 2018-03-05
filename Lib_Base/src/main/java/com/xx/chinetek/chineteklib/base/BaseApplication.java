package com.xx.chinetek.chineteklib.base;

import android.app.Application;
import android.content.Context;

import com.alibaba.android.arouter.launcher.ARouter;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * 指定自定义Application类，用于存放全局变量
 * 在 AndroidManifest.xml中指定android:name="com.example.demo.application.BaseApplication" 来启用
 */

public class BaseApplication extends Application {


    public static BaseApplication instance;

    public static Context context;  //activity中context对象

    public static String DialogShowText;

    public static ToolBarTitle toolBarTitle;

    private RequestQueue mRequestQueue;

    boolean isDebug=true;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        mRequestQueue = Volley.newRequestQueue(this);
        if (isDebug) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this); // 尽可能早，推荐在Application中初始化
    }


    public static BaseApplication getInstance() {
        return (BaseApplication) instance;
    }

    public static RequestQueue getRequestQueue() {
        return instance.mRequestQueue;
    }
}

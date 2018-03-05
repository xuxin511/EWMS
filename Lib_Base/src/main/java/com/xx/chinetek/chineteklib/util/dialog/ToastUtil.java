package com.xx.chinetek.chineteklib.util.dialog;

import android.widget.Toast;

import com.xx.chinetek.chineteklib.base.BaseApplication;


/**
 * Created by GHOST on 2017/3/13.
 */

public class ToastUtil {
    private ToastUtil() {

    }

    private static Toast mToast;

    public static void show(int resId) {
        show(BaseApplication.getInstance().getString(resId));
    }

    public static void show(String msg) {
        if (mToast == null) {
            mToast = Toast.makeText(BaseApplication.getInstance(), msg, Toast.LENGTH_LONG);
        } else {
            mToast.setText(msg);
        }
        mToast.show();
    }
}

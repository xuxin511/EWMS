package com.xx.chinetek.chineteklib.util.dialog;

import android.content.Context;

import com.xx.chinetek.chineteklib.R;

import cn.pedant.SweetAlert.SweetAlertDialog;


public class MessageBox {

    static String Showmsg="";
    /**
     * 弹出默认提示框
     *
     * @param context 上下文
     * @param message 需要弹出的消息
     */
    public static void Show(Context context, String message) {
        if(!Showmsg.equals(message)) {
            new SweetAlertDialog(context, SweetAlertDialog.WARNING_TYPE)
                    .setTitleText(context.getResources().getString(R.string.common_warning))
                    .setContentText(message)
                    .setConfirmText(context.getResources().getString(R.string.common_comfig))
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            Showmsg="";
                            sDialog.dismissWithAnimation();

                        }
                    })
                    .show();
            Showmsg=message;
        }
    }



}

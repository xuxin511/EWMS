//package com.xx.chinetek.chineteklib.util.dialog;
//
//import android.content.Context;
//import android.view.View;
//
//
///**
// * Created by GHOST on 2017/3/13.
// */
//
//public abstract class BaseDialog {
//    public SweetAlertDialog mDialog;
//
//    public BaseDialog(Context context) {
//        mDialog = createDialog(context);
//    }
//
//    /**
//     * 子类重写该方法，即可创建样式相同的对话框。
//     *
//     * @param context
//     * @return
//     */
//    protected abstract View getDefaultView(Context context);
//
//    private static SweetAlertDialog createDialog(Context context) {
//        SweetAlertDialog dialog = new SweetAlertDialog(context, SweetAlertDialog.PROGRESS_TYPE);
//        dialog.setCancelable(true);
//        return dialog;
//    }
//
//    public void show() {
//        if (mDialog != null && !mDialog.isShowing()) {
//            mDialog.show();
//        }
//    }
//
//    public void dismiss() {
//        if (mDialog != null) {
//            mDialog.dismiss();
//        }
//    }
//}

package com.xx.chinetek.chineteklib.util.dialog;

import android.content.Context;

import com.xx.chinetek.chineteklib.R;

import cn.pedant.SweetAlert.SweetAlertDialog;


/**
 * Created by GHOST on 2017/3/13.
 */

public class LoadingDialog  {

    private SweetAlertDialog instance;

    public SweetAlertDialog getDialog(Context context,String LoadText) {
        if (instance == null) {
            instance =new SweetAlertDialog(context, SweetAlertDialog.PROGRESS_TYPE).setTitleText(LoadText);
            instance.setCancelable(true);
            instance.setCancelText(context.getResources().getString(R.string.common_cancel));
            instance.showCancelButton(true);
            instance.getProgressHelper().setBarColor(context.getResources().getColor(R.color.material_deep_teal_50));

        }
        return instance;
    }

}

package com.xx.chinetek.chineteklib.util.function;

import android.content.Context;

import com.xx.chinetek.chineteklib.R;
import com.xx.chinetek.chineteklib.util.dialog.MessageBox;


/**
 * Created by GHOST on 2017/8/18.
 */

public class DoubleClickCheck {
        private static long lastClickTime;
        public static boolean isFastDoubleClick(Context context) {
            long time = System.currentTimeMillis();
            long timeD = time - lastClickTime;
            if ( 0 < timeD && timeD < 3000) {       //500毫秒内按钮无效，这样可以控制快速点击，自己调整频率
                MessageBox.Show(context,context.getString(R.string.Error_SubmitMore));
                return true;
            }
            lastClickTime = time;
            return false;
        }
}

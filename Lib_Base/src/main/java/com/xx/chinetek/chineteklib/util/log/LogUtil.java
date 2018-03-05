package com.xx.chinetek.chineteklib.util.log;

import android.util.Log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtil {
    static Logger log;
    static Boolean debugBoolean = true;

    public static <T> void WriteLog(Class<T> class1, String title, String info) {
        if (debugBoolean) {
            log = LoggerFactory.getLogger(class1);
            log.info(title + "*" +"\r\n" +info + "\r\n\r\n");
            Log.v("WMSLOG_"+title, info);
        }
    }
}

package com.google.qike.utils;

import android.util.Log;

/**
 * Created by Administrator on 2017/9/7.
 */

public class Logger {
    public static boolean showLog = true;

    public static void i(Object objTag, Object objMsg) {
        if (!showLog) {
            return;
        }

        String tag;
        if (objTag instanceof String) {
            tag = (String) objTag;
        } else if (objTag instanceof Class) {
            tag = ((Class) objTag).getSimpleName();
        } else {
            tag = objTag.getClass().getSimpleName();
        }

        String msg = (objMsg == null || objMsg.toString() == null) ? "null" : objMsg.toString();

        Log.i(tag, msg);
    }
}

package com.gcu.math.base.util;

import android.util.Log;

/**
 * Created by Martin on 2016/8/18.
 */
public class LogUtil {
    private static boolean logAble = true;
    private final static String TAG = LogUtil.class.getSimpleName();

    public static void e(String TAG,Object object){
        if (logAble) Log.e(TAG,object.toString());
    }

    public static void d(String TAG, String s) {
        if (logAble) Log.d(TAG,s);
    }

    public static void w(String TAG, String s) {
        if (logAble) Log.w(TAG,s);
    }

    public static void i(String TAG, String s) {
        if (logAble) Log.i(TAG,s);
    }

    public static void v(String TAG, String s) {
        if (logAble) Log.v(TAG,s);
    }

    public static void e(Object object) {
        e(TAG, object.toString());
    }

    public static void d(Object object) {
        d(TAG, object.toString());
    }

    public static void w(Object object) {
        w(TAG, object.toString());
    }

    public static void i(Object object) {
        i(TAG, object.toString());
    }

    public static void v(Object object) {
        v(TAG, object.toString());
    }
}

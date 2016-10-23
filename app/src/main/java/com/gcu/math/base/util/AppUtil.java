package com.gcu.math.base.util;

import android.content.Context;

import com.gcu.math.Constants;
import com.gcu.math.base.net.HttpClientUtils;

/**
 * Created by Martin on 2016/8/3.
 */
public class AppUtil {
    public static void init(Context context) {
        //初始化ImageLoader
        initNet(context);
        initPreferences(context);
    }

    private static void initNet(Context context) {
        HttpClientUtils.getInstance(context);
    }


    private static void initPreferences(Context context) {
        PreferencesUtils.setPreferenceName(Constants.SP_NAME_USER);
        PreferencesUtils.initContext(context);
    }
}

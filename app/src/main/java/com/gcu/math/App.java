package com.gcu.math;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.gcu.math.base.util.AppUtil;

/**
 * Created by Martin on 2016/8/3.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AppUtil.init(this);
        Fresco.initialize(this);
    }

}

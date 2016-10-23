package com.gcu.math.view.activity;

import android.os.Bundle;

import com.gcu.math.R;
import com.gcu.math.base.BaseActivity;
import com.gcu.math.view.iActivity.IWelcomeActivity;

/**
 * Created by Martin on 2016/9/4.
 */
public class WelcomeActivity extends BaseActivity implements IWelcomeActivity{


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_welcome;
    }

}

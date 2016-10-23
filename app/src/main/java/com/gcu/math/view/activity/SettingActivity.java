package com.gcu.math.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.gcu.math.R;
import com.gcu.math.base.BaseActivity;
import com.gcu.math.view.iActivity.ISettingActivity;

/**
 * Created by Martin on 2016/9/5.
 */
public class SettingActivity extends BaseActivity implements ISettingActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_setting;
    }
}

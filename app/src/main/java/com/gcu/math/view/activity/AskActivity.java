package com.gcu.math.view.activity;

import com.gcu.math.R;
import com.gcu.math.base.BaseActivity;
import com.gcu.math.view.iActivity.IAskActivity;

/**
 * Created by Martin on 2016/9/5.
 */
public class AskActivity extends BaseActivity implements IAskActivity {
    @Override
    public int getLayoutId() {
        return R.layout.activity_ask;
    }
}

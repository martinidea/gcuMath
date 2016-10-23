package com.gcu.math.view.activity;

import com.gcu.math.R;
import com.gcu.math.base.BaseActivity;
import com.gcu.math.view.iActivity.IMyCollectActivity;

/**
 * Created by Martin on 2016/9/5.
 */
public class MyCollectActivity extends BaseActivity implements IMyCollectActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_collect;
    }
}

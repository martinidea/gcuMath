package com.gcu.math.view.activity;

import android.os.Bundle;

import com.gcu.math.R;
import com.gcu.math.base.BaseActivity;
import com.gcu.math.view.iActivity.IKnowledgeActivity;

/**
 * Created by Martin on 2016/9/5.
 */
public class KnowledgeActivity extends BaseActivity implements IKnowledgeActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_knowledge;
    }
}

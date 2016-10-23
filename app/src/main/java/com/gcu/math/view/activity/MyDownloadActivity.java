package com.gcu.math.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.gcu.math.R;
import com.gcu.math.base.BaseActivity;
import com.gcu.math.view.iActivity.IMyDownloadActivity;
import com.gcu.math.view.ui.RefreshLayout;

import butterknife.BindView;

/**
 * Created by Martin on 2016/9/5.
 */
public class MyDownloadActivity extends BaseActivity implements IMyDownloadActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refresh_layout)
    RefreshLayout refreshLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        refreshLayout.setOnOnScrollListener(new RefreshLayout.OnScrollListener() {
            @Override
            public void onRefresh() {

            }

            @Override
            public void onLoad() {

            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_download;
    }
}

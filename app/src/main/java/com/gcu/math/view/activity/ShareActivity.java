package com.gcu.math.view.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;

import com.gcu.math.R;
import com.gcu.math.base.BaseActivity;
import com.gcu.math.presenter.activity.SharePresenter;
import com.gcu.math.view.iActivity.IShareActivity;
import com.gcu.math.view.ui.RefreshLayout;

import butterknife.BindView;

/**
 * Created by Martin on 2016/9/5.
 */
public class ShareActivity extends BaseActivity implements IShareActivity {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refresh_layout)
    RefreshLayout refreshLayout;

    private SharePresenter presenter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_share;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new SharePresenter(this);
        refreshLayout.setOnOnScrollListener(new RefreshLayout.OnScrollListener() {
            @Override
            public void onRefresh() {
                presenter.refresh();
            }

            @Override
            public void onLoad() {
                presenter.load();
            }
        });
    }

    @Override
    public void setAdapter(RecyclerView.Adapter adapter) {
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void setRefreshFinish() {
        refreshLayout.setRefreshing(false);
    }

    @Override
    public void setLoadFinish() {
        refreshLayout.setLoading(false);
    }

    @Override
    public void setRefreshStart() {
        TypedValue typed_value = new TypedValue();
        this.getTheme().resolveAttribute(android.support.v7.appcompat.R.attr.actionBarSize, typed_value, true);
        refreshLayout.setProgressViewOffset(false, 0, getResources().getDimensionPixelSize(typed_value.resourceId));
        refreshLayout.setRefreshing(true);
    }

    @Override
    public void setItemDecoration(RecyclerView.ItemDecoration decoration) {
        recyclerView.addItemDecoration(decoration);
    }

    @Override
    public RecyclerView.Adapter getAdapter() {
        return recyclerView.getAdapter();
    }
}

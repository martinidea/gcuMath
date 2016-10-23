package com.gcu.math.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gcu.math.R;
import com.gcu.math.base.BaseFragment;
import com.gcu.math.presenter.fragment.HotPresenter;
import com.gcu.math.view.iFragment.IHotFragment;
import com.gcu.math.view.ui.RefreshLayout;

import butterknife.BindView;

/**
 * Created by Martin on 2016/9/4.
 */
public class HotFragment extends BaseFragment implements IHotFragment {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refresh_layout)
    RefreshLayout refreshLayout;

    HotPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        presenter = new HotPresenter(this);
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
        return view;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_hot;
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
        getContext().getTheme().resolveAttribute(android.support.v7.appcompat.R.attr.actionBarSize, typed_value, true);
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

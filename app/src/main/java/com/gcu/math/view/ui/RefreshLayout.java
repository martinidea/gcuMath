package com.gcu.math.view.ui;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewConfiguration;

import com.gcu.math.R;

/**
 * Created by Martin on 2016/9/7.
 */
public class RefreshLayout extends SwipeRefreshLayout {

    public interface OnScrollListener {
        void onRefresh();

        void onLoad();
    }


    private RecyclerView mRecyclerView;
    private OnScrollListener onOnScrollListener;
    private boolean mLoading;
    private int scrollY;
    private int minScrollSlop;


    public void setOnOnScrollListener(final OnScrollListener onOnScrollListener) {
        this.onOnScrollListener = onOnScrollListener;
        setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                onOnScrollListener.onRefresh();
            }
        });
    }

    public RefreshLayout(Context context) {
        this(context, null);
    }

    public RefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        minScrollSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        if (mRecyclerView == null)
            getRecyclerView();
        setColorSchemeResources(R.color.refresh_color1, R.color.refresh_color2, R.color.refresh_color3);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    private void getRecyclerView() {
        if (getChildCount() > 0) {
            View childView = getChildAt(0);
            if (childView instanceof RecyclerView) {
                mRecyclerView = (RecyclerView) childView;
                mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                    @Override
                    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                        super.onScrolled(recyclerView, dx, dy);
                        scrollY = dy;
                    }

                    @Override
                    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                        super.onScrollStateChanged(recyclerView, newState);
                        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                        //判断是当前layoutManager是否为LinearLayoutManager
                        if (layoutManager instanceof LinearLayoutManager) {
                            if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                                if (isBottom())
                                    load();
                            }
                        }

                    }
                });
            }
        }
    }

    private void load() {
        setLoading(true);
        onOnScrollListener.onLoad();
    }

    public void setLoading(boolean loading) {
        this.mLoading = loading;
        if (mLoading) {

        } else {

        }
    }

    private boolean isBottom() {
        if (mRecyclerView != null && mRecyclerView.getAdapter() != null) {
            RecyclerView.LayoutManager layoutManager = mRecyclerView.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                LinearLayoutManager manager = (LinearLayoutManager) layoutManager;
                return manager.findLastVisibleItemPosition() == mRecyclerView.getAdapter().getItemCount() - 1;
            }
        }
        return false;
    }

}

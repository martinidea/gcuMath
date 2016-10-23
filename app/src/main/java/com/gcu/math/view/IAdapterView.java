package com.gcu.math.view;

import android.support.v7.widget.RecyclerView;

import com.gcu.math.base.IView;

/**
 * Created by Martin on 2016/10/10.
 */
public interface IAdapterView extends IView {
    void setAdapter(RecyclerView.Adapter adapter);
    void setLayoutManager(RecyclerView.LayoutManager layoutManager);
    void setRefreshFinish();
    void setLoadFinish();
    void setRefreshStart();
    void setItemDecoration(RecyclerView.ItemDecoration decoration);
    RecyclerView.Adapter getAdapter();
}

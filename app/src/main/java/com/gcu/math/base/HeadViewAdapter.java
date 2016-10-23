package com.gcu.math.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Martin on 2016/10/10.
 */
public abstract class HeadViewAdapter<T> extends RecyclerView.Adapter<ViewHolder> {
    protected Context mContext;
    protected int mLayoutId;
    protected int headViewId;
    protected List<T> mDatas;
    protected LayoutInflater mInflater;

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener mOnItemClickLitener) {
        this.mOnItemClickListener = mOnItemClickLitener;
    }

    public HeadViewAdapter(Context context, int layoutId, int headViewID, List<T> datas) {
        this.mDatas = datas;
        init(context, layoutId, headViewID);
    }

    public HeadViewAdapter(Context context, int layoutId, int headViewId) {
        this.mDatas = new ArrayList<>();
        init(context, layoutId, headViewId);
    }

    public T getItem(int position) {
        return mDatas.get(position);
    }

    private void init(Context context, int layoutId, int headViewId) {
        this.mContext = context;
        this.mLayoutId = layoutId;
        this.mInflater = LayoutInflater.from(context);
        this.headViewId = headViewId;
        mDatas.add(null);
    }

    public Context getContext() {
        return mContext;
    }

    public void clear() {
        mDatas.clear();
        notifyDataSetChanged();
    }

    public void addAll(List<T> datas) {
        for (T data : datas) {
            if (!mDatas.contains(data))
                mDatas.add(data);
        }
        notifyDataSetChanged();
    }

    public void add(T data) {
        if (!mDatas.contains(data))
            mDatas.add(data);
        notifyDataSetChanged();
    }

    public void addAllFirst(List<T> datas) {
        int index = 1;
        for (T data : datas) {
            if (!mDatas.contains(data))
                mDatas.add(index++, data);
        }
        notifyDataSetChanged();
    }

    public void addFirst(T data) {
        if (!mDatas.contains(data))
            mDatas.add(1, data);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder holder;
        if (viewType == headViewId)
            holder = ViewHolder.getHolder(mContext, parent, headViewId);
        else
            holder = ViewHolder.getHolder(mContext, parent, mLayoutId);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        if (position == 0) {
            convertHead(holder);
            return;
        }
        convert(holder, mDatas.get(position));
        if (mOnItemClickListener != null && position != 0) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickListener.onItemClick(holder.itemView, pos);
                }
            });
        }
    }

    public abstract void convertHead(ViewHolder holder);

    public abstract void convert(ViewHolder holder, T data);

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0)
            return headViewId;
        else
            return mLayoutId;
    }
}

package com.gcu.math.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Martin on 2016/9/10.
 */
public abstract class CommonAdapter<T> extends RecyclerView.Adapter<ViewHolder> {
    private Context mContext;
    private int mLayoutId;
    private List<T> mDatas;
    private OnItemClickListener mOnItemClickListener;

    private LayoutInflater mInflater;

    public CommonAdapter(Context context, int layoutId, List<T> datas) {
        this.mContext = context;
        this.mLayoutId = layoutId;
        this.mDatas = datas;
        this.mInflater = LayoutInflater.from(context);
    }

    public CommonAdapter(Context context, int layoutId) {
        this.mContext = context;
        this.mLayoutId = layoutId;
        this.mDatas = new ArrayList<>();
        this.mInflater = LayoutInflater.from(context);
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);

    }

    public void setOnItemClickListener(OnItemClickListener mOnItemClickLitener) {
        this.mOnItemClickListener = mOnItemClickLitener;
    }

    public Context getContext() {
        return mContext;
    }

    public void resetIndex() {
        index = 0;
    }

    protected int index = 0;

    public void clear() {
        mDatas.clear();
        notifyDataSetChanged();
    }

    public T getItem(int postion) {
        return mDatas.get(postion);
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
        resetIndex();
        for (T data : datas) {
            if (!mDatas.contains(data))
                mDatas.add(index++, data);
        }
        notifyDataSetChanged();
    }

    public void addFirst(T data) {
        resetIndex();
        if (!mDatas.contains(data))
            mDatas.add(index, data);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder holder = ViewHolder.getHolder(mContext, parent, mLayoutId);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        convert(holder, mDatas.get(position));
        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickListener.onItemClick(holder.itemView, pos);
                }
            });
        }
    }

    public abstract void convert(ViewHolder holder, T data);

    @Override
    public int getItemCount() {
        return mDatas.size();
    }
}

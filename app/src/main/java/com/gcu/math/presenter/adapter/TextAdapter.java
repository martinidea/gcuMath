package com.gcu.math.presenter.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gcu.math.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Martin on 2016/9/2.
 */
public class TextAdapter extends RecyclerView.Adapter<TextAdapter.ViewHolder> {
    private List<String> datas = null;

    public TextAdapter(List<String> datas) {
        this.datas = datas;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_text, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String s = datas.get(position);
        holder.bindData(s);
        holder.itemView.setTag(s);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public void addItem(String s) {
        datas.add(s);
        notifyDataSetChanged();
    }

    public void addFirst(String s) {
        datas.add(0, s);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.list_text)
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindData(String s) {
            if (s != null)
                textView.setText(s);
        }


    }

}

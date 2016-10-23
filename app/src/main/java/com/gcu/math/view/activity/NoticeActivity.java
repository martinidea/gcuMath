package com.gcu.math.view.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.gcu.math.R;
import com.gcu.math.base.BaseActivity;
import com.gcu.math.base.CommonAdapter;
import com.gcu.math.base.ViewHolder;
import com.gcu.math.view.iActivity.INoticeActivity;
import com.gcu.math.view.ui.RefreshLayout;
import com.gcu.math.view.ui.TopBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Martin on 2016/9/6.
 */
public class NoticeActivity extends BaseActivity implements INoticeActivity {

    @BindView(R.id.topBar)
    TopBar topBar;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refresh_layout)
    RefreshLayout refreshLayout;

    private List<String> datas;
    private CommonAdapter<String> adapter;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    refresh();
                    refreshLayout.setRefreshing(false);
                    break;
                case 2:
                    load();
                    refreshLayout.setLoading(false);
                    break;
            }

        }


    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        datas = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            datas.add("小小的" + i);
        }
        refreshLayout.setOnOnScrollListener(new RefreshLayout.OnScrollListener() {
            @Override
            public void onRefresh() {
                handler.sendEmptyMessageDelayed(1, 2000);
            }

            @Override
            public void onLoad() {
                handler.sendEmptyMessageDelayed(2, 2000);
            }
        });
        adapter = new CommonAdapter<String>(getContext(), R.layout.item_text, datas) {
            @Override
            public void convert(ViewHolder holder, String data) {
                TextView tv = holder.getView(R.id.list_text);
                tv.setText(data);
            }
        };
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void load() {
        for (int i = 0; i < 10; i++) {
            adapter.add("load" + i);
        }

    }

    private void refresh() {
        for (int i = 0; i < 10; i++) {
            adapter.addFirst("load" + i);
        }
    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_notice;
    }
}

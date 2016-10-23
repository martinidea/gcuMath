package com.gcu.math.presenter.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.gcu.math.R;
import com.gcu.math.base.CommonAdapter;
import com.gcu.math.base.ViewHolder;
import com.gcu.math.base.net.NetCallBackJson;
import com.gcu.math.base.util.DataUtils;
import com.gcu.math.model.bean.Section;
import com.gcu.math.model.biz.ISectionListBiz;
import com.gcu.math.model.event.SectionEvent;
import com.gcu.math.model.impl.SectionListBiz;
import com.gcu.math.view.activity.QuestionListActivity;
import com.gcu.math.view.iFragment.ISectionFragment;
import com.gcu.math.view.ui.DividerGridItemDecoration;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONObject;

/**
 * Created by Martin on 2016/10/17.
 */
public class SectionPresenter {
    private ISectionFragment iView;
    private ISectionListBiz biz;
    private CommonAdapter<Section> adapter;

    public SectionPresenter(final ISectionFragment iView) {
        this.iView = iView;
        biz = new SectionListBiz();
        biz.getList(new NetCallBackJson() {
            @Override
            public void onMySuccess(int statusCode, JSONObject result) {
                iView.setRefreshFinish();
                adapter.addAll(DataUtils.response2ListT(result,Section.class));
            }

            @Override
            public void onMyFailure(String errorResponse) {
                iView.showToast(errorResponse);
            }
        });
        adapter = new CommonAdapter<Section>(iView.getContext(), R.layout.item_section) {
            @Override
            public void convert(ViewHolder holder, Section data) {
                SimpleDraweeView image = holder.getView(R.id.image);
                TextView text = holder.getView(R.id.text);
                image.setImageURI(data.getImg_url());
                text.setText(data.getName());
            }
        };
        adapter.setOnItemClickListener(new CommonAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Section section = adapter.getItem(position);
                SectionEvent event = new SectionEvent(section);
                EventBus.getDefault().postSticky(event);
                iView.toActivity(QuestionListActivity.class);
            }
        });
        iView.setRefreshStart();
        iView.setAdapter(adapter);
        iView.setLayoutManager(new GridLayoutManager(iView.getContext(), 3));
        iView.setItemDecoration(new DividerGridItemDecoration(iView.getContext()));
    }

    public void refresh() {
        biz.getList(new NetCallBackJson() {
            @Override
            public void onMySuccess(int statusCode, JSONObject response) {
                iView.setRefreshFinish();
                adapter.addAllFirst(DataUtils.response2ListT(response, Section.class));
            }

            @Override
            public void onMyFailure(String errorResponse) {
                iView.showToast(errorResponse);
            }
        });
    }
}

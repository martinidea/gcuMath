package com.gcu.math.view.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;

import com.gcu.math.R;
import com.gcu.math.base.BaseActivity;
import com.gcu.math.model.bean.Section;
import com.gcu.math.model.event.SectionEvent;
import com.gcu.math.presenter.activity.QuestionListPresenter;
import com.gcu.math.view.iActivity.IQuestionListActivity;
import com.gcu.math.view.ui.RefreshLayout;
import com.gcu.math.view.ui.TopBar;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;

/**
 * Created by Martin on 2016/10/17.
 */
public class QuestionListActivity extends BaseActivity implements IQuestionListActivity {
    @BindView(R.id.topBar)
    TopBar topBar;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refresh_layout)
    RefreshLayout refreshLayout;

    private QuestionListPresenter presenter;
    private Section section;

    public String getSectionId() {
        return section.get_id().get$oid();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
        presenter = new QuestionListPresenter(this);
        refreshLayout.setOnOnScrollListener(new RefreshLayout.OnScrollListener() {
            @Override
            public void onRefresh() {
                presenter.refresh();
            }

            @Override
            public void onLoad() {
                presenter.refresh();
            }
        });
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEvent(SectionEvent event) {
        section = event.getSection();
        topBar.setTitle(section.getName());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_question_list;
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

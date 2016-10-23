package com.gcu.math.view.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;

import com.gcu.math.R;
import com.gcu.math.base.BaseActivity;
import com.gcu.math.model.bean.ItemQuestion;
import com.gcu.math.model.bean.Question;
import com.gcu.math.model.bean.User;
import com.gcu.math.model.event.ItemQuestionEvent;
import com.gcu.math.presenter.activity.QuestionPresenter;
import com.gcu.math.view.iActivity.IQuestionActivity;
import com.gcu.math.view.ui.RefreshLayout;
import com.gcu.math.view.ui.TopBar;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;

/**
 * Created by Martin on 2016/10/10.
 */
public class QuestionActivity extends BaseActivity implements IQuestionActivity {

    @BindView(R.id.topBar)
    TopBar topBar;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refresh_layout)
    RefreshLayout refreshLayout;

    private QuestionPresenter presenter;
    private ItemQuestion itemQuestion;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_question;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
        presenter = new QuestionPresenter(this);
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

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEvent(ItemQuestionEvent questionEvent) {
        itemQuestion = questionEvent.getItemQuestion();
        topBar.setTitle(itemQuestion.getData().getTitle());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
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
        refreshLayout.setRefreshing(true);
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

    @Override
    public Question getQuestion() {
        return itemQuestion == null ? null : itemQuestion.getData();
    }

    @Override
    public User getUser() {
        return itemQuestion == null ? null : itemQuestion.getUser();
    }
}

package com.gcu.math.presenter.listener;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.gcu.math.base.CommonAdapter;
import com.gcu.math.base.HeadViewAdapter;
import com.gcu.math.model.bean.ItemQuestion;
import com.gcu.math.model.event.ItemQuestionEvent;
import com.gcu.math.view.IAdapterView;
import com.gcu.math.view.activity.QuestionActivity;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Martin on 2016/10/17.
 */
public class OnClickQuestionListener implements CommonAdapter.OnItemClickListener, HeadViewAdapter.OnItemClickListener {
    private IAdapterView iView;
    private RecyclerView.Adapter adapter;
    private ItemQuestion question;

    public OnClickQuestionListener(IAdapterView iView) {
        this.iView = iView;
    }

    @Override
    public void onItemClick(View view, int position) {
        iView.toActivity(QuestionActivity.class);
        adapter = iView.getAdapter();
        if (adapter instanceof CommonAdapter) {
            question = (ItemQuestion) ((CommonAdapter) adapter).getItem(position);
        } else if (adapter instanceof HeadViewAdapter) {
            question = (ItemQuestion) ((HeadViewAdapter) adapter).getItem(position);
        }
        ItemQuestionEvent event = new ItemQuestionEvent(question);
        EventBus.getDefault().postSticky(event);
    }
}

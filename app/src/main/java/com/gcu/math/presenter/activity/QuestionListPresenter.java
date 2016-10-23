package com.gcu.math.presenter.activity;

import android.support.v7.widget.LinearLayoutManager;

import com.gcu.math.base.CommonAdapter;
import com.gcu.math.base.net.NetCallBackJson;
import com.gcu.math.base.util.DataUtils;
import com.gcu.math.base.util.LogUtil;
import com.gcu.math.model.bean.ItemQuestion;
import com.gcu.math.model.biz.QuestionListType;
import com.gcu.math.model.impl.QuestionListBiz;
import com.gcu.math.presenter.adapter.QuestionAdapter;
import com.gcu.math.presenter.listener.OnClickQuestionListener;
import com.gcu.math.view.iActivity.IQuestionListActivity;

import org.json.JSONObject;

/**
 * Created by Martin on 2016/10/17.
 */
public class QuestionListPresenter {
    private IQuestionListActivity iView;
    private QuestionListBiz biz;
    private CommonAdapter<ItemQuestion> adapter;

    public QuestionListPresenter(final IQuestionListActivity iView) {
        this.iView = iView;
        biz = new QuestionListBiz();
        adapter = new QuestionAdapter(iView.getContext());
        biz.setSectionId(iView.getSectionId());
        biz.getQuestionList(QuestionListType.SECTION_QUESTION, new NetCallBackJson() {
            @Override
            public void onMySuccess(int statusCode, JSONObject response) {
                iView.setRefreshFinish();
                adapter.addAll(DataUtils.response2ItemQuestion(response));
            }

            @Override
            public void onMyFailure(String errorResponse) {
                iView.showToast(errorResponse);
                iView.setRefreshFinish();
            }
        });
        adapter.setOnItemClickListener(new OnClickQuestionListener(iView));
        iView.setRefreshStart();
        iView.setAdapter(adapter);
        iView.setLayoutManager(new LinearLayoutManager(iView.getContext()));
    }

    public void refresh() {
        LogUtil.e("refresh");
        biz.getQuestionList(QuestionListType.SECTION_QUESTION, new NetCallBackJson() {
            @Override
            public void onMySuccess(int statusCode, JSONObject response) {
                iView.setRefreshFinish();
                adapter.addAllFirst(DataUtils.response2ItemQuestion(response));
            }

            @Override
            public void onMyFailure(String errorResponse) {
                iView.showToast(errorResponse);
                iView.setRefreshFinish();
            }
        });
    }

    public void load() {
    }

}

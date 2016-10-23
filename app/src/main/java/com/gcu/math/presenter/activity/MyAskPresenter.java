package com.gcu.math.presenter.activity;

import android.support.v7.widget.LinearLayoutManager;

import com.gcu.math.Constants;
import com.gcu.math.base.CommonAdapter;
import com.gcu.math.base.net.NetCallBackJson;
import com.gcu.math.base.util.DataUtils;
import com.gcu.math.base.util.LogUtil;
import com.gcu.math.base.util.PreferencesUtils;
import com.gcu.math.model.bean.ItemQuestion;
import com.gcu.math.model.biz.QuestionListType;
import com.gcu.math.model.impl.QuestionListBiz;
import com.gcu.math.presenter.adapter.QuestionAdapter;
import com.gcu.math.presenter.listener.OnClickQuestionListener;
import com.gcu.math.view.iActivity.IMyAskActivity;

import org.json.JSONObject;

/**
 * Created by Martin on 2016/10/9.
 */
public class MyAskPresenter {

    private IMyAskActivity iView;
    private CommonAdapter<ItemQuestion> adapter;
    private QuestionListBiz biz;

    public MyAskPresenter(final IMyAskActivity iView) {
        this.iView = iView;
        adapter = new QuestionAdapter(iView.getContext());
        biz = new QuestionListBiz();
        biz.setUserId(PreferencesUtils.getString(Constants.SpKey.KEY_USERNAME));
        biz.getQuestionList(QuestionListType.OWN, new NetCallBackJson() {
            @Override
            public void onMySuccess(int statusCode, JSONObject result) {
                iView.setRefreshFinish();
                adapter.addAll(DataUtils.response2ItemQuestion(result));
            }

            @Override
            public void onMyFailure(String errorResponse) {
                iView.showToast(errorResponse);
                iView.setRefreshFinish();
            }
        });
        adapter.setOnItemClickListener(new OnClickQuestionListener(iView));
        iView.setAdapter(adapter);
        iView.setLayoutManager(new LinearLayoutManager(iView.getContext()));
        iView.setRefreshStart();
    }

    public void refresh() {
        LogUtil.e("refresh");
        biz.getQuestionList(QuestionListType.OWN, new NetCallBackJson() {
            @Override
            public void onMySuccess(int statusCode, JSONObject result) {
                iView.setRefreshFinish();
                adapter.addAllFirst(DataUtils.response2ItemQuestion(result));
            }

            @Override
            public void onMyFailure(String errorResponse) {
                iView.showToast(errorResponse);
                iView.setRefreshFinish();
            }
        });
    }

    public void load() {
        iView.setLoadFinish();
    }
}

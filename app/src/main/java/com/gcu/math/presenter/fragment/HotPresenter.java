package com.gcu.math.presenter.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.gcu.math.base.CommonAdapter;
import com.gcu.math.base.net.NetCallBackJson;
import com.gcu.math.base.util.DataUtils;
import com.gcu.math.base.util.LogUtil;
import com.gcu.math.model.bean.ItemQuestion;
import com.gcu.math.model.biz.QuestionListType;
import com.gcu.math.model.impl.QuestionListBiz;
import com.gcu.math.presenter.adapter.QuestionAdapter;
import com.gcu.math.presenter.listener.OnClickQuestionListener;
import com.gcu.math.view.iFragment.IHotFragment;

import org.json.JSONObject;

/**
 * Created by Martin on 2016/10/9.
 */
public class HotPresenter {

    private IHotFragment iView;
    private CommonAdapter<ItemQuestion> adapter;
    private QuestionListBiz biz;

    public HotPresenter(final IHotFragment iView) {
        this.iView = iView;
        biz = new QuestionListBiz();
        adapter = new QuestionAdapter(iView.getContext());
        adapter.setOnItemClickListener(new CommonAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }
        });
        biz.getQuestionList(QuestionListType.HOT, new NetCallBackJson() {

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
// TODO: 2016/10/9 refresh code
        biz.getQuestionList(QuestionListType.HOT, new NetCallBackJson() {
            @Override
            public void onMySuccess(int statusCode, JSONObject result) {
                adapter.clear();
                adapter.addAll(DataUtils.response2ItemQuestion(result));
                iView.setRefreshFinish();
            }

            @Override
            public void onMyFailure(String errorResponse) {
                iView.showToast(errorResponse);
                iView.setRefreshFinish();
            }
        });
        LogUtil.e("refresh");
    }

    public void load() {
        LogUtil.e("load");
// TODO: 2016/10/9 load code
        iView.setLoadFinish();
    }
}

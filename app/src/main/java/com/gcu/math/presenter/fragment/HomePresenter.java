package com.gcu.math.presenter.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.gcu.math.R;
import com.gcu.math.base.HeadViewAdapter;
import com.gcu.math.base.ViewHolder;
import com.gcu.math.base.net.NetCallBackJson;
import com.gcu.math.base.util.DataUtils;
import com.gcu.math.base.util.LogUtil;
import com.gcu.math.model.bean.ItemQuestion;
import com.gcu.math.model.biz.QuestionListType;
import com.gcu.math.model.impl.QuestionListBiz;
import com.gcu.math.presenter.adapter.HomeAdapter;
import com.gcu.math.presenter.listener.OnClickQuestionListener;
import com.gcu.math.view.activity.FormulaActivity;
import com.gcu.math.view.activity.KnowledgeActivity;
import com.gcu.math.view.activity.NoticeActivity;
import com.gcu.math.view.activity.ShareActivity;
import com.gcu.math.view.iFragment.IHomeFragment;
import com.gcu.math.view.ui.BlackBoardView;
import com.gcu.math.view.ui.CardView;

import org.json.JSONObject;

/**
 * Created by Martin on 2016/9/4.
 */
public class HomePresenter implements View.OnClickListener {
    private IHomeFragment iView;
    private QuestionListBiz biz;
    private HeadViewAdapter<ItemQuestion> adapter;
    private BlackBoardView blackBoard;
    private CardView formula, share, knowledge;

    public HomePresenter(final IHomeFragment iView) {
        this.iView = iView;
        biz = new QuestionListBiz();
        adapter = new HomeAdapter(iView.getContext()) {
            @Override
            public void convertHead(ViewHolder holder) {
                blackBoard = holder.getView(R.id.blackBoard);
                formula = holder.getView(R.id.formula_card);
                share = holder.getView(R.id.share_card);
                knowledge = holder.getView(R.id.knowledge_card);
                blackBoard.setOnClickListener(HomePresenter.this);
                formula.setOnClickListener(HomePresenter.this);
                share.setOnClickListener(HomePresenter.this);
                knowledge.setOnClickListener(HomePresenter.this);
            }

        };
        biz.getQuestionList(QuestionListType.NEW, new NetCallBackJson() {
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
                }

        );
        adapter.setOnItemClickListener(new OnClickQuestionListener(iView));
        iView.setAdapter(adapter);
        iView.setLayoutManager(new LinearLayoutManager(iView.getContext()));
        iView.setRefreshStart();
    }

    public void refresh() {
// TODO: 2016/10/9 refresh code
        biz.getQuestionList(QuestionListType.NEW, new NetCallBackJson() {
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
        LogUtil.e("refresh");

    }


    public void load() {
        LogUtil.e("load");
// TODO: 2016/10/9 load code
        iView.setLoadFinish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.knowledge_card:
                iView.toActivity(KnowledgeActivity.class);
                break;
            case R.id.formula_card:
                iView.toActivity(FormulaActivity.class);
                break;
            case R.id.share_card:
                iView.toActivity(ShareActivity.class);
                break;
            case R.id.blackBoard:
                iView.toActivity(NoticeActivity.class);
                break;
        }
    }


}

package com.gcu.math.model.impl;

import com.gcu.math.Constants;
import com.gcu.math.base.net.HttpClientUtils;
import com.gcu.math.base.net.NetCallBackJson;
import com.gcu.math.model.biz.IQuestionBiz;
import com.loopj.android.http.RequestParams;

/**
 * Created by Martin on 2016/10/17.
 */
public class QuestionBiz implements IQuestionBiz {
    String question_id;

    public void setQuestion_id(String question_id) {
        this.question_id = question_id;
    }

    public String getQuestion_id() {
        return question_id;
    }

    @Override
    public void getReplyList(NetCallBackJson listener) {
        RequestParams params = new RequestParams();
        params.put(Constants.HttpKey.KEY_QUESTION_QUESTION_ID, getQuestion_id());
        HttpClientUtils.Get(Constants.HttpPath.REPLY_LIST, params, listener);
    }
}

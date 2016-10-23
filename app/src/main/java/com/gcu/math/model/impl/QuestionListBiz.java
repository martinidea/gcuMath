package com.gcu.math.model.impl;

import com.gcu.math.Constants;
import com.gcu.math.base.net.HttpClientUtils;
import com.gcu.math.base.net.NetCallBackJson;
import com.gcu.math.model.biz.IQuestionListBiz;
import com.gcu.math.model.biz.QuestionListType;
import com.loopj.android.http.RequestParams;

/**
 * Created by Martin on 2016/10/6.
 */
public class QuestionListBiz implements IQuestionListBiz {

    private String userId;
    private String sectionId;


    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public String getSectionId() {
        return sectionId;
    }

    @Override
    public void getQuestionList(QuestionListType type, NetCallBackJson listener) {
        RequestParams params = new RequestParams();
        switch (type) {
            case OWN:
                params.put(Constants.HttpKey.KEY_QUESTION_TYPE, Constants.HttpValue.OWN);
                params.put(Constants.HttpKey.KEY_QUESTION_USER_ID, getUserId());
                break;
            case NEW:
                params.put(Constants.HttpKey.KEY_QUESTION_TYPE, Constants.HttpValue.NEW);
                break;
            case HOT:
                params.put(Constants.HttpKey.KEY_QUESTION_TYPE, Constants.HttpValue.HOT);
                break;
            case SECTION_QUESTION:
                params.put(Constants.HttpKey.KEY_QUESTION_TYPE, Constants.HttpValue.SECTION_QUESTION);
                params.put(Constants.HttpKey.KEY_QUESTION_SECTION_ID, getSectionId());
                break;
        }
        HttpClientUtils.Get(Constants.HttpPath.QUESTION_LIST, params, listener);
    }
}

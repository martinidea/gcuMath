package com.gcu.math.model.biz;

import com.gcu.math.base.net.NetCallBackJson;

/**
 * Created by Martin on 2016/10/6.
 */
public interface IQuestionListBiz {
    void getQuestionList(QuestionListType type, NetCallBackJson listener);
}

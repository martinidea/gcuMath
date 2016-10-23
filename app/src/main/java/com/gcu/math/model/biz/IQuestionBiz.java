package com.gcu.math.model.biz;

import com.gcu.math.base.net.NetCallBackJson;

/**
 * Created by Martin on 2016/10/17.
 */
public interface IQuestionBiz {
    void getReplyList(NetCallBackJson listener);
}

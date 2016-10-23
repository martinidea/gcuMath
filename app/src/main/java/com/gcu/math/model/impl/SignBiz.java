package com.gcu.math.model.impl;

import com.gcu.math.Constants;
import com.gcu.math.base.net.HttpClientUtils;
import com.gcu.math.base.net.NetCallBackJson;
import com.gcu.math.model.biz.ISignBiz;
import com.loopj.android.http.RequestParams;

/**
 * Created by Martin on 2016/9/4.
 */
public class SignBiz implements ISignBiz {
    @Override
    public void sign(RequestParams params,  NetCallBackJson listener) {
        HttpClientUtils.Post(Constants.HttpPath.SIGN, params, listener);
    }

}

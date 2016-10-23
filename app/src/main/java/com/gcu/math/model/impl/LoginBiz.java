package com.gcu.math.model.impl;

import com.gcu.math.Constants;
import com.gcu.math.base.net.HttpClientUtils;
import com.gcu.math.base.net.NetCallBackJson;
import com.gcu.math.model.biz.ILoginBiz;
import com.loopj.android.http.RequestParams;

/**
 * Created by Martin on 2016/9/3.
 */
public class LoginBiz implements ILoginBiz {


    @Override
    public void login(String username, String password, final NetCallBackJson listener) {
        RequestParams params = new RequestParams();
        params.put(Constants.HttpKey.KEY_LOGIN_NAME, username);
        params.put(Constants.HttpKey.KEY_LOGIN_PWD, password);
        login(params, listener);
    }

    @Override
    public void login(RequestParams params, final NetCallBackJson listener) {
        HttpClientUtils.Post(Constants.HttpPath.LOGIN, params, listener);
    }

}


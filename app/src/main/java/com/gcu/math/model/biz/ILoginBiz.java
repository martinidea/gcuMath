package com.gcu.math.model.biz;

import com.gcu.math.base.net.NetCallBackJson;
import com.loopj.android.http.RequestParams;

/**
 * Created by Martin on 2016/9/3.
 */
public interface ILoginBiz{

    void login(String username, String password, NetCallBackJson listener);

    void login(RequestParams params,NetCallBackJson listener);

}

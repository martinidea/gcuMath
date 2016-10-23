package com.gcu.math.model.biz;

import com.gcu.math.base.net.NetCallBackJson;
import com.loopj.android.http.RequestParams;

/**
 * Created by Martin on 2016/9/4.
 */
public interface ISignBiz {
    void sign(RequestParams params, NetCallBackJson listener);
}

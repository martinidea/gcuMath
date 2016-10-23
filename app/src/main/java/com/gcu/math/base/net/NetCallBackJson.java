package com.gcu.math.base.net;

import android.util.Log;

import com.gcu.math.base.util.DataUtils;
import com.gcu.math.base.util.LogUtil;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public abstract class NetCallBackJson extends JsonHttpResponseHandler {
    @Override
    public void onStart() {
        Log.i("info", "请求开始");
        super.onStart();
    }


    @Override
    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
        LogUtil.e("请求失败！" + errorResponse + throwable.getMessage());
        if (statusCode == 0) {
            onMyFailure("网络讲求超时，请重试");
        } else if (errorResponse != null) {
            onMyFailure(errorResponse.toString());
        } else {
            onMyFailure(throwable.getMessage());
        }

    }

    @Override
    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
        LogUtil.e("请求成功！" + response);
        if (statusCode == 200) {
            int status = DataUtils.getStatus(response);
            if (status != 0) {
                onMySuccess(statusCode, response);
            } else {
                String msg = DataUtils.getMSG(response);
                onMyFailure(msg);
            }
        }
    }

    public abstract void onMySuccess(int statusCode, JSONObject response);

    public abstract void onMyFailure(String errorResponse);

}

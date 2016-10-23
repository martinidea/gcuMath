package com.gcu.math.base.net;

import android.util.Log;

import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

public abstract class NetCallBack extends AsyncHttpResponseHandler {

    @Override
    public void onStart() {
        Log.i("info", "请求开始");
        super.onStart();
    }

    @Override
    public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {

        Log.i("info", "请求失败");
        onMyFailure(new String(arg2));
    }

    @Override
    public void onSuccess(int arg0, Header[] arg1, byte[] arg2) {
        Log.i("info", "请求成功");
        Log.i("info", new String(arg2));
        onMySuccess(arg0, new String(arg2));
    }

    public abstract void onMySuccess(int statusCode, String result);

    public abstract void onMyFailure(String result);

}

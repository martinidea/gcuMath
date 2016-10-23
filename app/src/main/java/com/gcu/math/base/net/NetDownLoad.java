package com.gcu.math.base.net;


import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

public abstract class NetDownLoad extends AsyncHttpResponseHandler {

    @Override
    public void onFailure(int statusCode, Header[] arg1, byte[] arg2, Throwable arg3) {
        onMyFailure(new String(arg2));
    }

    @Override
    public void onSuccess(int statusCode, Header[] arg1, byte[] result) {
        onMySuccess(statusCode, result);
    }

    public abstract void onMySuccess(int statusCode, byte[] result);

    public abstract void onMyFailure(String result);

}

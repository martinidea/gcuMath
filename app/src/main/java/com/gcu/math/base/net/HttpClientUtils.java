package com.gcu.math.base.net;

import android.content.Context;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.BinaryHttpResponseHandler;
import com.loopj.android.http.PersistentCookieStore;
import com.loopj.android.http.RequestParams;

public class HttpClientUtils {
    private static AsyncHttpClient client = null;
    private static int timeOut = 25000;

    private HttpClientUtils() {
    }

    public synchronized static AsyncHttpClient getInstance(Context paramContext) {
        if (client == null) {
            client = new AsyncHttpClient();
            PersistentCookieStore myCookieStore = new PersistentCookieStore(paramContext);
            client.setCookieStore(myCookieStore);
            client.setTimeout(timeOut);
        }
        return client;
    }

    public static void Get(String url, NetCallBackJson cbj) {
        client.get(url, cbj);
    }

    public static void Get(String url, BinaryHttpResponseHandler bhrh) {
        client.get(url, bhrh);
    }

    public static void Get(String url, RequestParams params, NetCallBackJson cbj) {
        client.get(url, params, cbj);
    }

    public static void Post(String url, NetCallBackJson cbj) {
        client.post(url, cbj);
    }

    public static void Post(String url, RequestParams params, NetCallBack cb) {
        client.post(url, params, cb);
    }

    public static void Post(String url, RequestParams params, NetCallBackJson cbj) {
        client.post(url, params, cbj);
    }

    public static void Post(String url, RequestParams params, AsyncHttpResponseHandler ahrh) {
        client.post(url, params, ahrh);
    }

    public static void CancelRequests() {
        client.cancelRequests(null, true);
    }

}

package com.gcu.math.view.activity;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.gcu.math.Constants;
import com.gcu.math.R;
import com.gcu.math.base.BaseActivity;
import com.gcu.math.view.iActivity.IAboutActivity;

import butterknife.BindView;

/**
 * Created by Martin on 2016/9/5.
 */
public class AboutActivity extends BaseActivity implements IAboutActivity {

    @BindView(R.id.web_view)
    WebView webView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(Constants.HttpPath.ABOUT);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_about;
    }
}

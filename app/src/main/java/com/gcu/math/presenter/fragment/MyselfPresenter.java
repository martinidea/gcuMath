package com.gcu.math.presenter.fragment;

import android.view.View;

import com.gcu.math.R;
import com.gcu.math.view.activity.AboutActivity;
import com.gcu.math.view.activity.LoginActivity;
import com.gcu.math.view.activity.MyAskActivity;
import com.gcu.math.view.activity.MyCollectActivity;
import com.gcu.math.view.activity.MyDownloadActivity;
import com.gcu.math.view.activity.MyInfoActivity;
import com.gcu.math.view.activity.MyReplyActivity;
import com.gcu.math.view.activity.SettingActivity;
import com.gcu.math.view.activity.TestActivity;
import com.gcu.math.view.iFragment.IMyselfFragment;

/**
 * Created by Martin on 2016/9/6.
 */
public class MyselfPresenter {

    private IMyselfFragment iView;

    public MyselfPresenter(IMyselfFragment iView) {
        this.iView = iView;
    }

    public void click(View v) {
        switch (v.getId()) {
            case R.id.soft_ask:
                toMyAsk();
                break;
            case R.id.soft_collect:
                toMyCollect();
                break;
            case R.id.soft_download:
                toMyDownLoad();
                break;
            case R.id.soft_reply:
                toMyReply();
                break;
            case R.id.relative_head:
                toMyInfo();
                break;
            case R.id.button_login:
                toLogin();
                break;
            case R.id.soft_setting:
                toSetting();
                break;
            case R.id.soft_about:
                toAbout();
                break;
            case R.id.soft_test:
                toTest();
                break;
        }
    }

    private void toTest() {
        iView.toActivity(TestActivity.class);
    }

    private void toLogin() {
        iView.toActivity(LoginActivity.class);
    }

    private void toAbout() {
        iView.toActivity(AboutActivity.class);
    }

    private void toSetting() {
        iView.toActivity(SettingActivity.class);
    }

    private void toMyDownLoad() {
        iView.toActivity(MyDownloadActivity.class);
    }

    private void toMyCollect() {
        if (iView.isLogin()) iView.toActivity(MyCollectActivity.class);
    }

    private void toMyInfo() {
        if (iView.isLogin()) iView.toActivity(MyInfoActivity.class);
    }

    private void toMyAsk() {
        if (iView.isLogin()) iView.toActivity(MyAskActivity.class);
    }

    private void toMyReply() {
        if (iView.isLogin()) iView.toActivity(MyReplyActivity.class);
    }
}

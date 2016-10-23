package com.gcu.math.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.gcu.math.Constants;
import com.gcu.math.R;
import com.gcu.math.base.BaseFragment;
import com.gcu.math.model.bean.User;
import com.gcu.math.model.event.LoginEvent;
import com.gcu.math.presenter.fragment.MyselfPresenter;
import com.gcu.math.view.iFragment.IMyselfFragment;
import com.gcu.math.view.ui.SoftView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Martin on 2016/8/31.
 */
public class MyselfFragment extends BaseFragment implements IMyselfFragment {

    @BindView(R.id.soft_ask)
    SoftView softAsk;
    @BindView(R.id.soft_reply)
    SoftView softReply;
    @BindView(R.id.soft_collect)
    SoftView softCollect;
    @BindView(R.id.soft_download)
    SoftView softDownload;
    @BindView(R.id.soft_setting)
    SoftView softSetting;
    @BindView(R.id.soft_about)
    SoftView softAbout;
    @BindView(R.id.image_head)
    SimpleDraweeView imageHead;
    @BindView(R.id.text_nick)
    TextView textNick;
    @BindView(R.id.text_point)
    TextView textPoint;
    @BindView(R.id.button_login)
    Button buttonLogin;
    @BindView(R.id.soft_test)
    SoftView softTest;
    @BindView(R.id.relative_head)
    RelativeLayout relativeHead;

    private LoginEvent loginEvent;
    private MyselfPresenter presenter;
    private User user;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        presenter = new MyselfPresenter(this);
        return view;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_myself;
    }

    @OnClick({R.id.soft_about, R.id.soft_ask, R.id.button_login,
            R.id.soft_collect, R.id.soft_download, R.id.soft_test,
            R.id.soft_reply, R.id.soft_setting, R.id.relative_head})
    public void onClick(View v) {
        presenter.click(v);
    }

    @Override
    public void showButton() {
        buttonLogin.setVisibility(View.VISIBLE);
        textNick.setVisibility(View.GONE);
        textPoint.setVisibility(View.GONE);
    }

    @Override
    public void showId() {
        textPoint.setVisibility(View.VISIBLE);
        textNick.setVisibility(View.VISIBLE);
        buttonLogin.setVisibility(View.GONE);
    }

    @Override
    public boolean isLogin() {
        return user == null ? false : true;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void onEventMainThread(LoginEvent event) {
        if (loginEvent != event) {
            this.loginEvent = event;
            user = event.getUser();
            textNick.setText(event.getUser().getNick_name());
            imageHead.setImageURI(Constants.HttpPath.HEAD_IMAGE_FIRST + user.getUser_id()
                    + Constants.HttpPath.HEAD_IMAGE_SECOND + user.getUser_id() + ".png");
            showId();
        }
    }
}

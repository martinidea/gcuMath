package com.gcu.math.view.activity;

import android.os.Bundle;
import android.view.View;

import com.facebook.drawee.view.SimpleDraweeView;
import com.gcu.math.Constants;
import com.gcu.math.R;
import com.gcu.math.base.BaseActivity;
import com.gcu.math.base.util.LogUtil;
import com.gcu.math.model.bean.User;
import com.gcu.math.model.event.LoginEvent;
import com.gcu.math.presenter.activity.MyInfoPresenter;
import com.gcu.math.view.iActivity.IMyInfoActivity;
import com.gcu.math.view.ui.SoftTextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Martin on 2016/9/6.
 */
public class MyInfoActivity extends BaseActivity implements IMyInfoActivity {


    @BindView(R.id.image_head)
    SimpleDraweeView imageHead;
    @BindView(R.id.soft_head)
    SoftTextView softHead;
    @BindView(R.id.soft_nick)
    SoftTextView softNick;
    @BindView(R.id.soft_real)
    SoftTextView softReal;
    @BindView(R.id.soft_school_num)
    SoftTextView softSchoolNum;
    @BindView(R.id.soft_year)
    SoftTextView softYear;
    @BindView(R.id.soft_grade)
    SoftTextView softGrade;
    @BindView(R.id.soft_major)
    SoftTextView softMajor;
    @BindView(R.id.soft_sec_school)
    SoftTextView softSecSchool;
    @BindView(R.id.soft_school)
    SoftTextView softSchool;
    @BindView(R.id.soft_email)
    SoftTextView softEmail;
    @BindView(R.id.soft_passWord)
    SoftTextView softPassWord;

    private MyInfoPresenter presenter;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new MyInfoPresenter(this);
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEvent(LoginEvent event) {
        LogUtil.e(TAG, "doOnEventMainThread");
        user = event.getUser();
        softNick.setValue(user.getNick_name());
        softGrade.setValue(user.getGrade());
        softSecSchool.setValue(user.getSec_school());
        softSchool.setValue(user.getSchool());
        softEmail.setValue(user.getEmail());
        softMajor.setValue(user.getMajor());
        softSchoolNum.setValue(user.getUser_id());
        softReal.setValue(user.getReal_name());
        imageHead.setImageURI(Constants.HttpPath.HEAD_IMAGE_FIRST + user.getUser_id()
                + Constants.HttpPath.HEAD_IMAGE_SECOND + user.getUser_id() + ".png");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_info;
    }

    @OnClick({R.id.image_head, R.id.soft_head, R.id.soft_nick, R.id.soft_real,
            R.id.soft_school_num, R.id.soft_grade, R.id.soft_year, R.id.soft_sec_school,
            R.id.soft_school, R.id.soft_email, R.id.soft_passWord})
    public void onClick(View view) {
        presenter.click(view);
    }
}

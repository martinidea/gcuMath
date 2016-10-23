package com.gcu.math.presenter.activity;

import com.gcu.math.Constants;
import com.gcu.math.R;
import com.gcu.math.base.net.NetCallBackJson;
import com.gcu.math.base.util.AppManager;
import com.gcu.math.model.biz.ISignBiz;
import com.gcu.math.model.impl.SignBiz;
import com.gcu.math.view.activity.LoginActivity;
import com.gcu.math.view.activity.SignActivity;
import com.gcu.math.view.iActivity.ISignActivity;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

/**
 * Created by Martin on 2016/9/4.
 */
public class SignPresenter {
    private final String SCHOOL_NUMBER;
    private final String PASSWORD;
    private final String E_MAIL;
    private final String NICK_NAME;
    private final String REAL_NAME;
    private final String MAJOR;
    private final String GRADE;
    private final String SEC_SCHOOL;

    private ISignActivity iView;
    private ISignBiz iBiz;
    private String e_mail;
    private String grade;
    private String major;
    private String nickName;
    private String passWord;
    private String realName;
    private String schoolNumber;
    private String secSchool;

    public SignPresenter(ISignActivity iView) {
        this.iView = iView;
        iBiz = new SignBiz();
        E_MAIL = iView.getStringById(R.string.e_mail);
        SCHOOL_NUMBER = iView.getStringById(R.string.school_number);
        PASSWORD = iView.getStringById(R.string.password);
        NICK_NAME = iView.getStringById(R.string.nick_name);
        REAL_NAME = iView.getStringById(R.string.real_name);
        MAJOR = iView.getStringById(R.string.major);
        GRADE = iView.getStringById(R.string.grade);
        SEC_SCHOOL = iView.getStringById(R.string.sec_school);
    }

    public void sign() {
        schoolNumber = iView.get(SignActivity.KEY_SCHOOL_NUMBER);
        if (isEmpty(schoolNumber, SCHOOL_NUMBER)) return;
        passWord = iView.get(SignActivity.KEY_PASSWORD);
        if (isEmpty(passWord, PASSWORD)) return;
        nickName = iView.get(SignActivity.KEY_NICK_NAME);
        if (isEmpty(nickName, NICK_NAME)) return;
        realName = iView.get(SignActivity.KEY_REAL_NAME);
        if (isEmpty(realName, REAL_NAME)) return;
        grade = iView.get(SignActivity.KEY_GRADE);
        if (isEmpty(grade, GRADE)) return;
        major = iView.get(SignActivity.KEY_MAJOR);
        if (isEmpty(major, MAJOR)) return;
        secSchool = iView.get(SignActivity.KEY_SEC_SCHOOL);
        if (isEmpty(secSchool, SEC_SCHOOL)) return;
        e_mail = iView.get(SignActivity.KEY_E_MAIL);
        if (isEmpty(e_mail, E_MAIL)) return;
        put();
    }

    private void put() {
        RequestParams params = new RequestParams();
        params.put(Constants.HttpKey.KEY_SIGN_EMAIL, e_mail);
        params.put(Constants.HttpKey.KEY_SIGN_GRADE, grade);
        params.put(Constants.HttpKey.KEY_SIGN_MAJOR, major);
        params.put(Constants.HttpKey.KEY_LOGIN_NAME, schoolNumber);
        params.put(Constants.HttpKey.KEY_LOGIN_PWD, passWord);
        params.put(Constants.HttpKey.KEY_SIGN_NICK_NAME, nickName);
        params.put(Constants.HttpKey.KEY_SIGN_REAL_NAME, realName);
        params.put(Constants.HttpKey.KEY_SIGN_SCHOOL, iView.getStringById(R.string.gcu));
        params.put(Constants.HttpKey.KEY_SIGN_SEC_SCHOOL, secSchool);
        params.put(Constants.HttpKey.KEY_SIGN_YEAR, schoolNumber.substring(0, 4));
        iView.showLoading(iView.getStringById(R.string.signing));
        iBiz.sign(params, new NetCallBackJson() {
            @Override
            public void onMySuccess(int statusCode, JSONObject response) {
                iView.hideLoading();
                iView.showToast("注册成功");
                AppManager.getInstance().killActivity(LoginActivity.class);
                AppManager.getInstance().killActivity(SignActivity.class);
            }

            @Override
            public void onMyFailure(String errorResponse) {
                iView.hideLoading();
                iView.showToast(errorResponse);
            }
        });
    }

    private boolean isEmpty(String s, String text) {
        if (s.isEmpty()) {
            iView.showToast(text + "不能为空");
            return true;
        }
        return false;
    }
}

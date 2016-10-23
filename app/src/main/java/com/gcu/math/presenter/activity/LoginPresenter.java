package com.gcu.math.presenter.activity;

import com.gcu.math.Constants;
import com.gcu.math.R;
import com.gcu.math.base.net.NetCallBackJson;
import com.gcu.math.base.util.AppManager;
import com.gcu.math.base.util.DataUtils;
import com.gcu.math.base.util.LogUtil;
import com.gcu.math.base.util.PreferencesUtils;
import com.gcu.math.model.bean.User;
import com.gcu.math.model.biz.ILoginBiz;
import com.gcu.math.model.event.LoginEvent;
import com.gcu.math.model.impl.LoginBiz;
import com.gcu.math.view.activity.LoginActivity;
import com.gcu.math.view.activity.SignActivity;
import com.gcu.math.view.iActivity.ILoginActivity;
import com.loopj.android.http.RequestParams;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONObject;

/**
 * Created by Martin on 2016/9/3.
 */
public class LoginPresenter {

    private ILoginActivity iView;
    private ILoginBiz iBiz;

    public LoginPresenter(ILoginActivity loginActivity) {
        this.iView = loginActivity;
        iView.setUserName(PreferencesUtils.getString(Constants.SpKey.KEY_USERNAME));
        iView.setPassWord(PreferencesUtils.getString(Constants.SpKey.KEY_PASSWORD));
    }

    public void login() {
        final String userName = iView.getUserName();
        final String passWord = iView.getPassWord();
        if (userName == null || userName.isEmpty() || passWord == null || passWord.isEmpty()) {
            iView.showToast(iView.getStringById(R.string.userName_or_passWord_is_null));
            return;
        }
        iView.showLoading(iView.getStringById(R.string.logining));
        iBiz = new LoginBiz();
        RequestParams params = new RequestParams();
        params.put(Constants.HttpKey.KEY_LOGIN_NAME, userName);
        params.put(Constants.HttpKey.KEY_LOGIN_PWD, passWord);
        iBiz.login(params, new NetCallBackJson() {
            @Override
            public void onMySuccess(int statusCode, JSONObject response) {
                iView.hideLoading();
                iView.showToast(iView.getStringById(R.string.login_success));
                AppManager.getInstance().killActivity(LoginActivity.class);
                save(userName, passWord);
                User user = DataUtils.response2T(response, User.class);
                LoginEvent event = new LoginEvent(user);
                EventBus.getDefault().postSticky(event);
            }

            @Override
            public void onMyFailure(String errorResponse) {
                iView.hideLoading();
                iView.showToast(errorResponse);
                LogUtil.e(errorResponse);
            }
        });

    }

    /**
     * 保存到SharedPreferences
     *
     * @param userName 用户名
     * @param passWord 密码
     */
    private void save(String userName, String passWord) {
        PreferencesUtils.putString(Constants.SpKey.KEY_USERNAME, userName);
        PreferencesUtils.putString(Constants.SpKey.KEY_PASSWORD, passWord);
    }

    public void sign() {
        iView.toActivity(SignActivity.class);
    }

    public void find() {
        iView.toFindPassWord();
    }
}

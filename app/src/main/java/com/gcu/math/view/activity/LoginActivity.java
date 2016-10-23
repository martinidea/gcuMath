package com.gcu.math.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.gcu.math.R;
import com.gcu.math.base.BaseActivity;
import com.gcu.math.presenter.activity.LoginPresenter;
import com.gcu.math.view.iActivity.ILoginActivity;
import com.gcu.math.view.ui.TopBar;
import com.rengwuxian.materialedittext.MaterialEditText;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements ILoginActivity{


    @BindView(R.id.topBar)
    TopBar topBar;
    @BindView(R.id.edit_username)
    MaterialEditText editUsername;
    @BindView(R.id.edit_password)
    MaterialEditText editPassword;
    @BindView(R.id.text_forget)
    TextView textForget;
    @BindView(R.id.button_login)
    Button loginBtn;
    @BindView(R.id.button_sign)
    Button signBtn;
    private LoginPresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new LoginPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public String getUserName() {
        return editUsername.getText().toString();
    }

    @Override
    public String getPassWord() {
        return editPassword.getText().toString();
    }

    @Override
    public void setUserName(String username) {
        editUsername.setText(username);
    }

    @Override
    public void setPassWord(String passWord) {
        editPassword.setText(passWord);
    }

    @Override
    public void toFindPassWord() {
        showToast(getString(R.string.forget_password));
    }

    @OnClick({R.id.button_login,R.id.button_sign,R.id.text_forget})
    void OnClick(View view){
        switch (view.getId()){
            case  R.id.button_login:
                presenter.login();
                break;
            case R.id.button_sign:
                presenter.sign();
                break;
            case R.id.text_forget:
                presenter.find();
                break;
        }
    }
}

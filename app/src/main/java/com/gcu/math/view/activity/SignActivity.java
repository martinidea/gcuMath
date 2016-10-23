package com.gcu.math.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.gcu.math.R;
import com.gcu.math.base.BaseActivity;
import com.gcu.math.presenter.activity.SignPresenter;
import com.gcu.math.view.iActivity.ISignActivity;
import com.rengwuxian.materialedittext.MaterialEditText;

import butterknife.BindView;
import butterknife.OnClick;

public class SignActivity extends BaseActivity implements ISignActivity {

    @BindView(R.id.edit_school_number)
    MaterialEditText editSchoolNumber;
    @BindView(R.id.edit_password)
    MaterialEditText editPassword;
    @BindView(R.id.edit_nick_name)
    MaterialEditText editNickName;
    @BindView(R.id.edit_real_name)
    MaterialEditText editRealName;
    @BindView(R.id.edit_sec_school)
    MaterialEditText editSecSchool;
    @BindView(R.id.edit_grade)
    MaterialEditText editGrade;
    @BindView(R.id.edit_e_mail)
    MaterialEditText editEMail;
    @BindView(R.id.button_sign)
    Button buttonSign;
    @BindView(R.id.edit_major)
    MaterialEditText editMajor;

    public final static int KEY_SCHOOL_NUMBER = 0, KEY_PASSWORD = 1, KEY_NICK_NAME = 2,
            KEY_REAL_NAME = 3, KEY_SEC_SCHOOL = 4, KEY_GRADE = 5, KEY_E_MAIL = 6, KEY_MAJOR = 7;

    private SignPresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new SignPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_sign;
    }


    @Override
    public String get(int key) {
        switch (key) {
            case KEY_SCHOOL_NUMBER:
                return editSchoolNumber.getText().toString();
            case KEY_PASSWORD:
                return editPassword.getText().toString();
            case KEY_NICK_NAME:
                return editNickName.getText().toString();
            case KEY_REAL_NAME:
                return editRealName.getText().toString();
            case KEY_MAJOR:
                return editMajor.getText().toString();
            case KEY_SEC_SCHOOL:
                return editSecSchool.getText().toString();
            case KEY_GRADE:
                return editGrade.getText().toString();
            case KEY_E_MAIL:
                return editEMail.getText().toString();
            default: 
                return null;
        }

    }

    @Override
    public void set(int key, String s) {
        switch (key) {
            case KEY_SCHOOL_NUMBER:
                 editSchoolNumber.setText(s);
            case KEY_PASSWORD:
                 editPassword.setText(s);
            case KEY_NICK_NAME:
                 editPassword.setText(s);
            case KEY_REAL_NAME:
                 editRealName.setText(s);
            case KEY_MAJOR:
                 editMajor.setText(s);
            case KEY_SEC_SCHOOL:
                 editSecSchool.setText(s);
            case KEY_GRADE:
                 editGrade.setText(s);
            case KEY_E_MAIL:
                 editEMail.setText(s);
            default:
        }

    }

    @OnClick(R.id.button_sign)
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_sign:
                presenter.sign();
                break;
        }
    }
}

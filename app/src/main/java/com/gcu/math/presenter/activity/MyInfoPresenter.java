package com.gcu.math.presenter.activity;

import android.view.View;

import com.gcu.math.R;
import com.gcu.math.view.iActivity.IMyInfoActivity;

/**
 * Created by Martin on 2016/9/6.
 */
public class MyInfoPresenter {
    private IMyInfoActivity iView;
    public MyInfoPresenter(IMyInfoActivity iView) {
        this.iView = iView;
    }

    public void click(View v){
        switch (v.getId()) {
            case R.id.image_head:
                break;
            case R.id.soft_head:
                break;
            case R.id.soft_nick:
                break;
            case R.id.soft_real:
                break;
            case R.id.soft_school_num:
                break;
            case R.id.soft_grade:
                break;
            case R.id.soft_year:
                break;
            case R.id.soft_sec_school:
                break;
            case R.id.soft_school:
                break;
            case R.id.soft_email:
                break;
            case R.id.soft_passWord:
                break;
        }
    }
}

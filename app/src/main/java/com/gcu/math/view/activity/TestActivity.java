package com.gcu.math.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.gcu.math.Constants;
import com.gcu.math.R;
import com.gcu.math.base.BaseActivity;
import com.gcu.math.base.net.HttpClientUtils;
import com.gcu.math.base.net.NetCallBackJson;

import org.json.JSONObject;

import butterknife.BindView;
import butterknife.OnClick;
import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Created by Martin on 2016/10/6.
 */
public class TestActivity extends BaseActivity {
    @BindView(R.id.button1)
    Button button1;
    @BindView(R.id.button2)
    Button button2;
    @BindView(R.id.button3)
    Button button3;
    @BindView(R.id.button4)
    Button button4;
    @BindView(R.id.text)
    TextView text;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_test;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @OnClick({R.id.button1, R.id.button2, R.id.button3, R.id.button4})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                click1();
                break;
            case R.id.button2:
                click2();
                break;
            case R.id.button3:
                click3();
                break;
            case R.id.button4:
                click4();
                break;
        }
    }

    private void click1() {

        HttpClientUtils.Get(Constants.HttpPath.FILE_LIST_SUCCESS, new NetCallBackJson() {
            @Override
            public void onMySuccess(int statusCode, JSONObject response) {
                text.setText(statusCode + "" + response);
            }

            @Override
            public void onMyFailure(String errorResponse) {

            }
        });
    }

    private void click2() {
        new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                .setTitleText("Oops...")
                .setContentText("Something went wrong!")
                .show();
    }

    private void click3() {
        new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                .setTitleText("Are you sure?")
                .setContentText("Won't be able to recover this file!")
                .setConfirmText("Yes,delete it!")
                .show();
    }

    private void click4() {
        new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
                .setTitleText("Good job!")
                .setContentText("You clicked the button!")
                .show();
    }
}

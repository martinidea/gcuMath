package com.gcu.math.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.gcu.math.base.util.AppManager;
import com.gcu.math.base.util.BasicUtils;
import com.gcu.math.base.util.LogUtil;
import com.gcu.math.base.util.ToastUtil;

import butterknife.ButterKnife;
import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Created by Martin on 2016/8/3.
 */
public abstract class BaseActivity extends AppCompatActivity implements IView {

    public String TAG;
    private SweetAlertDialog dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        AppManager.getInstance().addActivity(this);
        TAG = getClass().getSimpleName();
        LogUtil.v(TAG, "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtil.v(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtil.v(TAG, "onResume");
    }


    @Override
    protected void onStop() {
        super.onStop();
        LogUtil.v(TAG, "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogUtil.v(TAG, "onRestart");
    }

    /**
     * 回传一Activity的id直接在基类中setContentView(this id);
     *
     * @return return the Activity LayoutID ;
     */
    protected abstract int getLayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.getInstance().removeActivity(this);
        LogUtil.v(TAG, "onDestroy");
    }

    @Override
    public void showToast(CharSequence text) {
        ToastUtil.showShort(this, text);
    }

    @Override
    public void showLoading(String text) {
        if (dialog == null) {
            dialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
        }
        dialog.setTitleText(text);
        dialog.setCancelable(false);
        dialog.show();
    }

    @Override
    public void hideLoading() {
        if (dialog==null)
            return;
        if (dialog.isShowing())
            dialog.dismiss();
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public String getStringById(int resId) {
        return getString(resId);
    }

    @Override
    public void toActivity(Class classes) {
        BasicUtils.sendIntent(this, classes);
    }

}

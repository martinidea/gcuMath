package com.gcu.math.base;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gcu.math.base.util.BasicUtils;
import com.gcu.math.base.util.LogUtil;
import com.gcu.math.base.util.ToastUtil;

import butterknife.ButterKnife;
import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Created by Martin on 2016/8/31.
 */
public abstract class BaseFragment extends Fragment implements IView {
    protected View view;
    public String TAG;
    private SweetAlertDialog dialog;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.v(TAG, "onCreate");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        TAG = getClass().getSimpleName();
        LogUtil.v(TAG, "onAttach");
    }


    @Override
    public void onStart() {
        super.onStart();
        LogUtil.v(TAG, "onStart");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), getLayoutResId(), null);
        ButterKnife.bind(this, view);
        LogUtil.v(TAG, "onCreateView");
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LogUtil.v(TAG, "onActivityCreated");
    }

    @Override
    public void onResume() {
        super.onResume();
        LogUtil.v(TAG, "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        LogUtil.v(TAG, "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        LogUtil.v(TAG, "onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        LogUtil.v(TAG, "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtil.v(TAG, "onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        LogUtil.v(TAG, "onDetach");
    }

    protected abstract int getLayoutResId();

    @Override
    public String getStringById(int resId) {
        return getString(resId);
    }

    @Override
    public void showToast(CharSequence text) {
        ToastUtil.showShort(getActivity(), text);
    }

    @Override
    public void showLoading(String text) {
        if (dialog == null) {
            dialog = new SweetAlertDialog(getContext(), SweetAlertDialog.PROGRESS_TYPE);
        }
        dialog.setTitleText(text);
        dialog.setCancelable(false);
        dialog.show();
    }

    @Override
    public void hideLoading() {
        if (dialog == null)
            return;
        if (dialog.isShowing())
            dialog.dismiss();
    }

    @Override
    public Context getContext() {
        return super.getContext();
    }

    @Override
    public void toActivity(Class classes) {
        BasicUtils.sendIntent(getActivity(), classes);
    }


}

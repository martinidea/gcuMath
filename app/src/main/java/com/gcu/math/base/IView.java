package com.gcu.math.base;

import android.content.Context;

/**
 * Created by Martin on 2016/8/3.
 */
public interface IView {
    void showToast(CharSequence text);
    void showLoading(String text);
    void hideLoading();
    Context getContext();
    String getStringById(int resId);
    void toActivity(Class classes);
}

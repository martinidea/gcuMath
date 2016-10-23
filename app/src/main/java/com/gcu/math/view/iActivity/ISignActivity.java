package com.gcu.math.view.iActivity;

import com.gcu.math.base.IView;

/**
 * Created by Martin on 2016/9/4.
 */
public interface ISignActivity extends IView{
    String get(int key);
    void set(int key,String s);
}

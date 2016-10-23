package com.gcu.math.view.iActivity;

import com.gcu.math.base.IView;

/**
 * Created by Martin on 2016/9/3.
 */
public interface ILoginActivity  extends IView{
    String getUserName();
    String getPassWord();
    void setUserName(String username);
    void setPassWord(String passWord);
    void toFindPassWord();
}

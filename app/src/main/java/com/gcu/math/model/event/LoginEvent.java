package com.gcu.math.model.event;

import com.gcu.math.model.bean.User;

/**
 * Created by Martin on 2016/9/7.
 */
public class LoginEvent {
    private User user;
    private boolean isLogin;

    public LoginEvent(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

}

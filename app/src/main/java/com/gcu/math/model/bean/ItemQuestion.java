package com.gcu.math.model.bean;

/**
 * Created by Martin on 2016/10/9.
 */
public class ItemQuestion {
    private Question data;
    private User user;

    public Question getData() {
        return data;
    }

    public void setData(Question data) {
        this.data = data;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;
        return data.equals(((ItemQuestion) o).getData());
    }
}

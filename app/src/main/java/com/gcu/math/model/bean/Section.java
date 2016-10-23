package com.gcu.math.model.bean;

/**
 * Created by Martin on 2016/10/9.
 */
public class Section {

    /**
     * $oid : 57deaa68e7a76d7b18e3cb29
     */

    private IdBean _id;
    /**
     * _id : {"$oid":"57deaa68e7a76d7b18e3cb29"}
     * user_id : podger
     * name : 函数与极限
     * detail : 函数与极限
     */

    private String user_id;
    private String name;
    private String detail;
    /**
     * img_url : http://115.28.148.97:5000/static/upload/public/knowledge10.jpg
     */

    private String img_url;

    public IdBean get_id() {
        return _id;
    }

    public void set_id(IdBean _id) {
        this._id = _id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    @Override
    public boolean equals(Object o) {
        return _id.equals(((Section) o).get_id());
    }
}

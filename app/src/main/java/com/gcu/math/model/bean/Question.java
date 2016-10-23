package com.gcu.math.model.bean;

/**
 * Created by Martin on 2016/10/9.
 */
public class Question {

    /**
     * summary : <p>...</p>
     * time : 2016-10-09 21:52:01
     * title : 校花
     * _id : {"$oid":"57fa4b81e7a76d057ac571c2"}
     * section_id : 57deaacbe7a76d7b18e3cb44
     * user_id : test2
     * question_id : 7
     * section_name : 重积分
     */

    private String summary;
    private String time;
    private String title;
    /**
     * $oid : 57fa4b81e7a76d057ac571c2
     */

    private IdBean _id;
    private String section_id;
    private String user_id;
    private String question_id;
    private String section_name;

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public IdBean get_id() {
        return _id;
    }

    public void set_id(IdBean _id) {
        this._id = _id;
    }

    public String getSection_id() {
        return section_id;
    }

    public void setSection_id(String section_id) {
        this.section_id = section_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(String question_id) {
        this.question_id = question_id;
    }

    public String getSection_name() {
        return section_name;
    }

    public void setSection_name(String section_name) {
        this.section_name = section_name;
    }

    @Override
    public boolean equals(Object o) {
        return _id.equals(((Question) o).get_id());
    }

}

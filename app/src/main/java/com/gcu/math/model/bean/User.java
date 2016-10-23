package com.gcu.math.model.bean;

public final class User {

    /**
     * school : 华南理工大学广州学院
     * sec_school : 12312
     * nick_name : test
     * major : 321
     * real_name : test
     * grade : 321
     * role : common
     * user_id : test
     * email : 321321
     */

    private String school;
    private String sec_school;
    private String nick_name;
    private String major;
    private String real_name;
    private String grade;
    private String role;
    private String user_id;
    private String email;

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getSec_school() {
        return sec_school;
    }

    public void setSec_school(String sec_school) {
        this.sec_school = sec_school;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getReal_name() {
        return real_name;
    }

    public void setReal_name(String real_name) {
        this.real_name = real_name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        return user_id.equals(((User) o).getUser_id());
    }
}

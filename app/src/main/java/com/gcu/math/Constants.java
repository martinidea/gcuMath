package com.gcu.math;

/**
 * Created by Martin on 2016/9/3.
 */
public final class Constants {

    public final static String SP_NAME_USER = "USER";

    public final class HttpPath {
        public final static String IP = "http://115.28.148.97";
        public final static String IPS = IP + "/";
        public final static String PORT = ":5000";
        public final static String TOOL = IP + PORT;
        public final static String LOGIN = TOOL + "/login.do";//登录接口
        public final static String SIGN = TOOL + "/register.do";//注册接口
        public final static String MY_INFO = TOOL + "/my_info";//个人信息接口
        public final static String QUESTION_LIST = TOOL + "/question_list";//问题接口
        public final static String HEAD_IMAGE_FIRST = TOOL + "/static/upload/";
        public final static String HEAD_IMAGE_SECOND = "/head_image/";
        public final static String REPLY_LIST = TOOL + "/reply_list";
        public final static String FILE_LIST_SUCCESS = TOOL + "/file_list?type=success";
        public final static String SECTION_LIST = TOOL + "/section_list";
        public final static String ASK = TOOL + "/ask.do";
        public final static String QUESTION = TOOL + "/question";
        public final static String ABOUT = TOOL + "/about.html";
    }

    public final class HttpKey {
        public final static String KEY_LOGIN_NAME = "user_id";
        public final static String KEY_LOGIN_PWD = "user_pwd";
        public final static String KEY_SIGN_NICK_NAME = "nick_name";
        public final static String KEY_SIGN_REAL_NAME = "real_name";
        public final static String KEY_SIGN_GRADE = "grade";
        public final static String KEY_SIGN_MAJOR = "major";
        public final static String KEY_SIGN_SCHOOL = "school";
        public final static String KEY_SIGN_SEC_SCHOOL = "sec_school";
        public final static String KEY_SIGN_EMAIL = "email";
        public final static String KEY_SIGN_YEAR = "year";
        public final static String KEY_QUESTION_TYPE = "type";
        public final static String KEY_QUESTION_USER_ID = "user_id";
        public final static String KEY_QUESTION_SECTION_ID = "section_id";
        public final static String KEY_QUESTION_QUESTION_ID = "question_id";
        public final static String KEY_ASK_TITLE = "title";
        public final static String KEY_ASK_TEXT = "text";
        public final static String KEY_ASK_SECTION_ID = "section_id";
    }

    public final class HttpValue {
        public static final String OWN = "own";
        public static final String NEW = "new";
        public static final String HOT = "hot";
        public static final String SECTION_QUESTION = "section_question";
    }

    public final class HttpBack {
        public final static String BACK_RESULT = "result";
        public final static String BACK_STATUS = "status";
        public final static String BACK_MSG = "msg";
        public final static String BACK_DATA = "data";
        public final static String BACK_USER = "user";
    }

    public final class SpKey {
        public final static String KEY_USERNAME = "USERNAME";
        public final static String KEY_PASSWORD = "PASSWORD";
    }
}

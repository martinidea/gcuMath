package com.gcu.math.model.bean;

/**
 * Created by Martin on 2016/10/18.
 */
public class File {

    /**
     * time : 2016-09-14 10:36:13
     * user_id : podger
     * _id : {"$oid":"57d8b79de7a76d7b18e3cab1"}
     * file_name : 接口文档.docx
     * status : success
     * file_type : docx
     */

    private String time;
    private String user_id;
    /**
     * $oid : 57d8b79de7a76d7b18e3cab1
     */

    private IdBean _id;
    private String file_name;
    private String status;
    private String file_type;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public IdBean get_id() {
        return _id;
    }

    public void set_id(IdBean _id) {
        this._id = _id;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFile_type() {
        return file_type;
    }

    public void setFile_type(String file_type) {
        this.file_type = file_type;
    }
}

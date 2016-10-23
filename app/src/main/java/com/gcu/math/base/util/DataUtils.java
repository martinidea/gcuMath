package com.gcu.math.base.util;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.gcu.math.Constants;
import com.gcu.math.model.bean.ItemQuestion;
import com.gcu.math.model.bean.Question;
import com.gcu.math.model.bean.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Martin on 2016/10/9.
 * 返回json统一处理，防止冗余
 */
public class DataUtils {

    /**
     * @param response http response json data
     * @return 返回ItemQuestion数组
     */
    public static List<ItemQuestion> response2ItemQuestion(JSONObject response) {
        ArrayList<ItemQuestion> list = new ArrayList<>();
        JSONObject result = getResult(response);
        try {
            JSONArray data = result.getJSONArray(Constants.HttpBack.BACK_DATA);
            JSONArray users = result.getJSONArray(Constants.HttpBack.BACK_USER);
            for (int i = 0; i < data.length(); i++) {
                Question question = JsonUtil.json2Bean(data.getJSONObject(i).toString(), Question.class);
                User user = JsonUtil.json2Bean(users.getJSONObject(i).toString(), User.class);
                ItemQuestion item = new ItemQuestion();
                item.setData(question);
                item.setUser(user);
                list.add(item);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * @param response http response json data
     * @param objClass 返回类
     * @param <T> 返回类型
     * @return
     */
    public static <T> T response2T(JSONObject response,Class<T> objClass){
        T t = null;
        JSONObject result = getResult(response);
        try {
            t = JsonUtil.json2Bean(result.toString(),objClass);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return t;
    }


    /**
     * @param response http response json data
     * @param objClass 返回类
     * @param <T> 返回类型
     * @return
     */
    public static <T> List<T> response2ListT(JSONObject response,Class<T> objClass){
        JSONArray result = getResultArray(response);
        ArrayList<T> list = new ArrayList<>();
        try {
            for (int i = 0; i < result.length(); i++) {
                list.add(JsonUtil.json2Bean(result.getJSONObject(i).toString(), objClass));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }


    private static JSONObject getResult(JSONObject response) {
        JSONObject result = null;
        try {
            result = response.getJSONObject(Constants.HttpBack.BACK_RESULT);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static JSONArray getResultArray(JSONObject response) {
        JSONArray result = null;
        try {
            result = response.getJSONArray(Constants.HttpBack.BACK_RESULT);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static int getStatus(JSONObject response) {
        int status = -1000;
        try {
            status = response.getInt(Constants.HttpBack.BACK_STATUS);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return status;
    }

    public static String getMSG(JSONObject response){
        String msg = null;
        try {
            msg = response.getString(Constants.HttpBack.BACK_MSG);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return msg;
    }
}

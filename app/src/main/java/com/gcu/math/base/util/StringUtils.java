package com.gcu.math.base.util;

/**
 * Created by Martin on 2016/9/8.
 */
public class StringUtils {

    public static String endPoint(String s) {
        if (s == null) {
            return "";
        }
        int pointIndex = s.lastIndexOf(".");
        if (pointIndex != -1) {
            return s.substring(pointIndex);
        }
        return "";
    }
}

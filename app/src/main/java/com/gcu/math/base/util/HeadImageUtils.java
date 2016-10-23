package com.gcu.math.base.util;

import com.gcu.math.Constants;

/**
 * Created by Martin on 2016/10/17.
 */
public class HeadImageUtils {
    public static String getImageHead(String userId) {
        return Constants.HttpPath.HEAD_IMAGE_FIRST + userId
                + Constants.HttpPath.HEAD_IMAGE_SECOND + userId + ".png";
    }
}

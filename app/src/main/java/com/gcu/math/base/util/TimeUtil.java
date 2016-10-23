package com.gcu.math.base.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Martin on 2016/10/9.
 */


public class TimeUtil {

    public static String toDate(String time) {
        SimpleDateFormat day = new SimpleDateFormat("yyyy-MM-dd");
        String date = "";
        Date curDate = new Date(System.currentTimeMillis());// 获取当前时间
        String nowDay = day.format(curDate);
        try {
            Date date1 = day.parse(time);
            Date date2 = day.parse(nowDay);
            int fates = (int) ((date2.getTime() - date1.getTime()) / (24 * 60 * 60 * 1000));

            switch (fates) {
                case 0:
                    date += "今  天 ";
                    break;
                case 1:
                    date += "昨  天 ";
                    break;
                case 2:
                    date += "前  天 ";
                    break;
                default:
                    date += time.substring(5, 10) + " ";
                    break;
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        date += time.substring(11, 16);
        return date;
    }

}


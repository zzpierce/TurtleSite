package com.zz.back.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 * @author zhanzong
 */
public class DateUtil {

    private static DateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static DateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static String formatTime(Date date) {
        return timeFormat.format(date);
    }

    public static String formatDay(Date date) {
        return dayFormat.format(date);
    }

}

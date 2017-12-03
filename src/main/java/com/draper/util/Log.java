package com.draper.util;

/**
 * Created by Draper_HXY on 2017/11/6.
 * Email: Draper_HXY@163.com
 */
public class Log {

    public static void d(String TAG, Object... message) {
        StringBuffer sb = new StringBuffer();
        sb.append(TAG);
        for (Object s : message) {
            sb.append(":" + s);
        }
        System.out.println(sb.toString());
    }

    public static void e(String TAG, Object... message) {
        StringBuffer sb = new StringBuffer();
        sb.append(TAG);
        for (Object s : message) {
            sb.append(":" + s);
        }
        System.err.println(sb.toString());
    }

}

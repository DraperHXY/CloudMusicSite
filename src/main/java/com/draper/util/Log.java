package com.draper.util;

/**
 * Created by Draper_HXY 04/03/2018 7:13 PM
 * Email: Draper_HXY@163.com
 */
public class Log {

    public static void d(String msg){
        System.out.println(msg);
    }

    public static void d(String TAG, StringBuffer msg){
        System.out.println("TAG = " + TAG + ", msg = " + msg);
    }

    public static void d(String TAG, String msg){
        System.out.println("TAG = " + TAG + ", msg = " + msg);
    }

    public static void d(String TAG, int msg){
        System.out.println("TAG = " + TAG + ", msg = " + msg);
    }

    public static void e(String msg){
        System.err.println(msg);
    }

}

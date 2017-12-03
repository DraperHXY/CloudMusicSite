package com.draper;

import com.draper.util.DbUtil;

import java.sql.Connection;

/**
 * Created by Draper_HXY 2017/11/27 下午7:35
 * Email: Draper_HXY@163.com
 */
public class Test {

    public static void main(String[] args) {
        Connection connection = DbUtil.getConnection();
        System.out.println(connection);
    }


}

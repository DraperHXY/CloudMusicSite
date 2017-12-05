package com.draper.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * Created by Draper_HXY 2017/11/27 下午7:23
 * Email: Draper_HXY@163.com
 */
public class DbUtil {
    private static Connection connection = null;

    private DbUtil() {
    }

    public static Connection getConnection() {
        if (connection != null) {
            return connection;
        }
        try {
            Properties properties = new Properties();
            InputStream inputStream = DbUtil.class.getClassLoader().getResourceAsStream("db.properties");
            properties.load(inputStream);
            String driver = properties.getProperty("driver");
            String url = properties.getProperty("url");
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static String getCurrentTime(){
        Date date = new Date();
        SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//24小时制
        String LgTime = sdformat.format(date);
        return LgTime;
    }

}

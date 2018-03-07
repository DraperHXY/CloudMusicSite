package com.draper.dao.impl;

import com.draper.dao.WebInitDao;
import com.draper.domain.User;
import com.draper.util.DbUtil;

import java.sql.*;

/**
 * Created by Draper_HXY 07/03/2018 7:33 PM
 * Email: Draper_HXY@163.com
 */
public class WebInitDaoImpl implements WebInitDao {
    private Connection connection = null;

    public WebInitDaoImpl() {
        connection = DbUtil.getConnection();
    }


    public int getPageViewValue() {
        String value = "0";
        connection = DbUtil.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT value FROM web_setting WHERE name = 'page_view'");
            if (rs.next()) {
                value = rs.getString(1);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Integer.valueOf(value);
    }

    public int getSubscriberValue() {
        String value = "0";
        connection = DbUtil.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT value FROM web_setting WHERE name = 'subscriber'");
            if (rs.next()) {
                value = rs.getString(1);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Integer.valueOf(value);
    }

    public void modifyPageViewValue(int value) {
        try {
            PreparedStatement ptmt = connection.prepareStatement("UPDATE web_setting SET value = '" + String.valueOf(value) + "' WHERE name = 'page_view'");
            ptmt.executeUpdate();
            ptmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modifySubscriberValue(int value) {
        try {
            PreparedStatement ptmt = connection.prepareStatement("UPDATE web_setting SET value = '" + String.valueOf(value) + "' WHERE name = 'subscriber'");
            ptmt.executeUpdate();
            ptmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

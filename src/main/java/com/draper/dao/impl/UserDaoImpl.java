package com.draper.dao.impl;

import com.draper.dao.UserDao;
import com.draper.domain.User;
import com.draper.util.DbUtil;

import java.sql.*;


/**
 * Created by Draper_HXY 2017/11/27 下午8:10
 * Email: Draper_HXY@163.com
 */
public class UserDaoImpl implements UserDao {
    private static final String TAG = "UserDaoImpl";
    private Connection connection = null;

    public UserDaoImpl() {
        connection = DbUtil.getConnection();
    }

    public void add(Object obj) {
        User user = (User) obj;
        String name = user.getName();
        String account = user.getAccount();
        String password = user.getPassword();
        int credit = user.getCredit();
        try {
            PreparedStatement ptmt = connection.prepareStatement("INSERT INTO user (name, account, password,credit) VALUES (?,?,?,?)");
            ptmt.setString(1, name);
            ptmt.setString(2, account);
            ptmt.setString(3, password);
            ptmt.setInt(4, credit);
            ptmt.executeUpdate();
            ptmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Object find(Object key) {
        User user = null;
        String strKey = (String) key;
        connection = DbUtil.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM user WHERE account = '" + strKey + "'");
            if (rs.next()) {
                String name = rs.getString(1);
                String account = rs.getString(2);
                String password = rs.getString(3);
                user = new User(account);
                int credit = rs.getInt(4);
                user.setName(name);
                user.setPassword(password);
                user.setCredit(credit);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public boolean increaseCredit(int credit, User user) {
        int lastCredit = user.getCredit() + credit;
        String sql = "UPDATE user SET credit='" + lastCredit + "' WHERE account='" + user.getAccount() + "'";
        executedUpdate(sql);
        return true;
    }

    public boolean decreaseCredit(int credit, User user) {
        int lastCredit = user.getCredit() - credit;
        String sql = "UPDATE user SET credit='" + lastCredit + "' WHERE account='" + user.getAccount() + "'";
        executedUpdate(sql);
        return true;
    }

    /**
     * 检查用户账号密码是否匹配
     *
     * @param user
     * @return
     */
    public boolean checkUser(User user) {
        String realAccount = user.getAccount();
        String realPassword = user.getPassword();
        User usr = (User) find(realAccount);
        String expectPassword = usr.getPassword();
        if (realPassword.equals(expectPassword)) {
            return true;
        }
        return false;
    }

    public boolean refreshLastLoginTime(User user) {
        String sql = "UPDATE user SET last_login_time='" + DbUtil.getCurrentTime() + "' WHERE account='" + user.getAccount() + "'";
        executedUpdate(sql);
        return true;
    }

    private void executedUpdate(String sql) {
        PreparedStatement ptmt = null;
        try {
            ptmt = connection.prepareStatement(sql);
            ptmt.executeUpdate();
            ptmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

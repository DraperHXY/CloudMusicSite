package com.draper.controller;

import com.draper.dao.Dao;
import com.draper.dao.UserDao;
import com.draper.dao.impl.UserDaoImpl;
import com.draper.domain.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Draper_HXY 2017/12/6 下午9:56
 * Email: Draper_HXY@163.com
 */
public class UserServiceManager {

    public static boolean isSignIn(HttpServletRequest req){
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null){
            return false;
        }
        return true;
    }

    public static boolean signUp(User user) {
        Dao userDao = new UserDaoImpl();
        if (userDao.find(user.getAccount()) != null) {
            return false;
        } else {
            userDao.add(user);
            return true;
        }
    }

    public static User signIn(User user) {
        UserDao userDao = new UserDaoImpl();
        if (userDao.checkUser(user)) {
            Date date = userDao.getLastLoginTime(user);
            if (date == null) {
                userDao.increaseCredit(5, user);
                userDao.refreshLastLoginTime(user);
            } else if (isFirstSignInEveryday(user)) {
                userDao.increaseCredit(5, user);
            }
            userDao.refreshLastLoginTime(user);
            user = (User) userDao.find(user.getAccount());
            return user;
        } else {
            return null;
        }
    }

    private static boolean isFirstSignInEveryday(User user) {
        UserDao userDao = new UserDaoImpl();
        Date date = userDao.getLastLoginTime(user);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String now = df.format(new Date());
        boolean result = date.toString().equals(now);
        return !result;
    }
}

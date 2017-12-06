package com.draper.controller;

import com.draper.dao.Dao;
import com.draper.dao.UserDao;
import com.draper.dao.impl.UserDaoImpl;
import com.draper.domain.User;

/**
 * Created by Draper_HXY 2017/12/6 下午9:56
 * Email: Draper_HXY@163.com
 */
public class UserServiceManager {

    public static boolean signUp(User user) {
        Dao userDao = new UserDaoImpl();
        if (userDao.find(user.getAccount()) != null){
            return false;
        } else {
            userDao.add(user);
            return true;
        }
    }

}

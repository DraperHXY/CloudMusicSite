package com.draper.controller;

import com.draper.domain.User;

import javax.servlet.http.HttpSession;

/**
 * Created by Draper_HXY 2017/12/7 下午3:35
 * Email: Draper_HXY@163.com
 */
public class UserTrackManager {

    public static boolean signIn(HttpSession session, User user) {
        session.setAttribute("name", user.getName());
        session.setAttribute("emailAddress", user.getAccount());
        session.setAttribute("password", user.getPassword());
        session.setAttribute("credit", user.getCredit());
        session.setAttribute("lastLoginTime", user.getLastLoginTime());
        session.setAttribute("user", user);


        return false;
    }

}

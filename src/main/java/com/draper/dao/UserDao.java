package com.draper.dao;

import com.draper.domain.User;

/**
 * Created by Draper_HXY 2017/11/27 下午8:12
 * Email: Draper_HXY@163.com
 */
public interface UserDao extends Dao {

    boolean increaseCredit(int credit, User user);

    boolean decreaseCredit(int credit, User user);

    boolean checkUser(User user);

}

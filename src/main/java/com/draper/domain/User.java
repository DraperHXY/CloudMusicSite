package com.draper.domain;

import java.util.Date;

/**
 * Created by Draper_HXY 2017/11/27 下午8:08
 * Email: Draper_HXY@163.com
 */
public class User {
    private String name;
    private String account;
    private String password;
    private int credit;
    private Date lastLoginTime;

    public User(String account){
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
}

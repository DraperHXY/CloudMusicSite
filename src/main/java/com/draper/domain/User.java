package com.draper.domain;

/**
 * Created by Draper_HXY 2017/11/27 下午8:08
 * Email: Draper_HXY@163.com
 */
public class User {
    private String name;
    private String account;
    private String password;
    private int credit;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
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
}
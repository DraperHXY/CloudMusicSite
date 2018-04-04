package com.draper.domain;

import java.util.Date;

/**
 * Created by Draper_HXY 30/03/2018 8:11 PM
 * Email: Draper_HXY@163.com
 */
public class Comments {
    private int titleId;
    private String name;
    private String account;
    private String time;
    private String value;

    public int getTitleId() {
        return titleId;
    }

    public void setTitleId(int titleId) {
        this.titleId = titleId;
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

    public void setAccount(String account) {
        this.account = account;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        String msg = titleId + "\n" + name + "\n" + account + "\n" + time + "\n" + value + "\n";
        return msg;
    }
}

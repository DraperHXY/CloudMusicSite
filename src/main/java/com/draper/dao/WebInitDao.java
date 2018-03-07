package com.draper.dao;

/**
 * Created by Draper_HXY 07/03/2018 7:27 PM
 * Email: Draper_HXY@163.com
 */
public interface WebInitDao {

    /**
     * 获取 DB 中 page_view 的值
     *
     * @return
     */
    int getPageViewValue();


    /**
     * 获取 DB 中 subscriber 的值
     *
     * @return
     */
    int getSubscriberValue();

    /**
     * 将 value 设为数据库中 page_view 的值
     *
     * @param value
     */
    void modifyPageViewValue(int value);

    /**
     * 将 value 设为 DB 中 subscriber 的值
     *
     * @param value
     */
    void modifySubscriberValue(int value);

}

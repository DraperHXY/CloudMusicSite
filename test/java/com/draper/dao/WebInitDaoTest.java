package com.draper.dao;

import com.draper.dao.impl.WebInitDaoImpl;
import com.draper.util.LogUtil;
import org.junit.Test;

/**
 * Created by Draper_HXY 07/03/2018 7:51 PM
 * Email: Draper_HXY@163.com
 */
public class WebInitDaoTest {

    @Test
    public void testGetPageViewValue(){
        WebInitDao webInitDao = new WebInitDaoImpl();
        LogUtil.logger.debug(webInitDao.getPageViewValue());
    }

    @Test
    public void testGetSubscriberValue(){
        WebInitDao webInitDao = new WebInitDaoImpl();
        LogUtil.logger.debug(webInitDao.getSubscriberValue());
    }

    @Test
    public void testModifyPageViewValue(){
        WebInitDao webInitDao = new WebInitDaoImpl();
        webInitDao.modifyPageViewValue(111);
    }

    @Test
    public void testModifySubscriberValue(){
        WebInitDao webInitDao = new WebInitDaoImpl();
        webInitDao.modifySubscriberValue(35);
    }

}

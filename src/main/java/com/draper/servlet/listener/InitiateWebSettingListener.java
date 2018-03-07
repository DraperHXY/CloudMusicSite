package com.draper.servlet.listener;

import com.draper.dao.impl.WebInitDaoImpl;
import com.draper.servlet.IndexPageServlet;
import org.apache.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by Draper_HXY 07/03/2018 7:12 PM
 * Email: Draper_HXY@163.com
 */
public class InitiateWebSettingListener implements ServletContextListener {
    private Logger logger = IndexPageServlet.logger;


    public void contextInitialized(ServletContextEvent sce) {
        logger.error("Web initialized");
        ServletContext context = sce.getServletContext();
        Integer page_view = new WebInitDaoImpl().getPageViewValue();
        Integer subscriber = new WebInitDaoImpl().getSubscriberValue();
        logger.debug(page_view);
        logger.debug(subscriber);
        context.setAttribute("page_view", page_view);
        context.setAttribute("subscriber", subscriber);
    }

    public void contextDestroyed(ServletContextEvent sce) {
        logger.error("Web destroyed");
        ServletContext context = sce.getServletContext();
        Integer page_view = (Integer) context.getAttribute("page_view");
        Integer subscriber = (Integer) context.getAttribute("subscriber");
        logger.debug(page_view);
        logger.debug(subscriber);
        new WebInitDaoImpl().modifyPageViewValue(page_view);
        new WebInitDaoImpl().modifySubscriberValue(subscriber);
    }
}

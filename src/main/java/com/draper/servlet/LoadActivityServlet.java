package com.draper.servlet;

import com.draper.controller.ActivityCommentsServiceManager;
import com.draper.controller.MusicServiceManager;
import com.draper.domain.Comments;
import com.draper.domain.Music;
import com.draper.util.LogUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Draper_HXY 01/04/2018 3:16 PM
 * Email: Draper_HXY@163.com
 */
public class LoadActivityServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Comments> commentsList = ActivityCommentsServiceManager.getComments(1);
        LogUtil.logger.debug(commentsList.size());
        req.setAttribute("commentsList", commentsList);
        RequestDispatcher view = req.getRequestDispatcher("/WEB-INF/jsp/activity.jsp");
        view.forward(req,resp);

    }
}

package com.draper.servlet;

import com.draper.controller.ActivityCommentsServiceManager;
import com.draper.controller.UserServiceManager;
import com.draper.domain.Comments;
import com.draper.domain.User;
import com.draper.util.LogUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created by Draper_HXY 30/03/2018 12:54 PM
 * Email: Draper_HXY@163.com
 */
public class CommitCommentsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!UserServiceManager.isSignIn(req)) {
            resp.sendRedirect("signIn.html");
            return;
        }

        req.setCharacterEncoding("UTF-8");
        String msg = req.getParameter("inputComments");
        User user = (User) req.getSession().getAttribute("user");
        String name = user.getName();
        String account = user.getAccount();

        Comments comments = new Comments();
        comments.setName(name);
        comments.setAccount(account);
        comments.setTitleId(1);
        comments.setValue(msg);
        ActivityCommentsServiceManager.addComments(comments);
        resp.sendRedirect("activity.html");

    }
}

package com.draper.servlet;

import com.draper.controller.UserServiceManager;
import com.draper.controller.UserTrackManager;
import com.draper.domain.User;
import com.draper.util.LogUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Draper_HXY 2017/12/7 下午2:08
 * Email: Draper_HXY@163.com
 */
public class SignInServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String emailAdress = req.getParameter("inputEmailAddress");
        String password = req.getParameter("inputPassword");
        User user = new User(emailAdress);
        user.setPassword(password);
        user = UserServiceManager.signIn(user);

        if (user != null) {
            HttpSession session = req.getSession();
            UserTrackManager.signIn(session, user);
            resp.sendRedirect("index.html");
        } else {
            resp.sendRedirect("404.html");
        }
    }
}

package com.draper.servlet;

import com.draper.controller.UserServiceManager;
import com.draper.domain.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Draper_HXY 2017/12/6 下午9:50
 * Email: Draper_HXY@163.com
 */
public class SignUpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("inputName");
        String emailAddress = req.getParameter("inputEmailAddress");
        String password = req.getParameter("inputPassword");
        User user = new User(emailAddress);
        user.setName(name);
        user.setPassword(password);

        if (UserServiceManager.signUp(user)) {
            RequestDispatcher view = req.getRequestDispatcher("SignIn.do");
            view.forward(req, resp);
        } else {
            System.out.println("注册失败");
        }
    }
}

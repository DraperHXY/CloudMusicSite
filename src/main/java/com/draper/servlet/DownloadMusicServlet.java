package com.draper.servlet;

import com.draper.controller.MusicServerManager;
import com.draper.domain.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Draper_HXY 2017/12/5 下午7:37
 * Email: Draper_HXY@163.com
 */
public class DownloadMusicServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("geiRequestUrl:" + req.getRequestURL());
        String musicName = req.getParameter("musicName");
        System.out.println("要下载的音乐是:" + musicName);
        System.out.println("下载页面处理");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            System.out.println("跳转至登录页面");
            resp.sendRedirect("signIn.html");
        } else {
            int credit = (int) session.getAttribute("credit");
            if (credit > 5) {
                System.out.println("准备下载");
                MusicServerManager.getMusicPath(musicName);
                String path = "load_music/" + musicName + ".mp3";
                System.out.println("path: " + path);


                //download
                resp.setContentType("application/audio");
                resp.setHeader("Content-Disposition", "attachment; filename="+musicName+".mp3");

                //获取上下文
                ServletContext context = getServletContext();
                //获取资源
                InputStream inputStream = context.getResourceAsStream(path);
                int read;
                byte[] bytes = new byte[1024];
                OutputStream outputStream = resp.getOutputStream();
                while ((read = inputStream.read(bytes)) != -1) {
                    outputStream.write(bytes, 0, read);
                }
                outputStream.flush();
                outputStream.close();
                System.out.println("下载完成");
            } else {
                //积分不够
                System.out.println("积分不够");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

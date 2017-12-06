package com.draper.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        resp.setContentType("application/audio");
        //获取上下文
        ServletContext context = getServletContext();
        //获取资源
        System.out.println("good job!");
        InputStream inputStream = context.getResourceAsStream("/music/Dreaming Alone.mp3");
        int read;
        byte[] bytes = new byte[1024];
        OutputStream outputStream = resp.getOutputStream();
        while ((read = inputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, read);
        }
        outputStream.flush();
        outputStream.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

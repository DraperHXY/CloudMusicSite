package com.draper.servlet;

import com.draper.controller.MusicServerManager;
import com.draper.domain.User;
import com.draper.util.Log;

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
        String musicName = req.getParameter("musicName");
        Log.d("geiRequestUrl",req.getRequestURL());
        Log.d("doGet_download_music_name", musicName);
        Log.d("pre_downloading");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            resp.sendRedirect("signIn.html");
        } else {
            Integer credit = (Integer)session.getAttribute("credit");
            if (credit > 5) {
                Log.d("downloading");
                MusicServerManager.getMusicPath(musicName);
                String path = "load_music/" + musicName + ".mp3";
                Log.d("downloading_path",path);

                //download
                resp.setContentType("application/audio");
                resp.setHeader("Content-Disposition", "attachment; filename=" + musicName + ".mp3");

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
                Log.d("download_finish");
            } else {
                //积分不够
                Log.d("download_error","User don't have enough credit");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

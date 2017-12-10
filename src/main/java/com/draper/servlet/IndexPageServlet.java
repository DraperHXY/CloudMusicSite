package com.draper.servlet;

import com.draper.controller.MusicServerManager;
import com.draper.domain.Music;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Draper_HXY 2017/12/9 下午10:59
 * Email: Draper_HXY@163.com
 */
public class IndexPageServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //bug 一级: 每次访问 index 都会进行下载, 严重影响性能
        List<String> musicNameList = MusicServerManager.preDownloadImage();
        List<Music> musicInfoList = MusicServerManager.preDownloadInfo();
        req.setAttribute("musicNameList", musicNameList);
        req.setAttribute("musicInfoList", musicInfoList);
        RequestDispatcher view = req.getRequestDispatcher("/WEB-INF/jsp/index.jsp");
        view.forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}

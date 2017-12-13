<%@ page import="com.draper.controller.MusicServerManager" %>
<%@ page import="java.io.InputStream" %>
<%@ page import="java.io.OutputStream" %><%--
  Created by IntelliJ IDEA.
  User: draper
  Date: 2017/12/7
  Time: 下午2:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign In CloudMusicSite</title>
    <link rel="shortcut icon" href="/CloudMusicSite/img/icon/logo.ico">
</head>
<body>
<%@include file="header.jsp" %>

<%
    String path = "load_music/In Time.mp3";
    System.out.println("path: " + path);

    //download
    response.setContentType("application/audio");
    //获取上下文
    ServletContext context = request.getServletContext();
    //获取资源
    InputStream inputStream = context.getResourceAsStream(path);
    int read;
    byte[] bytes = new byte[1024];
    OutputStream outputStream = response.getOutputStream();
    while ((read = inputStream.read(bytes)) != -1) {
        outputStream.write(bytes, 0, read);
    }
    outputStream.flush();
    outputStream.close();
    System.out.println("下载完成");
%>


<%@include file="footer.jsp" %>
</body>
</html>

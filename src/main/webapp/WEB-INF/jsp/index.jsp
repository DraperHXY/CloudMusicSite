<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ page import="com.draper.controller.MusicServerManager" %>
<%@ page import="com.draper.dao.impl.MusicDaoImpl" %>
<%@ page import="com.draper.dao.MusicDao" %>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome to CloudMusicSite</title>
    <link rel="shortcut icon" href="/CloudMusicSite/img/icon/logo.ico">
</head>
<body>

<%@ include file="header.jsp" %>

<div class="container">
    <div class="jumbotron text-center">
        <p class="h1">Download</p>
        <div class="row">
            <div class="col-md-6 col-md-offset-3 text-center">
                <p>You can download a music <a href="DreamingAlone.mp3">Dreaming Alone</a></p>
            </div>
        </div>
    </div>
</div>

<%
    int n = MusicServerManager.getMusicNum();
    for (int i = 0; i < n; i++) {

        if (i % 2 == 0) {
%>
            <%@include file="musicItem2.jsp" %>
<%
        } else {
%>
            <%@include file="musicItem1.jsp" %>
<%
        }
    }
%>



<%@include file="footer.jsp" %>

</body>
</html>
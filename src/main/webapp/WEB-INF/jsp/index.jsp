<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ page import="com.draper.controller.MusicServerManager" %>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome to CloudMusicSite</title>
    <link rel="shortcut icon" href="/CloudMusicSite/img/icon/logo.ico">
</head>
<body>

<%@ include file="header.jsp" %>

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
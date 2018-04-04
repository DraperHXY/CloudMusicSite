<%@ page import="com.draper.controller.ActivityCommentsServiceManager" %>
<%@ page import="com.draper.util.LogUtil" %><%--
  Created by IntelliJ IDEA.
  User: draper
  Date: 28/03/2018
  Time: 8:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ActivityDetail</title>
    <link rel="shortcut icon" href="/CloudMusicSite/img/icon/logo.ico">
</head>
<body>

<%@ include file="header.jsp" %>

<div class="container">
    <div class="jumbotron">

        <div class="thumbnail center-block">
            <img src="img/img-activity1.png"/>
        </div>
    </div>

</div>

<div class="container <%
    int commentsNum = ActivityCommentsServiceManager.getCommentsNum(1);
    if (commentsNum == 0){
        LogUtil.logger.debug(commentsNum);
        out.print("hidden");
    }
%>">
    <div class="jumbotron">
        <%
            for (int i = 0; i < commentsNum; i++) {
        %>
        <%@ include file="components/commentsItem1.jsp" %>
        <%

            }
        %>
    </div>
</div>

<%@ include file="components/inputCommentItem1.jsp" %>

<%@ include file="footer.jsp" %>
</body>
</html>

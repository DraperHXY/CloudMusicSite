<%--
  Created by IntelliJ IDEA.
  User: draper
  Date: 2017/12/7
  Time: 下午12:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<body>

<div class="jumbotron text-center" style="margin: 0px">
    <p>©2017 CloudMusicSite</p>
    <span class="glyphicon glyphicon-eye-open"/>
    <%
        Integer pageView = (Integer) application.getAttribute("page_view");
        out.print(pageView);
        application.setAttribute("page_view", pageView + 1);
    %>
    |
    <span class="glyphicon glyphicon-user"/>
    <%
        Integer subscriber = (Integer) application.getAttribute("subscriber");
        out.print(subscriber);
        if (session.isNew()){
            application.setAttribute("subscriber", subscriber + 1);
        }
    %>
</div>

<script src="/CloudMusicSite/js/jquery-1-12-4.min.js"></script>
<script src="/CloudMusicSite/js/bootstrap.min.js"></script>

</body>
</html>

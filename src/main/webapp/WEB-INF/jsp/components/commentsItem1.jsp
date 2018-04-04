<%@ page import="com.draper.domain.Comments" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: draper
  Date: 30/03/2018
  Time: 9:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <style>
        .my-item {
            padding-top: 20px;
            padding-bottom: 20px;
        }

        .my-item-body {
            padding-top: 20px;
        }
    </style>
</head>

<body>
<div class="row my-item">
    <div class="col-sm-12 col-md-12">
        <div class="item-header">
            <small><%
                List<Comments> commentsList = (List<Comments>) request.getAttribute("commentsList");
                Comments comments = commentsList.get(0);
                out.print(comments.getName());
            %></small>
            <span style="float: right"><%
                out.print(comments.getTime());
            %></span>

        </div>
        <div class="my-item-body">
            <%
                out.print(comments.getValue());
            %>
        </div>
        <div class="my-item-footer">
            <%
                commentsList.remove(0);
            %>
        </div>
        <div class="table-bordered"></div>
    </div>
</div>


</body>
</html>

<%--
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
<%@include file="header.jsp"%>

<div class="container">
    <div class="jumbotron">
        <p class="h1 text-center">Sign in CloudMusicSite</p>

        <div class="row">
            <div class="col-md-12">
                <form class="form" action="SignIn.do" method="post">
                    <div class="form-group">
                        <label class="sr-only" for="inputEmailAddress">Email address</label>
                        <input type="email" class="form-control" id="inputEmailAddress" name="inputEmailAddress"
                               placeholder="Email address">
                    </div>
                    <div class="clearfix"></div>
                    <p></p>
                    <div class="form-group">
                        <label class="sr-only" for="inputPassword">Password</label>
                        <input type="password" class="form-control" id="inputPassword" name="inputPassword"
                               placeholder="Password">
                    </div>
                    <div class="clearfix"></div>
                    <p></p>

                    <div class="form-group">
                        <button type="submit" class="btn btn-lg btn-success center-block">Sign in</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

</div>


<%@include file="footer.jsp"%>
</body>
</html>

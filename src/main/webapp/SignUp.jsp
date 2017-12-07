<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sign up CloudMusicSite</title>
</head>
<body>

<%@ include file="header.jsp"%>

<div class="container">
    <div class="jumbotron">
        <p class="h1 text-center">Join CloudMusicSite</p>

        <div class="row">
            <div class="col-md-12">
                <form class="form" action="SignUp.do" method="post">
                    <div class="form-group">
                        <label class="sr-only" for="inputName">Name</label>
                        <input type="text" class="form-control" id="inputName" name="inputName" placeholder="Name">
                    </div>
                    <div class="clearfix"></div>
                    <p></p>
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
                    <small class="text-danger">请不要输入真实的密码,会被后台看见的哦 ( ´･∀･｀)</small>
                    <br>
                    <small class="text-danger">Please do not enter the actual password, which will be seen by the
                        background programmer ( ´･∀･｀)
                    </small>
                    <div class="clearfix"></div>
                    <p></p>

                    <div class="form-group">
                        <button type="submit" class="btn btn-lg btn-success center-block">Create an account</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

</div>

<%@include file="footer.jsp"%>

</body>
</html>
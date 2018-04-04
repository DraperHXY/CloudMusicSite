<%--
  Created by IntelliJ IDEA.
  User: draper
  Date: 28/03/2018
  Time: 6:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>

<div class="container">
    <div class="jumbotron">
        <form class="form" action="CommitComment.do" method="post">
            <div class="form-group">
                <div class="text-area">
                    <textarea class="form-control" maxlength="400" rows="3" name="inputComments"></textarea>
                </div>
            </div>
            <button type="submit" class="btn btn-default center-block">Submit</button>
        </form>
    </div>
</div>

</body>
</html>

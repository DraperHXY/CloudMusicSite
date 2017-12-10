<%@ page import="com.draper.domain.Music" %><%--
  Created by IntelliJ IDEA.
  User: draper
  Date: 2017/12/9
  Time: 下午7:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Music Item</title>
</head>
<body>
<div class="container">

    <div class="jumbotron">
        <div class="row">
            <div class="col-xs-6 col-md-3 col-xs-push-6 col-md-push-9">
                <div class="thumbnail" style="padding: 0px; margin: 0px;">
                    <img src="../img/<%
                        List<String> musicNameList = (List<String>) request.getAttribute("musicNameList");
                        if(musicNameList!= null || !musicNameList.isEmpty()){
                            String address = musicNameList.get(0);
                            out.print(address);
                            musicNameList.remove(0);
                        }

                    %>.jpg" alt="...">
                </div>
            </div>

            <div class="col-xs-6 col-md-9 col-xs-pull-6 col-md-pull-3">
                <p class="h1"><%
                    List<Music> musicInfoList = (List<Music>) request.getAttribute("musicInfoList");
                    if (musicInfoList != null && !musicInfoList.isEmpty()) {
                        Music music = musicInfoList.get(0);
                        out.print(music.getSongName());

                %></p>
                <p class="h4"><%
                        music = musicInfoList.get(0);
                        out.print(music.getSinger());
                %></p>
                <a href="<%
                        music = musicInfoList.get(0);
                        out.print(music.getSongName());
                        musicInfoList.remove(0);
                    }
                %>">Download</a>
            </div>
        </div>
    </div>

</div>
</body>
</html>

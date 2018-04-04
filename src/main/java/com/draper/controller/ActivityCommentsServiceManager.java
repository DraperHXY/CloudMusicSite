package com.draper.controller;

import com.draper.dao.impl.CommentsDaoImpl;
import com.draper.domain.Comments;

import java.util.List;

/**
 * Created by Draper_HXY 01/04/2018 2:24 PM
 * Email: Draper_HXY@163.com
 */
public class ActivityCommentsServiceManager {

    public static List<Comments> getComments(int titleId){
        List<Comments> commentsList = new CommentsDaoImpl().getCommentsList(titleId);

        return commentsList;
    }

    public static int getCommentsNum(int titleId){
        return new CommentsDaoImpl().getCommentsNum(titleId);
    }

    public static void addComments(Comments comments){
        new CommentsDaoImpl().addComments(comments);
    }

}

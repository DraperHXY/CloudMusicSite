package com.draper.dao;

import com.draper.domain.Comments;

import java.util.List;

/**
 * Created by Draper_HXY 30/03/2018 8:10 PM
 * Email: Draper_HXY@163.com
 */
public interface CommentsDao {

    void addComments(Comments comments);

    List<Comments> getCommentsList(int titleId);

    int getCommentsNum(int title_id);

}

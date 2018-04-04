package com.draper.dao;

import com.draper.dao.impl.CommentsDaoImpl;
import com.draper.domain.Comments;
import com.draper.util.LogUtil;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Draper_HXY 30/03/2018 8:37 PM
 * Email: Draper_HXY@163.com
 */
public class CommentsDaoImplTest {

    @Test
    public void testAdd() {
        Comments comments = new Comments();
        comments.setTitleId(1);
        comments.setAccount("aaa@bbb.ccc");
        comments.setName("琉璃刘");
        comments.setValue("爱死这个网站了");

        CommentsDao commentsDao = new CommentsDaoImpl();
        commentsDao.addComments(comments);

    }

    @Test
    public void testGetCommentsList() {
        CommentsDao commentsDao = new CommentsDaoImpl();
        for (Comments comments : commentsDao.getCommentsList(1)) {
            LogUtil.logger.debug(comments);
        }
    }

    @Test
    public void testGetCommentsNum() {
        CommentsDao commentsDao = new CommentsDaoImpl();
        Assert.assertEquals(2, commentsDao.getCommentsNum(1));
    }

}

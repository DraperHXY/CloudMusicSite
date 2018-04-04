package com.draper.dao.impl;

import com.draper.dao.CommentsDao;
import com.draper.domain.Comments;
import com.draper.util.DbUtil;
import com.draper.util.Mp3Util;
import org.apache.commons.io.IOUtils;

import javax.sql.rowset.serial.SerialBlob;
import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Draper_HXY 30/03/2018 8:11 PM
 * Email: Draper_HXY@163.com
 */
public class CommentsDaoImpl implements CommentsDao {


    public void addComments(Comments comments) {
        int titleId = comments.getTitleId();
        String name = comments.getName();
        String account = comments.getAccount();
        String date = DbUtil.getCurrentTime();
        String value = comments.getValue();


        try {
            Connection con = DbUtil.getConnection();
            String sql = "INSERT INTO comments VALUES (NULL ,?,?,?,?,?)";
            PreparedStatement pps = null;
            pps = con.prepareStatement(sql);
            pps.setInt(1, titleId);
            pps.setString(2, name);
            pps.setString(3, account);
            pps.setString(4, date);
            pps.setString(5, value);

            pps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Comments> getCommentsList(int titleId) {
        try {
            Connection con = DbUtil.getConnection();
            String sql = "SELECT * FROM comments WHERE title_id = " + titleId;
            PreparedStatement pps = null;
            pps = con.prepareStatement(sql);
            ResultSet resultSet = pps.executeQuery();
            List<Comments> commentsArrayList = new ArrayList<Comments>();
            while (resultSet.next()) {
                Comments comments = new Comments();
                comments.setTitleId(resultSet.getInt(2));
                comments.setName(resultSet.getString(3));
                comments.setAccount(resultSet.getString(4));
                comments.setTime(resultSet.getString(5));
                comments.setValue(resultSet.getString(6));

                commentsArrayList.add(comments);
            }
            return commentsArrayList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getCommentsNum(int titleId){
        try{
            Connection con = DbUtil.getConnection();
            String sql = "SELECT COUNT(*) FROM comments WHERE title_id="+titleId;
            PreparedStatement pps = con.prepareStatement(sql);
            ResultSet rs = pps.executeQuery();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}

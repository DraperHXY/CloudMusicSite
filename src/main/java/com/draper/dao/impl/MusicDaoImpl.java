package com.draper.dao.impl;

import com.draper.dao.MusicDao;
import com.draper.domain.Music;
import com.draper.util.DbUtil;

import javax.sql.rowset.serial.SerialBlob;
import java.io.*;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import com.draper.util.Mp3Util;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

/**
 * Created by Draper_HXY 2017/12/9 下午2:15
 * Email: Draper_HXY@163.com
 */
public class MusicDaoImpl implements MusicDao{

    private static Logger logger = Logger.getLogger(MusicDaoImpl.class);

    public void add(File file) {

        Music music = Mp3Util.getMP3Info(file);
        String name = music.getSongName();
        String singer = music.getSinger();
        Integer duration = music.getDuration();

        try {
            Connection con = DbUtil.getConnection();
            String sql = "INSERT INTO music VALUES (?,?,?,?,?)";
            PreparedStatement pps = null;
            pps = con.prepareStatement(sql);
            pps.setString(1, name);

            byte[] musicBytes = IOUtils.toByteArray(new FileInputStream(file));
            Blob musicData = new SerialBlob(musicBytes);
            pps.setBlob(2, musicData);

            pps.setString(3, singer);

            pps.setInt(4, duration);

            byte[] imageBytes = Mp3Util.getMP3Image(file);
            Blob imageData = new SerialBlob(imageBytes);
            pps.setBlob(5, imageData);
            pps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //从数据库获取mp3
    public String find(String name, String outputPath) {
        try {
            Connection con = DbUtil.getConnection();
            String sql = "SELECT * FROM music WHERE name = ?";
            PreparedStatement pps = null;
            pps = con.prepareStatement(sql);
            pps.setString(1, name);

            logger.info("info_find_music_name" + name);
            logger.debug("debug_find_music_name" + name);
            logger.error("error_find_music_name" + name);
            ResultSet rs = pps.executeQuery();
            if (rs.next()) {
                Blob blob = rs.getBlob(2);
                InputStream in = blob.getBinaryStream();
                OutputStream out = new FileOutputStream(outputPath + "/" + name + ".mp3");
                IOUtils.copy(in, out);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputPath;
    }

    public String findImage(String name) {
        String path = "../webapps/img/" + name + ".jpg";
        File file = new File(path);
        if (file.exists()) {
            return path;
        }

        try {
            Connection con = DbUtil.getConnection();
            String sql = "SELECT image FROM music WHERE name = ?";
            PreparedStatement pps = null;
            pps = con.prepareStatement(sql);
            pps.setString(1, name);
            ResultSet rs = pps.executeQuery();

            if (rs.next()) {
                Blob blob = rs.getBlob(1);
                InputStream in = blob.getBinaryStream();
                OutputStream out = new FileOutputStream(path);
                IOUtils.copy(in, out);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;

    }

    public List<Music> findMusicInfoList() {
        List<Music> musicInfoList = new LinkedList<Music>();
        try {
            Connection con = DbUtil.getConnection();
            String sql = "SELECT name,singer,duration FROM music";
            PreparedStatement pps = null;
            pps = con.prepareStatement(sql);
            ResultSet rs = pps.executeQuery();
            while (rs.next()) {
                String name = rs.getString(1);
                String singer = rs.getString(2);
                int duration = rs.getInt(3);
                Music music = new Music();
                music.setSongName(name);
                music.setSinger(singer);
                music.setDuration(duration);
                musicInfoList.add(music);
            }
            return musicInfoList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String findMusicData(String name) {
        String path = "../webapps/CloudMusicSite/load_music/";
        File file = new File(path);
        if (file.exists()) {

            path = path + name + ".mp3";
            file = new File(path);
            if (file.exists()) {
                return path;
            }
        } else {
            file.mkdirs();
            path = path + name + ".mp3";
        }
        try {
            Connection con = DbUtil.getConnection();
            String sql = "SELECT datas FROM music WHERE name = ?";
            PreparedStatement pps = null;
            pps = con.prepareStatement(sql);
            pps.setString(1, name);
            ResultSet rs = pps.executeQuery();
            if (rs.next()) {
                Blob blob = rs.getBlob(1);
                InputStream in = blob.getBinaryStream();
                OutputStream out = new FileOutputStream(path);
                IOUtils.copy(in, out);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }

    public int getMusicNum() {
        try {
            Connection con = DbUtil.getConnection();
            String sql = "SELECT name FROM music";
            PreparedStatement pps = null;
            pps = con.prepareStatement(sql);
            ResultSet resultSet = pps.executeQuery();
            int count = 0;
            while (resultSet.next()) {
                count++;
            }
            return count;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<String> findMusicNameList() {
        try {
            Connection con = DbUtil.getConnection();
            String sql = "SELECT name FROM music";
            PreparedStatement pps = null;
            pps = con.prepareStatement(sql);
            ResultSet resultSet = pps.executeQuery();
            List<String> musicNameList = new LinkedList<String>();
            while (resultSet.next()) {
                musicNameList.add(resultSet.getString(1));
            }
            return musicNameList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}

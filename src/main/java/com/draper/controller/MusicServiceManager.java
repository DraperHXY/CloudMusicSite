package com.draper.controller;

import com.draper.dao.MusicDao;
import com.draper.dao.impl.MusicDaoImpl;
import com.draper.domain.Music;

import java.util.List;

/**
 * Created by Draper_HXY 2017/12/9 下午7:03
 * Email: Draper_HXY@163.com
 */
public class MusicServiceManager {

    /**
     * 获取数据库歌曲的数量
     *
     * @return
     */
    public static int getMusicNum() {
        MusicDao musicDao = new MusicDaoImpl();
        return musicDao.getMusicNum();
    }

    /**
     * 预下载图片
     *
     * @return
     */
    public static List<String> preDownloadImage() {
        MusicDao musicDao = new MusicDaoImpl();
        List<String> musicNameList = musicDao.findMusicNameList();
        for (int i = 0; i < musicNameList.size(); i++) {
            String name = musicNameList.get(i);
            musicDao.findImage(name);
        }
        return musicNameList;
    }

    /**
     * 预下载音乐的信息
     *
     * @return
     */
    public static List<Music> preDownloadInfo() {
        MusicDao musicDao = new MusicDaoImpl();
        List<Music> musicNameList = musicDao.findMusicInfoList();
        return musicNameList;
    }

    public static String getMusicPath(String name) {
        MusicDao musicDao = new MusicDaoImpl();
        String path = musicDao.findMusicData(name);
        return path;
    }
}

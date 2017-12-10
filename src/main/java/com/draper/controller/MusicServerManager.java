package com.draper.controller;

import com.draper.dao.MusicDao;
import com.draper.dao.impl.MusicDaoImpl;
import com.draper.domain.Music;

import java.util.List;

/**
 * Created by Draper_HXY 2017/12/9 下午7:03
 * Email: Draper_HXY@163.com
 */
public class MusicServerManager {

    public static List<Music> get(){

        return null;
    }

    /**
     * 获取数据库歌曲的数量
     * @return
     */
    public static int getMusicNum(){
        MusicDao musicDao = new MusicDaoImpl();
        return musicDao.getMusicNum();
    }

    public static List<String> preDownloadImage(){
        MusicDao musicDao = new MusicDaoImpl();
        List<String> musicNameList = musicDao.findMusicNameList();
        for (int i = 0; i < musicNameList.size(); i++) {
            String name = musicNameList.get(i);
            musicDao.findImage(name);
        }
        return musicNameList;
    }

    public static List<Music> preDownloadInfo(){
        MusicDao musicDao = new MusicDaoImpl();
        List<Music> musicNameList = musicDao.findMusicInfoList();
        return musicNameList;
    }
}

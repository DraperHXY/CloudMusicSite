package com.draper.dao;

import com.draper.domain.Music;

import java.io.File;
import java.util.List;

/**
 * Created by Draper_HXY 2017/12/9 下午2:15
 * Email: Draper_HXY@163.com
 */
public interface MusicDao {

    void add(File file);

    String find(String name, String outputPath);

    String findImage(String name);

    List<Music> findMusicInfoList();

    String findMusicData(String name);

    int getMusicNum();

    List<String> findMusicNameList();

}

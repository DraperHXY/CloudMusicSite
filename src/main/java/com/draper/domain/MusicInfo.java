package com.draper.domain;

/**
 * Created by Draper_HXY 2017/12/9 下午7:40
 * Email: Draper_HXY@163.com
 */
public class MusicInfo {
    private String musicAddress;

    private String imageAddress;

    private Music music;


    public String getMusicAddress() {
        return musicAddress;
    }

    public void setMusicAddress(String musicAddress) {
        this.musicAddress = musicAddress;
    }

    public String getImageAddress() {
        return imageAddress;
    }

    public void setImageAddress(String imageAddress) {
        this.imageAddress = imageAddress;
    }

    public Music getMusic() {
        return music;
    }

    public void setMusic(Music music) {
        this.music = music;
    }
}

package com.draper;

import com.draper.util.DbUtil;
import com.draper.util.Mp3Util;

import java.io.File;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Draper_HXY 2017/11/27 下午7:35
 * Email: Draper_HXY@163.com
 */
public class Test {

    public static void main(String[] args) {
        String string = Mp3Util.saveMP3Image(new File("Where is the love.mp3"),"src/main/resources/",true);
        System.out.println(string);
    }


}

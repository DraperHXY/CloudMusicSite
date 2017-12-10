import com.draper.dao.MusicDao;
import com.draper.dao.impl.MusicDaoImpl;
import org.junit.Test;

import java.io.File;

/**
 * Created by Draper_HXY 2017/12/9 下午2:44
 * Email: Draper_HXY@163.com
 */
public class MusicDaoImplTest {

    @Test
    public void testAdd(){
        MusicDao musicDao = new MusicDaoImpl();
        musicDao.add(new File("Where is the love.mp3"));
//        musicDao.add("Dreaming Alone","Dreaming Alone.mp3");
//        musicDao.add("Where is the love","Where is the love.mp3");
    }

    @Test
    public void testFindImage(){
        MusicDao musicDao = new MusicDaoImpl();
        musicDao.findImage("Where Is the Love");
    }

    @Test
    public void testGetNum(){
        MusicDao musicDao = new MusicDaoImpl();
        System.out.println(musicDao.getMusicNum());
    }

}

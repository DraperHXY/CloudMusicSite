import com.draper.dao.UserDao;
import com.draper.dao.impl.UserDaoImpl;
import com.draper.domain.User;
import org.junit.Assert;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Draper_HXY 2017/11/27 下午8:33
 * Email: Draper_HXY@163.com
 */

public class UserDaoImplTest {

    @Test
    public void testAdd100() {
        UserDao userDao = new UserDaoImpl();
        for (int i = 0; i < 100; i++) {
            User user = new User(String.valueOf(i));
            user.setName("第" + i + "个 Draper");
            user.setPassword(String.valueOf(i));
            user.setCredit(i);
            userDao.add(user);
        }
    }

    @Test
    public void testAddRepeat() {
        try {
            UserDao userDao = new UserDaoImpl();
            User user1 = new User("Draper");
            user1.setName("Draper");
            user1.setPassword("Draper");
            userDao.add(user1);
            User user2 = new User("Draper");
            user2.setName("Draper");
            user2.setPassword("Draper");
            userDao.add(user2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFind() {
        UserDao userDao = new UserDaoImpl();
        User user = (User) userDao.find("Draper");
        Assert.assertEquals("Draper", user.getName());
        Assert.assertEquals("Draper", user.getAccount());
        Assert.assertEquals("Draper", user.getPassword());

    }

    @Test
    public void testCheck() {
        UserDao userDao = new UserDaoImpl();
        User user = new User("Draper");
        user.setPassword("Draper");
        Assert.assertEquals(true, userDao.checkUser(user));
    }

    @Test
    public void testIncreaseCredit() {
        UserDao userDao = new UserDaoImpl();
        User user = new User("Draper");
        user.setPassword("Draper");
        userDao.increaseCredit(10, user);
    }

    @Test
    public void testDecreaseCredit() {
        UserDao userDao = new UserDaoImpl();
        User user = new User("Draper");
        user.setPassword("Draper");
        userDao.decreaseCredit(20, user);
    }

    @Test
    public void testRefreshLastLoginTime() {
        UserDao userDao = new UserDaoImpl();
        User user = new User("Draper");
        userDao.refreshLastLoginTime(user);
    }

    @Test
    public void testGetLastLoginTime() {
        UserDao userDao = new UserDaoImpl();
        User user = new User("Draper_HXY@163.com");
        Date date = userDao.getLastLoginTime(user);
        System.out.println(date.toString());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String now = df.format(new Date());
        System.out.println(now);
        boolean isEqual = date.toString().equals(now);
        Assert.assertEquals(true, isEqual);
    }

}

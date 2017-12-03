import com.draper.dao.UserDao;
import com.draper.dao.impl.UserDaoImpl;
import com.draper.domain.User;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Draper_HXY 2017/11/27 下午8:33
 * Email: Draper_HXY@163.com
 */

public class UserDaoImplTest {

    @Test
    public void testAdd100() {
        UserDao userDao = new UserDaoImpl();
        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setName("第" + i + "个 Draper");
            user.setAccount(String.valueOf(i));
            user.setPassword(String.valueOf(i));
            user.setCredit(i);
            userDao.add(user);
        }
    }

    @Test
    public void testAddRepeat() {
        try {
            UserDao userDao = new UserDaoImpl();
            User user1 = new User();
            user1.setName("Draper");
            user1.setAccount("Draper");
            user1.setPassword("Draper");
            userDao.add(user1);
            User user2 = new User();
            user2.setName("Draper");
            user2.setAccount("Draper");
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
        User user = new User();
        user.setAccount("Draper");
        user.setPassword("Draper");
        Assert.assertEquals(true, userDao.checkUser(user));
    }

    @Test
    public void testIncreaseCredit(){
        UserDao userDao = new UserDaoImpl();
        User user = new User();
        user.setAccount("Draper");
        user.setPassword("Draper");
        userDao.increaseCredit(10,user);
    }

    @Test
    public void testDecreaseCredit(){
        UserDao userDao = new UserDaoImpl();
        User user = new User();
        user.setAccount("Draper");
        user.setPassword("Draper");
        userDao.decreaseCredit(20, user);
    }

}

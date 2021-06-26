import com.UserLoginDemo.dao.UserDao;
import com.UserLoginDemo.domain.User;
import org.junit.jupiter.api.Test;

public class UserDaoTest {
    @Test
    public void UserLoginTest() {
        UserDao ud = new UserDao();
        User user = new User();

        user.setUsername("zhangsan");
        user.setPassword("123456");
        User loginUser = ud.login(user);
        System.out.println(loginUser);
    }
}

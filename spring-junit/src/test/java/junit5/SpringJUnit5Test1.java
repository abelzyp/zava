package junit5;

import junit.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * 方式1
 *
 * @author Zhang
 * @since 2023/4/29
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(value = "classpath:bean.xml")
public class SpringJUnit5Test1 {

    @Autowired
    private User user;

    @Test
    public void testUser() {
        System.out.println(user);
        user.run();
    }
}

package junit5;

import junit.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * 方式2
 *
 * @author Zhang
 * @since 2023/4/29
 */
@SpringJUnitConfig(locations = "classpath:bean.xml")
public class SpringJUnit5Test2 {

    @Autowired
    private User user;

    @Test
    public void testUser() {
        System.out.println(user);
        user.run();
    }
}

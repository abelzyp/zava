package bean;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Zhang
 * @since 2023/4/22
 */
public class PropUserTest {

    @Test
    public void testProp() {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("classpath:bean-props.xml");
        User user = context.getBean("propUser", User.class);
        System.out.println(user);
    }
}

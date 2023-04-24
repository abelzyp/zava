package bean;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Zhang
 * @since 2023/4/23
 */
public class UserFactoryBeanTest {

    @Test
    public void factoryBeanTest() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean-factorybean.xml");
        Object userF = context.getBean("userF");
        System.out.println(userF);
    }
}
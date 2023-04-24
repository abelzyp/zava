package bean;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Zhang
 * @since 2023/4/23
 */
public class PersonTest {
    @Test
    public void testBeanLifeCycle() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean-lifecycle.xml");
        Person person = context.getBean("person", Person.class);
        System.out.println("6 bean对象创建完毕(可以使用)");
        System.out.println(person);
        context.close();
    }
}
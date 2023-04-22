package bean;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpecialValueTest {

    @Test
    public void testSpecialValue() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/bean-di.xml");
        SpecialValue specialValue = context.getBean("specialValue", SpecialValue.class);
        System.out.println(specialValue);
    }
}
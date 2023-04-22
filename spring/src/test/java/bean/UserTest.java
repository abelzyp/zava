package bean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * RunWith标识基于JUnit 4的Spring测试框架
 * ContextConfiguration启动Spring容器
 *
 * @author Abel
 * @date 2023/4/15
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class UserTest {

    @Test
    public void getBean() {
        //1.加载Spring配置文件
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/bean.xml");
        //2.获取创建的Bean对象
        User user = context.getBean("user", User.class);
        System.out.println(user);
        user.add();
    }
}
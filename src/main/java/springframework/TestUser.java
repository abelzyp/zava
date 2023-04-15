package springframework;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Zhang
 * @since 2023/4/15
 */
public class TestUser {
    public static void main(String[] args) {
        //1.加载Spring配置文件
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        //2.获取创建的Bean对象
        User user = context.getBean("user", User.class);
        System.out.println(user);
        user.add();
    }
}

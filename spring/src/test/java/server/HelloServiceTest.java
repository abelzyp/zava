package server;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring.server.HelloService;


/**
 * RunWith标识基于JUnit 4的Spring测试框架
 * ContextConfiguration启动Spring容器
 *
 * @author Abel
 * @date 2018/6/1
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class HelloServiceTest {

    @Autowired
    private HelloService helloService;

    @Test
    public void sayHello() {
        String name = "Abel";
        Assert.assertEquals("Hello " + name + " !", helloService.sayHello(name));
    }
}
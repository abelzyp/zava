package springweb;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * RunWith标识基于JUnit 4的Spring测试框架
 * ContextConfiguration启动Spring容器
 *
 * @author Abel
 * @date 2018/6/1
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-mvc.xml")
public class HelloServiceTest {

    @Resource
    private HelloService helloService;

    @Test
    public void sayHello() {
        String name = "Abel";
        Assert.assertEquals("Hello " + name + " !", helloService.sayHello(name));
    }
}
package event;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
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
@ContextConfiguration(locations = "classpath:applicationContext-event.xml")
public class PublishEventTest {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Test
    public void sayHello() {
        MyEvent myEvent = new MyEvent(this, "新消息");
        applicationEventPublisher.publishEvent(myEvent);
    }
}
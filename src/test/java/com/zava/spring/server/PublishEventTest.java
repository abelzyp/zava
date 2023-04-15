package com.zava.spring.server;

import com.zava.spring.context.MyEvent1;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * RunWith标识基于JUnit 4的Spring测试框架
 * ContextConfiguration启动Spring容器
 *
 * @author Abel
 * @date 2023/4/15
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class PublishEventTest {

    @Resource
    private ApplicationEventPublisher applicationEventPublisher;

    @Test
    public void sayHello() {
        MyEvent1 myEvent = new MyEvent1(this, "新消息");
        applicationEventPublisher.publishEvent(myEvent);
    }
}
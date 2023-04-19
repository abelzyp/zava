package event;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

/**
 * @author Zhang
 * @since 2023/4/19
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-event.xml")
public class PublishMultiEventTest {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Test
    public void publishMultiEvent() {
        MyEvent myEvent1 = new MyEvent(this, "新消息1");
        MyEvent myEvent2 = new MyEvent(this, "新消息2");
        MyEvent myEvent3 = new MyEvent(this, "新消息3");
        ArrayList<MyEvent> myEvents = new ArrayList<>();
        myEvents.add(myEvent1);
        myEvents.add(myEvent2);
        myEvents.add(myEvent3);
        applicationEventPublisher.publishEvent(myEvents);
    }
}

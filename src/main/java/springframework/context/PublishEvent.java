package springframework.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * 3.发布消息，通过ApplicationContext.publishEvent(ApplicationEvent event)发布消息
 * Spring会自动找到对应的处理器进行处理
 *
 * @author Zhang
 * @since 2023/4/12
 */
@Component
public class PublishEvent {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void publishEvent1(String message) {
        MyEvent1 event1 = new MyEvent1(this, message);
        applicationEventPublisher.publishEvent(event1);
    }

    public static void main(String[] args) {
        new PublishEvent().publishEvent1("新消息1");
    }
}

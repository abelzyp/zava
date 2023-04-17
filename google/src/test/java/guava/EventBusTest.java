package guava;

import com.google.common.eventbus.EventBus;
import guava.event.EventListener;
import guava.event.MultiEventListener;
import guava.event.OrderEvent;
import org.junit.Test;

/**
 * @author Abel
 * @date 2018/11/2
 */
public class EventBusTest {

    @Test
    public void test() {
        EventBus eventBus = new EventBus("abel");
        /*
        如果多个subscriber订阅了同一个事件,那么每个subscriber都将收到事件通知
        并且收到事件通知的顺序跟注册的顺序保持一致
         */
        eventBus.register(new EventListener());
        eventBus.register(new MultiEventListener());
        eventBus.post(new OrderEvent("hello"));
        eventBus.post(new OrderEvent("src/test/guava"));
        eventBus.post("!");
    }
}
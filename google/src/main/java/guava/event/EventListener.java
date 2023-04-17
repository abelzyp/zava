package guava.event;

import com.google.common.eventbus.Subscribe;

/**
 * @author zhangyupeng
 * @date 2018/6/20
 */
public class EventListener {

    /**
     * 订阅消息,方法上加上@Subscribe注解
     */
    @Subscribe
    public String listen(OrderEvent event) {
        System.out.println("receive event message: " + event.getMessage());
        return "receive message: " + event.getMessage();
    }

    /**
     * 一个subscriber也可以同时订阅多个事件
     * Guava会通过事件类型来和订阅方法的形参来决定到底调用subscriber的哪个订阅方法
     */
    @Subscribe
    public String listen(String message) {
        System.out.println("receive string message: " + message);
        return "receive message: " + message;
    }
}
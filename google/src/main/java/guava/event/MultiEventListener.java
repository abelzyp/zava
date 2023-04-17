package guava.event;

import com.google.common.eventbus.Subscribe;

/**
 * @author zhangyupeng
 * @date 2018/6/20
 */
public class MultiEventListener {

    @Subscribe
    public String listen(OrderEvent event) {
        System.out.println("收到event消息: " + event.getMessage());
        return "收到消息: " + event.getMessage();
    }

    @Subscribe
    public String listen(String message) {
        System.out.println("收到string消息: " + message);
        return "收到消息: " + message;
    }
}
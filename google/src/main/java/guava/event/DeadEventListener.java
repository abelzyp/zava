package guava.event;

import com.google.common.eventbus.DeadEvent;
import com.google.common.eventbus.Subscribe;

/**
 * @author zhangyupeng
 * @date 2018/6/20
 */
public class DeadEventListener {
    private boolean isDelivered = true;

    @Subscribe
    public void listen(DeadEvent event) {
        isDelivered = false;
        //source通常是EventBus
        System.out.println(event.getSource().getClass() + "  " + event.getEvent());
    }

    public boolean isDelivered() {
        return isDelivered;
    }
}
package event;

import org.springframework.context.ApplicationEvent;

/**
 * 1.定义事件消息，即需要发布的消息对象
 *
 * @author Zhang
 * @since 2023/4/12
 */
public class MyEvent extends ApplicationEvent {

    private String message;

    public MyEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

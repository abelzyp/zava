package event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 2.定义处理器，并声明能够处理的消息类型，即实现ApplicationListener接口
 * 实现类被Spring托管后，会自动被识别，并加入到消息监听集合中
 *
 * @author Zhang
 * @since 2023/4/12
 */
@Component
public class MyListener implements ApplicationListener<MyEvent> {
    @Override
    public void onApplicationEvent(MyEvent event) {
        System.out.println("my listener 收到事件通知:" + event.getMessage());
    }
}

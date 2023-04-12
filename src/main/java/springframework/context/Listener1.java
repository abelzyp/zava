package springframework.context;

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
public class Listener1 implements ApplicationListener<MyEvent1> {
    @Override
    public void onApplicationEvent(MyEvent1 event) {
        System.out.println("listener1 收到事件通知:" + event.getMessage());
    }
}

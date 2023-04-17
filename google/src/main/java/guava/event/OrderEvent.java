package guava.event;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Guava 发布-订阅模式中传递的事件,是一个普通的POJO类
 *
 * @author zhangyupeng
 * @date 2018/6/20
 */
@Getter
@AllArgsConstructor
public class OrderEvent {
    private String message;
}
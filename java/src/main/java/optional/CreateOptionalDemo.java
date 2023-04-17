package optional;

import java.util.Optional;

/**
 * @author zhangyupeng
 * @date 2018/8/22
 */
public class CreateOptionalDemo {
    public static void main(String[] args) {
        //创建Optional对象方法
        Optional<Object> o1 = Optional.empty();
        System.out.println(o1.toString());

        Optional<Object> o2 = Optional.of(new Object());
        System.out.println(o2);

        Optional<Object> o3 = Optional.ofNullable(null);
        System.out.println(o3);
    }
}
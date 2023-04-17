package reflect;

import org.junit.Test;

/**
 * @author Zhang Yupeng
 * @since 2023/4/17
 */
public class ReflectUser417Test {

    @Test
    public void user417Test() throws Exception {
        //获取类的Class对象,调用 forName("X") 会导致名为 X 的类被初始化
        Class<?> clazz = Class.forName("reflect.User417");
        //调用方法创建对象
        User417 user417 = (User417) clazz.newInstance();
        user417.say();
    }
}

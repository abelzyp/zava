package reflect;

import java.lang.reflect.Method;

/**
 * 关于JVM对反射调用的优化
 * 使用反射调用某个类的方法，jvm内部有两种方式
 * JNI：使用native方法进行反射操作
 * pure-Java：生成bytecode进行反射操作，即生成类sun.reflect.GeneratedMethodAccessor<N>，它是一个被反射调用方法的包装类，代理不同的方法，类后缀序号会递增。这种方式第一次调用速度较慢，较之第一种会慢3-4倍，但是多次调用后速度会提升20倍。
 * 对于使用JNI的方式，因为每次都要调用native方法再返回，速度会比较慢。所以，当一个方法被反射调用的次数超过一定次数（默认15次）时，JVM内部会进行优化，使用第2种方法，来加快运行速度。
 * JVM有两个参数来控制这种优化
 * -Dsun.reflect.inflationThreshold=<value>
 * value默认为15，即反射调用某个方法15次后，会由JNI的方式变为pure-java的方式
 * -Dsun.reflect.noInflation=true
 * 默认为false。当设置为true时，表示在第一次反射调用时，就转为pure-java的方式
 *
 * @author Zhang
 * @since 2021/3/26
 */
public class TestMethodInvoke {

    public static void main(String[] args) throws Exception {
        Class<?> clz = Class.forName("reflect.Afoo");
        Object o = clz.newInstance();
        Method m = clz.getMethod("foo", String.class);
        for (int i = 0; i < 100; i++) {
            // 可以看到GeneratedMethodAccessor1的classLoader为DelegatingClassLoader，其parent为AppClassLoader。
            m.invoke(o, Integer.toString(i));
        }
    }
}
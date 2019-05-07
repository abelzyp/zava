package serialize.size;

import java.lang.instrument.Instrumentation;

/**
 * Instrumentation.getObjectSize()方式获取对象大小得到的是Shallow Size
 * 即遇到引用时只计算引用的长度不计算所引用对象的实际大小
 *
 * @author zhangyupeng
 * @date 2019-05-07
 */
public class ObjectShallowSize {
    private static Instrumentation instrumentation;

    public static void premain(String agentArgs, Instrumentation inst) {
        instrumentation = inst;
    }

    public static long getObjectSize(Object o) {
        return instrumentation.getObjectSize(o);
    }
}
package guava;

import com.google.common.base.Joiner;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangyupeng
 * @date 2018/6/20
 */
public class JoinerTest {

    private static final String COMMA = ",";

    @Test
    public void joinerTest() {
        Joiner joiner1 = Joiner.on(COMMA).skipNulls();
        Joiner joiner2 = Joiner.on(COMMA).skipNulls();
        Assert.assertNotEquals(joiner1, joiner2);
    }

    @Test
    public void test() {
        /*
         on:制定拼接符号，如：test1-test2-test3 中的 “-“ 符号
         skipNulls()：忽略NULL,返回一个新的Joiner实例
         useForNull(“Hello”)：NULL的地方都用字符串”Hello”来代替
        */
        StringBuilder sb = new StringBuilder();
        Joiner.on(COMMA).skipNulls().appendTo(sb, "Hello", "src/test/guava");
        System.out.println(sb);
        System.out.println(Joiner.on(COMMA).useForNull("none").join(1, null, 3));
        System.out.println(Joiner.on(",").skipNulls().join(Arrays.asList(1, 2, 3, 4, null, 6)));
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        System.out.println(Joiner.on(COMMA).withKeyValueSeparator("=").join(map));
    }
}
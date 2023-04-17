package guava;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * 键和值唯一，可以reverse
 *
 * @author Abel
 * @date 2018/11/2
 */
public class BiMapTest {

    @Test
    public void test() {
        BiMap<String, String> biMap = HashBiMap.create();
        biMap.put("sina", "sina.com");
        biMap.put("qq", "qq.com");
        biMap.put("sina", "sina.cn"); //会覆盖原来的value

        /*
         在BiMap中,如果你想把键映射到已经存在的值，会抛出IllegalArgumentException异常
         如果对特定值,你想要强制替换它的键，请使用 BiMap.forcePut(key, value)
        */
        //biMap.put("tecent", "qq.com"); //抛出异常
        biMap.forcePut("tecent", "qq.com"); //强制替换key

        System.out.println(biMap);
        System.out.println(biMap.inverse());
        Assert.assertNotEquals(biMap, biMap.inverse());
        Assert.assertEquals(biMap, biMap.inverse().inverse());
    }
}
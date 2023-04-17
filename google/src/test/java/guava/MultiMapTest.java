package guava;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import org.junit.Test;

import java.util.Collection;
import java.util.Map;

/**
 * Multimap可以很容易地把一个键映射到多个值。换句话说，Multimap是把键映射到任意多个值的一般方式。
 *
 * @author zhangyupeng
 * @date 2018/6/20
 */
public class MultiMapTest {

    @Test
    public void test() {
        Multimap<String, Integer> map = HashMultimap.create();
        map.put("a", 1); //key相同时不会覆盖原value
        map.put("a", 2);
        map.put("a", 3);
        map.put("b", 3);
        map.put("b", 4);
        map.put("b", 5);
        System.out.println(map);
        //返回所有”键-单个值映射”的个数,而非不同键的个数
        System.out.println(map.size());
        //返回不同key的个数
        System.out.println(map.keySet().size());

        Map<String, Collection<Integer>> mapView = map.asMap();
        System.out.println(mapView);

        //返回的是集合
        System.out.println(map.get("a"));
    }
}
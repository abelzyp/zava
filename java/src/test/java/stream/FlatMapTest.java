package stream;

import org.junit.Assert;
import org.junit.Test;
import stream.util.Dish;
import stream.util.Menu;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhangyupeng
 * @date 2018/8/27
 */
public class FlatMapTest {

    @Test
    public void mapTest() {
        List<String[]> wrongMap = Menu.menu.stream()
                                           .map(Dish::getName)
                                           .map(name -> name.split(""))
                                           .distinct()
                                           .collect(Collectors.toList());
        //System.out.println(wrongMap);
        Assert.assertNotNull(wrongMap);
    }

    /**
     * flatMap方法把一个流中的每个值映射成另一个流，然后把所有的流连接起来成为一个流
     */
    @Test
    public void flatMapTest() {
        List<String> rightFlatMap = Menu.menu.stream()
                                             .map(Dish::getName)
                                             .map(name -> name.split(""))
                                             .flatMap(Arrays::stream)
                                             .distinct()
                                             .collect(Collectors.toList());
        String expectedStr = "[p, o, r, k, b, e, f, c, h, i, n,  , s, a, u, t, z, w, l, m]";
        Assert.assertEquals(expectedStr, rightFlatMap.toString());
    }
}
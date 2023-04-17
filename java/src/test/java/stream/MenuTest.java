package stream;

import org.junit.Test;
import stream.util.Dish;
import stream.util.Menu;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/**
 * @author zhangyupeng
 * @date 2018/8/26
 */
public class MenuTest {

    /**
     * 需要get的点在于，流中的元素是按需计算的，把sorted放在上面和下面看一下差别
     */
    @Test
    public void menuTest() {
        List<String> names = Menu.menu.stream()
                                      .filter(d -> {
                                          System.out.println("filtering " + d.getName());
                                          return d.getCalories() > 300;
                                      })
                                      .sorted(Comparator.comparing(Dish::getCalories))
                                      .map(d -> {
                                          System.out.println("mapping " + d.getName());
                                          return d.getName();
                                      })
                                      .limit(3)
                                      .collect(Collectors.toList());
        assertEquals("[rice, chicken, salmon]", names.toString());
    }
}
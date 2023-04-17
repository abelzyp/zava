package stream;

import org.junit.Assert;
import org.junit.Test;
import stream.util.Dish;
import stream.util.Menu;

import java.util.Optional;

/**
 * @author zhangyupeng
 * @date 2018/8/27
 */
public class FindAnyTest {

    /**
     * findAny方法：当前流中任意元素
     */
    @Test
    public void findAnyTest() {
        Optional<Dish> dish = Menu.menu.stream()
                                       .filter(Dish::isVegetarian)
                                       .findAny();
        Assert.assertTrue(dish.isPresent());
    }
}
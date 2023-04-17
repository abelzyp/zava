package stream;

import org.junit.Assert;
import org.junit.Test;
import stream.util.Dish;
import stream.util.Menu;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * {@link Stream#findFirst()}在并行上限制更多，如果不关心返回元素，使用{@link Stream#findAny()}
 *
 * @author zhangyupeng
 * @date 2018/8/27
 */
public class FindFirstTest {

    /**
     * findFirst方法：查找第一个元素
     */
    @Test
    public void findFirstTest() {
        Optional<Dish> fishDish = Menu.menu.stream()
                                           .filter(dish -> dish.getType().equals(Dish.Type.FISH))
                                           .findFirst();
        Assert.assertTrue(fishDish.isPresent());
    }
}
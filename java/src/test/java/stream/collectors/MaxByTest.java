package stream.collectors;

import org.junit.Assert;
import org.junit.Test;
import stream.util.Dish;
import stream.util.Menu;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author zhangyupeng
 * @date 2018/9/10
 */
public class MaxByTest {

    /**
     * 最大值:maxBy
     * 最小值:minBy
     */
    @Test
    public void test() {
        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> mostCalorieDish = Menu.menu.stream().collect(Collectors.maxBy(dishCaloriesComparator));
        Assert.assertTrue(mostCalorieDish.isPresent());
        Assert.assertEquals(800, mostCalorieDish.get().getCalories());
    }
}
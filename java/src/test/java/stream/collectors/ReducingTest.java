package stream.collectors;

import org.junit.Assert;
import org.junit.Test;
import stream.util.Dish;
import stream.util.Menu;

import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author zhangyupeng
 * @date 2018/9/11
 */
public class ReducingTest {

    /**
     * reducing()需要3个参数:
     * 1.起始值
     * 2.转换函数
     * 3.累积函数
     */
    @Test
    public void reducingTest() {
        int totalCalories = Menu.menu.stream().collect(Collectors.reducing(0, Dish::getCalories, (i, j) -> i + j));
        Assert.assertEquals(4200, totalCalories);

        Optional<Dish> mostCalorieDish = Menu.menu.stream().collect(Collectors.reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));
        Assert.assertTrue(mostCalorieDish.isPresent());
        Assert.assertEquals(800, mostCalorieDish.get().getCalories());
    }
}
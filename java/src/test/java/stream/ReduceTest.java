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
public class ReduceTest {

    /**
     * reduce方法：接收两个参数，1 初始值，2 lambda把两个流元素结合在一起
     */
    @Test
    public void reduceTest() {
        Integer totalCalories = Menu.menu.stream()
                                         .map(Dish::getCalories)
                                         .reduce(0, Integer::sum);
        Assert.assertEquals("4200", totalCalories.toString());
    }

    @Test
    public void sumTest() {
        Optional<Integer> totalCaloriesOptional = Menu.menu.stream()
                                                           .map(Dish::getCalories)
                                                           .reduce(Integer::sum);
        Assert.assertTrue(totalCaloriesOptional.isPresent());
        Assert.assertEquals("4200", totalCaloriesOptional.get().toString());
    }

    @Test
    public void maxValueTest() {
        Optional<Integer> max1 = Menu.menu.stream()
                                          .map(Dish::getCalories)
                                          .reduce(Integer::max);
        Assert.assertTrue(max1.isPresent());
        Assert.assertEquals("800", max1.get().toString());

        Optional<Integer> max2 = Menu.menu.stream()
                                          .map(Dish::getCalories)
                                          .max(Integer::compareTo);
        Assert.assertTrue(max2.isPresent());
        Assert.assertEquals("800", max2.get().toString());
    }

    /**
     * 怎样用map()和reduce()数一数共有几个菜？
     */
    @Test
    public void countTest() {
        //方法一
        Optional<Integer> count1 = Menu.menu.stream()
                                            .filter(Dish::isVegetarian)
                                            .map(dish -> 1)
                                            .reduce(Integer::sum);
        Assert.assertTrue(count1.isPresent());
        Assert.assertEquals("4", count1.get().toString());

        //方法二
        long count2 = Menu.menu.stream()
                               .filter(Dish::isVegetarian)
                               .count();
        Assert.assertEquals(4, count2);
    }
}
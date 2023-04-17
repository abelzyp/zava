package stream.collectors;

import org.junit.Assert;
import org.junit.Test;
import stream.util.Dish;
import stream.util.Menu;

import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;

/**
 * @author zhangyupeng
 * @date 2018/9/10
 */
public class SummaryTest {

    @Test
    public void summingTest() {
        int totalCalories = Menu.menu.stream().collect(Collectors.summingInt(Dish::getCalories));
        Assert.assertEquals(4200, totalCalories);
    }

    /**
     * 466.6666666666667
     */
    @Test
    public void avgTest() {
        double avgCalories = Menu.menu.stream().collect(Collectors.averagingInt(Dish::getCalories));
        Assert.assertTrue(avgCalories > 466);
    }

    /**
     * IntSummaryStatistics{count=9, sum=4200, min=120, average=466.666667, max=800}
     */
    @Test
    public void summarizingTest() {
        IntSummaryStatistics menuStatistics = Menu.menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
        Assert.assertEquals(9, menuStatistics.getCount());
        Assert.assertEquals(4200, menuStatistics.getSum());
        Assert.assertEquals(120, menuStatistics.getMin());
        Assert.assertEquals(800, menuStatistics.getMax());
    }
}
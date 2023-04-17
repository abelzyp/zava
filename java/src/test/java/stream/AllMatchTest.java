package stream;

import org.junit.Assert;
import org.junit.Test;
import stream.util.Menu;

/**
 * @author zhangyupeng
 * @date 2018/8/27
 */
public class AllMatchTest {

    /**
     * allMatch方法：流中元素是否都能匹配给定谓词
     */
    @Test
    public void allMatchTest() {
        Assert.assertFalse(Menu.menu.stream().allMatch(dish -> dish.getCalories() < 700));
    }

    /**
     * noneMatch方法：确保流中没有任何元素匹配给定谓词
     */
    @Test
    public void noneMatchTest() {
        Assert.assertTrue(Menu.menu.stream().noneMatch(dish -> dish.getCalories() < 100));
    }
}
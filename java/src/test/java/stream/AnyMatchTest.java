package stream;

import org.junit.Assert;
import org.junit.Test;
import stream.util.Dish;
import stream.util.Menu;

/**
 * @author zhangyupeng
 * @date 2018/8/27
 */
public class AnyMatchTest {

    /**
     * anyMatch方法：流中是否有一个元素能匹配给定的谓词
     */
    @Test
    public void anyMatchTest() {
        Assert.assertTrue(Menu.menu.stream().anyMatch(Dish::isVegetarian));
    }
}
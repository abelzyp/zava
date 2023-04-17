package stream.collectors;

import org.junit.Assert;
import org.junit.Test;
import stream.util.Menu;

import java.util.stream.Collectors;

/**
 * @author zhangyupeng
 * @date 2018/9/10
 */
public class CountTest {

    /**
     * 求和
     */
    @Test
    public void countTest() {
        long counting = Menu.menu.stream().collect(Collectors.counting());
        long count = Menu.menu.stream().count();
        Assert.assertEquals(counting, count);
    }
}
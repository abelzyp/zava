package stream;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.IntStream;

/**
 * @author zhangyupeng
 * @date 2018/8/29
 */
public class RangeTest {

    @Test
    public void rangeTest() {
        long count = IntStream.range(1, 100)
                              .filter(n -> n % 2 == 0)
                              .count();
        Assert.assertEquals(49, count);
    }

    @Test
    public void rangeClosedTest() {
        long count = IntStream.rangeClosed(1, 100)
                              .filter(n -> n % 2 == 0)
                              .count();
        Assert.assertEquals(50, count);
    }
}
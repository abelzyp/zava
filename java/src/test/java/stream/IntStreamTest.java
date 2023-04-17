package stream;

import org.junit.Assert;
import org.junit.Test;
import stream.util.Dish;
import stream.util.Menu;

import java.util.OptionalInt;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author zhangyupeng
 * @date 2018/8/29
 */
public class IntStreamTest {

    /**
     * 原始类型流特化方法有3种:
     * {@link java.util.stream.Stream#mapToInt(ToIntFunction)}
     * {@link java.util.stream.Stream#mapToDouble(ToDoubleFunction)}
     * {@link java.util.stream.Stream#mapToLong(ToLongFunction)}
     */
    @Test
    public void mapToTest() {
        int sum = Menu.menu.stream()
                           .mapToInt(Dish::getCalories)
                           .sum();
        Assert.assertEquals(4200, sum);
    }

    /**
     * 转换回对象流
     */
    @Test
    public void boxedTest() {
        IntStream intStream = Menu.menu.stream()
                                       .mapToInt(Dish::getCalories);
        Stream<Integer> stream = intStream.boxed();
        Assert.assertTrue(stream.findAny().isPresent());
    }

    /**
     * 默认值OptionalInt
     */
    @Test
    public void optionalTest() {
        OptionalInt max = Menu.menu.stream()
                                   .mapToInt(Dish::getCalories)
                                   .max();
        Assert.assertEquals(800, max.orElse(800));
    }
}
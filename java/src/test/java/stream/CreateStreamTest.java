package stream;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 构建流
 *
 * @author zhangyupeng
 * @date 2018/8/29
 */
public class CreateStreamTest {

    /**
     * 值
     */
    @Test
    public void streamOfTest() {
        Optional<String> java8 = Stream.of("Java 8 ", "Hello ", "World!")
                                       .map(String::toUpperCase)
                                       .findFirst();
        Assert.assertEquals("JAVA 8 ", java8.orElse(""));
    }

    /**
     * 空流
     */
    @Test
    public void emptyStreamTest() {
        Stream<String> empty = Stream.empty();
        System.out.println(empty);
    }

    /**
     * 数组
     */
    @Test
    public void arrayStreamTest() {
        int[] numbers = {1, 1, 2, 3, 5, 8};
        IntStream intStream = Arrays.stream(numbers);
        Assert.assertEquals(20, intStream.sum());
    }

    /**
     * 迭代
     */
    @Test
    public void iterateTest() {
        Stream<Integer> integerStream = Stream.iterate(0, n -> n + 2)
                                              .limit(10);
        Assert.assertTrue(integerStream.findAny().isPresent());
    }

    @Test
    public void generateTest() {
        Stream<Double> doubleStream = Stream.generate(Math::random)
                                            .limit(5);
        Assert.assertTrue(doubleStream.findAny().isPresent());
    }
}
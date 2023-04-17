package stream.parallel;

import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @author zhangyupeng
 * @date 2018/9/30
 */
class ParallelStreams {

    /**
     * @param n 传统for循环
     * @return
     */
    static long iterativeSum(long n) {
        long result = 0;
        for (long i = 1L; i <= n; i++) {
            result += i;
        }
        return result;
    }

    /**
     * @param n 串行流,应该是慢在iterate生成数字时
     * @return
     */
    static long sequentialSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                     .limit(n)
                     .reduce(0L, Long::sum);
    }

    /**
     * @param n 并行流,性能并没有提高
     * @return
     */
    static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                     .limit(n)
                     .parallel()
                     .reduce(0L, Long::sum);
    }

    /**
     * 1 rangeClosed直接产生原始类型long数字
     * 2 rangeClosed生成数字范围,很容易拆分
     *
     * @param n rangeClosed
     * @return
     */
    static long rangedSum(long n) {
        return LongStream.rangeClosed(1, n)
                         .reduce(0L, Long::sum);
    }

    /**
     * 上一个函数的并行版
     *
     * @param n 并行正确用法
     * @return
     */
    static long parallelRangedSum(long n) {
        return LongStream.rangeClosed(1, n)
                         .parallel()
                         .reduce(0L, Long::sum);
    }

    /**
     * @param n 串行本质,应该慢在每次都new对象上
     * @return
     */
    static long sideEffectSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).forEach(accumulator::add);
        return accumulator.total;
    }

    /**
     * @param n 有问题的版本,不能并行
     * @return
     */
    static long sideEffectParallelSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).parallel().forEach(accumulator::add);
        return accumulator.total;
    }

    public static class Accumulator {
        long total = 0;

        void add(long value) {
            total += value;
        }
    }
}
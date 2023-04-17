package stream.parallel;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * @author zhangyupeng
 * @date 2018/9/15
 */
class ForkJoinSum {

    /**
     * 利用自己编写的分支/合并框架执行并行求和
     *
     * @param n 自然数
     * @return 总和
     */
    static long forkJoinSum(long n) {
        long[] numbers = LongStream.rangeClosed(1, n).toArray();
        ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);
        return new ForkJoinPool().invoke(task);
    }
}
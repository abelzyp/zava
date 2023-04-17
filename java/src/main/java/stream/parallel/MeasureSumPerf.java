package stream.parallel;

import java.util.function.Function;

/**
 * @author zhangyupeng
 * @date 2018/9/30
 */
class MeasureSumPerf {

    /**
     * @param adder 接受一个函数
     * @param n     long参数
     * @return 对传给方法的long应用函数10次, 返回最短的执行时间
     */
    static long measureSumPerf(Function<Long, Long> adder, long n) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            long sum = adder.apply(n);
            long duration = (System.nanoTime() - start) / 1_000_000;
            System.out.println("Result: " + sum);
            if (duration < fastest) {
                fastest = duration;
            }
        }
        return fastest;
    }
}
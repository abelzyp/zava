package stream.parallel;

import org.junit.Test;

/**
 * @author zhangyupeng
 * @date 2018/9/30
 */
public class ForkJoinSumTest {

    /**
     * 实测性能看起来比并行流版本差,是因为必须要把整个数字流都放进一个long[],之后才能在ForkJoinSumCalculator任务中使用
     */
    @Test
    public void forkJoinSum() {
        System.out.println(MeasureSumPerf.measureSumPerf(ForkJoinSum::forkJoinSum, 10_000_000));
    }
}
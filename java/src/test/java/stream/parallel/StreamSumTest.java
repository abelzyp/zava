package stream.parallel;

import org.junit.Test;

/**
 * 本测试验证有时候并行流不一定比串行流好,各种情况下的执行时间
 *
 * @author zhangyupeng
 * @date 2018/9/30
 */
public class StreamSumTest {

    @Test
    public void iterativeSumTest() {
        System.out.println(MeasureSumPerf.measureSumPerf(ParallelStreams::iterativeSum, 10_000_000));
    }

    @Test
    public void sequentialSumTest() {
        System.out.println(MeasureSumPerf.measureSumPerf(ParallelStreams::sequentialSum, 10_000_000));
    }

    @Test
    public void parallelSumTest() {
        System.out.println(MeasureSumPerf.measureSumPerf(ParallelStreams::parallelSum, 10_000_000));
    }

    @Test
    public void rangedSumTest() {
        System.out.println(MeasureSumPerf.measureSumPerf(ParallelStreams::rangedSum, 10_000_000));
    }

    @Test
    public void parallelRangedSumTest() {
        System.out.println(MeasureSumPerf.measureSumPerf(ParallelStreams::parallelRangedSum, 10_000_000));
    }

    @Test
    public void sideEffectSumTest() {
        System.out.println(MeasureSumPerf.measureSumPerf(ParallelStreams::sideEffectSum, 10_000_000));
    }

    @Test
    public void sideEffectParallelSumTest() {
        System.out.println(MeasureSumPerf.measureSumPerf(ParallelStreams::sideEffectParallelSum, 10_000_000));
    }
}
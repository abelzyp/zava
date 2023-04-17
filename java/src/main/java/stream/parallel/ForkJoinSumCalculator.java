package stream.parallel;

import java.util.concurrent.RecursiveTask;

/**
 * 并行对前n个自然数求和的方法{@link ForkJoinSum}
 *
 * @author zhangyupeng
 * @date 2018/9/15
 */
public class ForkJoinSumCalculator extends RecursiveTask<Long> {

    private final long[] numbers;
    private final int start;
    private final int end;

    /**
     * 拆分大小也会影响性能
     */
    private static final long THRESHOLD = 10_000;

    /**
     * 公共构造函数用于创建主任务
     *
     * @param numbers 累加数组
     */
    ForkJoinSumCalculator(long[] numbers) {
        this(numbers, 0, numbers.length);
    }

    /**
     * 私有构造函数用于以递归方式为主任务创建子任务
     *
     * @param numbers 累加数组
     * @param start   起始位置
     * @param end     结束位置
     */
    private ForkJoinSumCalculator(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        int length = end - start;
        if (length <= THRESHOLD) {
            return computeSequentially();
        }
        //创建一个子任务来为数组的前一半求和
        ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(numbers, start, start + length / 2);
        //利用另一个ForkJoinPool线程异步执行新创建的子任务
        leftTask.fork();
        //创建一个任务为数组的后一半求和
        ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(numbers, start + length / 2, end);
        //同步执行第二个子任务
        Long rightResult = rightTask.compute();
        //读取第一个子任务的结果,如果尚未完成就等待
        Long leftResult = leftTask.join();
        //该任务的结果是两个子任务结果的组合
        return leftResult + rightResult;
    }

    /**
     * 当子任务不再可拆分时的简单算法
     *
     * @return 不可拆解的和
     */
    private long computeSequentially() {
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += numbers[i];
        }
        return sum;
    }
}
package future;

import java.util.concurrent.*;

/**
 * @author Abel
 * @date 2018/10/16
 */
class FutureExecutor {

    /**
     * 线程池返回Future用法
     */
    Double futureExecutor() {
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Double> future = executor.submit(new Callable<Double>() {
            @Override
            public Double call() throws Exception {
                return doSomeLongComputation();
            }
        });

        try {
            Double result = future.get(1, TimeUnit.SECONDS);
            return result * 2;
        } catch (ExecutionException ee) {
            //计算抛出异常
            return 0.0;
        } catch (InterruptedException ie) {
            //当前线程在等待过程中被中断
            return 0.0;
        } catch (TimeoutException te) {
            //在Future对象完成之前超时已过期
            return 0.0;
        }
    }

    private Double doSomeLongComputation() {
        return 2.0;
    }
}
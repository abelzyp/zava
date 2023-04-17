package future;

import org.junit.Ignore;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author Abel
 * @date 2018/10/18
 */
public class CompletableFutureDemoTest {

    private static final String product = "my favorite product";

    @Test
    public void getPriceCompletableFuture() {
        long start = System.nanoTime();
        Future<Double> futurePrice = CompletableFutureDemo.getPriceCompletableFuture(product);
        long invocationTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Invocation returned after " + invocationTime + "msecs");

        //并行执行其他任务

        try {
            double price = futurePrice.get();
            System.out.println("随机计算出的价格为:" + price);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Price returned after " + retrievalTime + "msecs");
    }

    @Test
    public void getPrice() {
        long start = System.nanoTime();
        double price = CompletableFutureDemo.getPrice(product);
        System.out.println("随机计算出的价格为:" + price);
        long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Price returned after " + retrievalTime + "msecs");
    }

    @Test
    public void getPriceAsync() {
        long start = System.nanoTime();
        Future<Double> futurePrice = CompletableFutureDemo.getPriceAsync(product);
        long invocationTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Invocation returned after " + invocationTime + "msecs");

        //并行执行其他任务

        try {
            double price = futurePrice.get();
            System.out.println("随机计算出的价格为:" + price);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Price returned after " + retrievalTime + "msecs");
    }

    //    @Test
    @Ignore
    public void getPriceExceptionAsync() {
        long start = System.nanoTime();
        Future<Double> futurePrice = CompletableFutureDemo.getPriceExceptionAsync(product);
        long invocationTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Invocation returned after " + invocationTime + "msecs");

        //并行执行其他任务

        try {
            double price = futurePrice.get();
            System.out.println("随机计算出的价格为:" + price);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Price returned after " + retrievalTime + "msecs");
    }

    /**
     * CompletableFuture 提供了 join() 方法，它的功能和 get() 方法一样都是阻塞获取值，
     * 它们的区别在于 join() 抛出的是 unchecked Exception。
     */
    @Test
    public void supplyTest() {
        CompletableFuture<String> future1 =
                CompletableFuture.supplyAsync(() -> {
                    throw new RuntimeException();
                })
                        .exceptionally(ex -> "errorResultA")
                        .thenApply(resultA -> resultA + " resultB")
                        .thenApply(resultB -> resultB + " resultC")
                        .thenApply(resultC -> resultC + " resultD");
        System.out.println(future1.join());

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "resultA")
                .thenApply(resultA -> resultA + " resultB")
                .thenApply(resultB -> {
                    throw new RuntimeException();
                })
                .handle((o, throwable) -> {
                    if (throwable != null) {
                        return "errorResultC";
                    }
                    return o;
                })
                .thenApply(resultC -> resultC + " resultD");
        System.out.println(future2.join());
    }
}
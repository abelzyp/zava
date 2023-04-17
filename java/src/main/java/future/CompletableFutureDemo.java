package future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * @author Abel
 * @date 2018/10/18
 */
public class CompletableFutureDemo {

    /**
     * @param product 产品名称
     * @return 使用工厂方法
     */
    public static Future<Double> getPriceCompletableFuture(String product) {
        return CompletableFuture.supplyAsync(() -> Shop.calculatePrice(product));
    }

    /**
     * @param product 产品名称
     * @return 同步阻塞获取价格
     */
    public static double getPrice(String product) {
        return Shop.calculatePrice(product);
    }

    /**
     * @param product 产品名称
     * @return 异步获取价格
     */
    public static Future<Double> getPriceAsync(String product) {
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread(() -> {
            double price = Shop.calculatePrice(product);
            futurePrice.complete(price);
        }).start();
        return futurePrice;
    }

    /**
     * @param product 产品名称
     * @return 异步获取价格(异常)
     */
    public static Future<Double> getPriceExceptionAsync(String product) {
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread(() -> {
            try {
                double price = Shop.calculatePriceException(product);
                futurePrice.complete(price);
            } catch (Exception ex) {
                futurePrice.completeExceptionally(ex);
            }
        }).start();
        return futurePrice;
    }
}
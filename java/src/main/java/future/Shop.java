package future;

import java.util.Random;

/**
 * @author Abel
 * @date 2018/10/17
 */
class Shop {

    /**
     * @param product 依据产品名称
     * @return 1s之后返回随机价格
     */
    static double calculatePrice(String product) {
        delay();
        return new Random().nextDouble() * product.charAt(0) * product.charAt(1);
    }

    /**
     * @param product 依据产品名称
     * @return 1s之后返回随机价格
     */
    static double calculatePriceException(String product) {
        delay();
        throw new RuntimeException("product not available");
    }

    /**
     * 模拟1s延迟
     */
    private static void delay() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }
}
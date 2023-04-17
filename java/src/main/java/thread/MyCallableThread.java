package thread;

import java.util.concurrent.Callable;

/**
 * @author Abel
 * @date 2018-12-23
 */
public class MyCallableThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        return sum;
    }

}
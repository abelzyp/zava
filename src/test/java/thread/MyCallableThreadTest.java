package thread;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Abel
 * @date 2018-12-23
 */
public class MyCallableThreadTest {

    @Test
    public void myCallableThreadTest() {

        //1.执行 Callable 方式,需要 FutureTask 实现类的支持,用于接收运算结果
        MyCallableThread ct = new MyCallableThread();
        FutureTask<Integer> result = new FutureTask<>(ct);
        new Thread(result).start();

        //2.接收线程运算后的结果
        try {
            Integer sum = result.get();
            System.out.println(sum);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

}
package thread;

import org.junit.Test;

/**
 * @author Abel
 * @date 2018-12-23
 */
public class MyThreadTest {

    @Test
    public void myThreadTest() {
        Thread t1 = new MyThread();
        Thread t2 = new MyThread();
        t1.start();
        t2.start();
    }

}
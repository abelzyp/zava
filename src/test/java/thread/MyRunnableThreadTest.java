package thread;

import org.junit.Test;

/**
 * @author Abel
 * @date 2018-12-23
 */
public class MyRunnableThreadTest {

    @Test
    public void myRunnableThreadTest() {
        MyRunnableThread rt1 = new MyRunnableThread();
        MyRunnableThread rt2 = new MyRunnableThread();
        Thread t1 = new Thread(rt1);
        Thread t2 = new Thread(rt2);
        t1.start();
        t2.start();
    }

}
package thread;

/**
 * @author Abel
 * @date 2018-12-23
 */
public class MyRunnableThread implements Runnable {
    @Override
    public void run() {
        System.out.println("我的Runnable线程方法");
    }
}
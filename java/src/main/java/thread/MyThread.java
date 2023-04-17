package thread;

/**
 * 集成Thread类实现多线程
 *
 * @author Abel
 * @date 2018-12-23
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("我的线程");
    }
}
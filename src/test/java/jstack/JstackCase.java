package jstack;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 用来测试死锁
 *
 * @author zhangyupeng
 * @date 2019-05-28
 */
public class JstackCase {

    private static Executor executor = Executors.newFixedThreadPool(5);
    private static final Object lock = new Object();

    public static void main(String[] args) {
        Task task1 = new Task();
        Task task2 = new Task();
        executor.execute(task1);
        executor.execute(task2);
    }

    static class Task implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                calculate();
            }
        }

        void calculate() {
            int i = 0;
            while (true) {
                i++;
            }
        }
    }
}
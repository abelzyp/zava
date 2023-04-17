package producerConsumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 生产者线程，它构建PCData对象，并放入BlockingQueue队列中
 *
 * @author Zhang Yupeng
 * @since 2021/2/11
 */
public class Producer implements Runnable {

    private volatile boolean isRunning = true;

    /**
     * 内存缓冲区
     */
    private BlockingQueue<PCData> queue;

    /**
     * 总数，原子操作
     */
    private static AtomicInteger count = new AtomicInteger();

    private static final int SLEEP_TIME = 1000;

    public Producer(BlockingQueue<PCData> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        PCData data = null;
        Random r = new Random();

        System.out.println("start producer id=" + Thread.currentThread().getId());

        try {
            while (isRunning) {
                Thread.sleep(r.nextInt(SLEEP_TIME));
                // 构造任务数据
                data = new PCData(count.incrementAndGet());
                System.out.println(data + " is put into queue");
                if (!queue.offer(data, 2, TimeUnit.SECONDS)) {
                    // 提交数据到缓冲区
                    System.out.println("failed to put data: " + data);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    public void stop() {
        isRunning = false;
    }
}
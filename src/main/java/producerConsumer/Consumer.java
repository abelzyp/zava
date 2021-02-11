package producerConsumer;

import java.text.MessageFormat;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * 消费者实现，它从BlockingQueue队列中取出PCData对象，并进行相应的计算
 *
 * @author Zhang Yupeng
 * @since 2021/2/11
 */
public class Consumer implements Runnable {

    /**
     * 缓冲区
     */
    private BlockingQueue<PCData> queue;

    private static final int SLEEP_TIME = 1000;

    public Consumer(BlockingQueue<PCData> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("start Consumer id=" + Thread.currentThread().getId());
        // 随机等待时间
        Random r = new Random();

        try {
            while (true) {
                // 提取任务
                PCData data = queue.take();
                if (data != null) {
                    // 计算平方
                    int re = data.getIntData() * data.getIntData();
                    System.out.println(MessageFormat.format("{0}*{1}={2}", data.getIntData(), data.getIntData(), re));
                    Thread.sleep(r.nextInt(SLEEP_TIME));
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
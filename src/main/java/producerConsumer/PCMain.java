package producerConsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 主函数中创建3个生产者和3个消费者，并协作运行
 *
 * @author Zhang Yupeng
 * @since 2021/2/11
 */
public class PCMain {

    public static void main(String[] args) throws InterruptedException {
        // 建立缓冲区
        BlockingQueue<PCData> queue = new LinkedBlockingQueue<>(10);

        // 建立生产者
        Producer producer1 = new Producer(queue);
        Producer producer2 = new Producer(queue);
        Producer producer3 = new Producer(queue);
        // 建立消费者
        Consumer consumer1 = new Consumer(queue);
        Consumer consumer2 = new Consumer(queue);
        Consumer consumer3 = new Consumer(queue);

        // 建立线程池
        ExecutorService service = Executors.newCachedThreadPool();

        // 运行生产者
        service.execute(producer1);
        service.execute(producer2);
        service.execute(producer3);
        // 运行消费者
        service.execute(consumer1);
        service.execute(consumer2);
        service.execute(consumer3);

        Thread.sleep(10 * 1000);

        // 停止生产者
        producer1.stop();
        producer2.stop();
        producer3.stop();

        Thread.sleep(3000);
        service.shutdown();
    }
}
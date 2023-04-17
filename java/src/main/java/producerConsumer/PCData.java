package producerConsumer;

/**
 * 作为生产者和消费者之间的共享数据模型
 *
 * @author Zhang Yupeng
 * @since 2021/2/11
 */
public final class PCData {

    private final int intData;

    public PCData(int intData) {
        this.intData = intData;
    }

    public int getIntData() {
        return intData;
    }

    @Override
    public String toString() {
        return "PCData{" +
                "intData=" + intData +
                '}';
    }
}
package serialize;

import org.nustaq.serialization.FSTConfiguration;

/**
 * FST fast-serialization 是重新实现的Java快速对象序列化开发包
 * -序列化速度:快
 * -序列化文件大小:较大
 * -编程模型复杂度:非常简单
 *
 * @author zhangyupeng
 * @date 2019-04-24
 */
public class FstSerialize {

    private static FSTConfiguration configuration = FSTConfiguration.createDefaultConfiguration();

    public static byte[] serialize(Object obj) {
        return configuration.asByteArray(obj);
    }

    public static Object deserialize(byte[] bytes) {
        return configuration.asObject(bytes);
    }
}
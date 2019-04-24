package serialize;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

/**
 * Kryo序列化方式
 * -序列化速度:极快
 * -序列化文件大小:小
 * -编程模型复杂度:简单
 *
 * @author zhangyupeng
 * @date 2019-04-24
 */
public class KryoSerialize {

    private static Kryo kryo = new Kryo();

    public static byte[] serialize(Object obj) {
        byte[] buffer = new byte[2048];
        Output output = new Output(buffer);

        kryo.writeClassAndObject(output, obj);
        byte[] bytes = output.toBytes();
        output.close();
        return bytes;
    }

    public static Object deserialize(byte[] bytes) {
        Input input = new Input(bytes);
        Object obj = kryo.readClassAndObject(input);
        input.close();
        return obj;
    }
}
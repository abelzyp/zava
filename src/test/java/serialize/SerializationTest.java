package serialize;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.IOException;

/**
 * @author zhangyupeng
 * @date 2019-04-24
 */
@Slf4j
public class SerializationTest {

    private static final String TIME_AND_SIZE = "{}方式,序列化耗时:{}ms,序列化后大小:{}字符,反序列化耗时:{}ms.";

    @Test
    public void jdkSerializeTest() throws IOException, ClassNotFoundException {
        GoodsPrice goodsPrice = new SerializeModelBuilder().buildGoodsPrice();

        long start = System.currentTimeMillis();
        byte[] bytes = JdkSerialize.serialize(goodsPrice);
        long mid = System.currentTimeMillis();
        GoodsPrice deserialize = (GoodsPrice) JdkSerialize.deserialize(bytes);
        long end = System.currentTimeMillis();

        log.info(TIME_AND_SIZE, JdkSerialize.class.getSimpleName(), mid - start, bytes.length, end - mid);
    }

    @Test
    public void gsonSerialzeTest() {
        GoodsPrice goodsPrice = new SerializeModelBuilder().buildGoodsPrice();

        long start = System.currentTimeMillis();
        String serialize = GsonSerialize.serialize(goodsPrice);
        long mid = System.currentTimeMillis();
        GoodsPrice deserialize = (GoodsPrice) GsonSerialize.deserialize(serialize, GoodsPrice.class);
        long end = System.currentTimeMillis();

        log.info(TIME_AND_SIZE, GsonSerialize.class.getSimpleName(), mid - start, serialize.length(), end - mid);
    }

    @Test
    public void fastjsonSerializeTest() {
        GoodsPrice goodsPrice = new SerializeModelBuilder().buildGoodsPrice();

        long start = System.currentTimeMillis();
        String serialize = FastjsonSerialize.serialize(goodsPrice);
        long mid = System.currentTimeMillis();
        GoodsPrice deserialize = (GoodsPrice) FastjsonSerialize.deserialize(serialize, GoodsPrice.class);
        long end = System.currentTimeMillis();

        log.info(TIME_AND_SIZE, FastjsonSerialize.class.getSimpleName(), mid - start, serialize.length(), end - mid);
    }

    @Test
    public void jacksonSerializeTest() throws IOException {
        GoodsPrice goodsPrice = new SerializeModelBuilder().buildGoodsPrice();

        long start = System.currentTimeMillis();
        String serialize = JacksonSerialize.serialize(goodsPrice);
        long mid = System.currentTimeMillis();
        GoodsPrice deserialize = (GoodsPrice) JacksonSerialize.deserialize(serialize, GoodsPrice.class);
        long end = System.currentTimeMillis();

        log.info(TIME_AND_SIZE, JacksonSerialize.class.getSimpleName(), mid - start, serialize.length(), end - mid);
    }

    @Test
    public void fstSerializeTest() {
        GoodsPrice goodsPrice = new SerializeModelBuilder().buildGoodsPrice();

        long start = System.currentTimeMillis();
        byte[] bytes = FstSerialize.serialize(goodsPrice);
        long mid = System.currentTimeMillis();
        GoodsPrice deserialize = (GoodsPrice) FstSerialize.deserialize(bytes);
        long end = System.currentTimeMillis();

        log.info(TIME_AND_SIZE, FstSerialize.class.getSimpleName(), mid - start, bytes.length, end - mid);
    }

    @Test
    public void kryoSerializeTest() {
        GoodsPrice goodsPrice = new SerializeModelBuilder().buildGoodsPrice();

        long start = System.currentTimeMillis();
        byte[] bytes = KryoSerialize.serialize(goodsPrice);
        long mid = System.currentTimeMillis();
        GoodsPrice deserialize = (GoodsPrice) KryoSerialize.deserialize(bytes);
        long end = System.currentTimeMillis();

        log.info(TIME_AND_SIZE, KryoSerialize.class.getSimpleName(), mid - start, bytes.length, end - mid);
    }
}
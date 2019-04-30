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

    private static final String TIME_AND_SIZE = "{}方式,对象大小:{}字符,序列化耗时:{}ms,序列化后大小:{}字符,反序列化耗时:{}ms,反序列化后对象:{}";

    private static PoiGoodsPrice poiGoodsPrice = new SerializeModelBuilder().buildPoiGoodsPrice();

    @Test
    public void jdkSerializeTest() throws IOException, ClassNotFoundException {

        long start = System.currentTimeMillis();
        byte[] bytes = JdkSerialize.serialize(poiGoodsPrice);
        long mid = System.currentTimeMillis();
        PoiGoodsPrice deserialize = (PoiGoodsPrice) JdkSerialize.deserialize(bytes);
        long end = System.currentTimeMillis();

        log.info(TIME_AND_SIZE, JdkSerialize.class.getSimpleName(), poiGoodsPrice.toString().length(), mid - start, bytes.length, end - mid, deserialize);
    }

    @Test
    public void gsonSerialzeTest() {

        long start = System.currentTimeMillis();
        String serialize = GsonSerialize.serialize(poiGoodsPrice);
        long mid = System.currentTimeMillis();
        PoiGoodsPrice deserialize = (PoiGoodsPrice) GsonSerialize.deserialize(serialize, PoiGoodsPrice.class);
        long end = System.currentTimeMillis();

        log.info(TIME_AND_SIZE, GsonSerialize.class.getSimpleName(), poiGoodsPrice.toString().length(), mid - start, serialize.length(), end - mid, deserialize);
    }

    @Test
    public void fastjsonSerializeTest() {

        long start = System.currentTimeMillis();
        String serialize = FastjsonSerialize.serialize(poiGoodsPrice);
        long mid = System.currentTimeMillis();
        PoiGoodsPrice deserialize = (PoiGoodsPrice) FastjsonSerialize.deserialize(serialize, PoiGoodsPrice.class);
        long end = System.currentTimeMillis();

        log.info(TIME_AND_SIZE, FastjsonSerialize.class.getSimpleName(), poiGoodsPrice.toString().length(), mid - start, serialize.length(), end - mid, deserialize);
    }

    @Test
    public void jacksonSerializeTest() throws IOException {

        long start = System.currentTimeMillis();
        String serialize = JacksonSerialize.serialize(poiGoodsPrice);
        long mid = System.currentTimeMillis();
        PoiGoodsPrice deserialize = (PoiGoodsPrice) JacksonSerialize.deserialize(serialize, PoiGoodsPrice.class);
        long end = System.currentTimeMillis();

        log.info(TIME_AND_SIZE, JacksonSerialize.class.getSimpleName(), poiGoodsPrice.toString().length(), mid - start, serialize.length(), end - mid, deserialize);
    }

    @Test
    public void fstSerializeTest() {

        long start = System.currentTimeMillis();
        byte[] bytes = FstSerialize.serialize(poiGoodsPrice);
        long mid = System.currentTimeMillis();
        PoiGoodsPrice deserialize = (PoiGoodsPrice) FstSerialize.deserialize(bytes);
        long end = System.currentTimeMillis();

        log.info(TIME_AND_SIZE, FstSerialize.class.getSimpleName(), poiGoodsPrice.toString().length(), mid - start, bytes.length, end - mid, deserialize);
    }

    @Test
    public void kryoSerializeTest() {

        long start = System.currentTimeMillis();
        byte[] bytes = KryoSerialize.serialize(poiGoodsPrice);
        long mid = System.currentTimeMillis();
        PoiGoodsPrice deserialize = (PoiGoodsPrice) KryoSerialize.deserialize(bytes);
        long end = System.currentTimeMillis();

        log.info(TIME_AND_SIZE, KryoSerialize.class.getSimpleName(), poiGoodsPrice.toString().length(), mid - start, bytes.length, end - mid, deserialize);
    }

    @Test
    public void protostuffSerializeTest() {

        long start = System.currentTimeMillis();
        byte[] bytes = ProtostuffSerialize.serialize(poiGoodsPrice);
        long mid = System.currentTimeMillis();
        PoiGoodsPrice deserialize = ProtostuffSerialize.deserialize(bytes, PoiGoodsPrice.class);
        long end = System.currentTimeMillis();

        log.info(TIME_AND_SIZE, ProtostuffSerialize.class.getSimpleName(), poiGoodsPrice.toString().length(), mid - start, bytes.length, end - mid, deserialize);
    }
}
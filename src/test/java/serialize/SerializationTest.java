package serialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.IOException;

/**
 * @author zhangyupeng
 * @date 2019-04-24
 */
@Slf4j
public class SerializationTest {

    private static final String TIME_AND_SIZE = "{}方式,序列化耗时:{}ms,序列化后大小:{}字符.";

    @Test
    public void jdkSerializeTest() throws IOException {
        long start = System.currentTimeMillis();
        GoodsPrice goodsPrice = new SerializeModelBuilder().buildGoodsPrice();
        byte[] bytes = JdkSerialize.serialize(goodsPrice);
        long end = System.currentTimeMillis();
        log.info(TIME_AND_SIZE, JdkSerialize.class.getSimpleName(), end - start, bytes.length);
    }

    @Test
    public void gsonSerialzeTest() {
        long start = System.currentTimeMillis();
        GoodsPrice goodsPrice = new SerializeModelBuilder().buildGoodsPrice();
        String serialize = GsonSerialize.serialize(goodsPrice);
        long end = System.currentTimeMillis();
        log.info(TIME_AND_SIZE, GsonSerialize.class.getSimpleName(), end - start, serialize.length());
    }

    @Test
    public void fastjsonSerializeTest() {
        long start = System.currentTimeMillis();
        GoodsPrice goodsPrice = new SerializeModelBuilder().buildGoodsPrice();
        String serialize = FastjsonSerialize.serialize(goodsPrice);
        long end = System.currentTimeMillis();
        log.info(TIME_AND_SIZE, FastjsonSerialize.class.getSimpleName(), end - start, serialize.length());
    }

    @Test
    public void jacksonSerializeTest() throws JsonProcessingException {
        long start = System.currentTimeMillis();
        GoodsPrice goodsPrice = new SerializeModelBuilder().buildGoodsPrice();
        String serialize = JacksonSerialize.serialize(goodsPrice);
        long end = System.currentTimeMillis();
        log.info(TIME_AND_SIZE, JacksonSerialize.class.getSimpleName(), end - start, serialize.length());
    }

    @Test
    public void fstSerializeTest() {
        long start = System.currentTimeMillis();
        GoodsPrice goodsPrice = new SerializeModelBuilder().buildGoodsPrice();
        byte[] bytes = FstSerialize.serialize(goodsPrice);
        long end = System.currentTimeMillis();
        log.info(TIME_AND_SIZE, FstSerialize.class.getSimpleName(), end - start, bytes.length);
    }

    @Test
    public void kryoSerializeTest() {
        long start = System.currentTimeMillis();
        GoodsPrice goodsPrice = new SerializeModelBuilder().buildGoodsPrice();
        byte[] bytes = KryoSerialize.serialize(goodsPrice);
        long end = System.currentTimeMillis();
        log.info(TIME_AND_SIZE, KryoSerialize.class.getSimpleName(), end - start, bytes.length);
    }
}
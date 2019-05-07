package serialize;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.Triple;
import org.apache.lucene.util.RamUsageEstimator;
import org.junit.Test;
import serialize.model.PoiGoodsPrice;
import serialize.model.SerializeModelBuilder;
import serialize.size.ObjectSize;

import java.io.IOException;

/**
 * 普通测试方法,该类用来测试序列化后对象大小
 *
 * @author zhangyupeng
 * @date 2019-04-24
 */
@Slf4j
public class NormalSerializationTest {

    private static final String SIZE = "{}方式,序列化后大小:{}字节";

    private static PoiGoodsPrice poiGoodsPrice = new SerializeModelBuilder().buildPoiGoodsPrice();

    @Test
    public void objectSizeTest() {
        Triple<Long, Long, String> sizeTriple = ObjectSize.size(poiGoodsPrice);
        log.info("对象本身大小:{}字节,对象引用综合大小:{}字节,可读结果:{}", sizeTriple.getLeft(), sizeTriple.getMiddle(), sizeTriple.getRight());
    }

    @Test
    public void jdkSerializeTest() throws IOException, ClassNotFoundException {

        byte[] bytes = JdkSerialize.serialize(poiGoodsPrice);
        long size = RamUsageEstimator.sizeOf(bytes);
//        PoiGoodsPrice deserialize = (PoiGoodsPrice) JdkSerialize.deserialize(bytes);
        log.info(SIZE, JdkSerialize.class.getSimpleName(), size);
    }

    @Test
    public void gsonSerialzeTest() {

        String serialize = GsonSerialize.serialize(poiGoodsPrice);
        long size = RamUsageEstimator.sizeOf(serialize);
//        PoiGoodsPrice deserialize = (PoiGoodsPrice) GsonSerialize.deserialize(serialize, PoiGoodsPrice.class);
        log.info(SIZE, GsonSerialize.class.getSimpleName(), size);
    }

    @Test
    public void fastjsonSerializeTest() {

        String serialize = FastjsonSerialize.serialize(poiGoodsPrice);
        long size = RamUsageEstimator.sizeOf(serialize);
//        PoiGoodsPrice deserialize = (PoiGoodsPrice) FastjsonSerialize.deserialize(serialize, PoiGoodsPrice.class);
        log.info(SIZE, FastjsonSerialize.class.getSimpleName(), size);
    }

    @Test
    public void jacksonSerializeTest() throws IOException {

        String serialize = JacksonSerialize.serialize(poiGoodsPrice);
        long size = RamUsageEstimator.sizeOf(serialize);
//        PoiGoodsPrice deserialize = (PoiGoodsPrice) JacksonSerialize.deserialize(serialize, PoiGoodsPrice.class);
        log.info(SIZE, JacksonSerialize.class.getSimpleName(), size);
    }

    @Test
    public void fstSerializeTest() {

        byte[] bytes = FstSerialize.serialize(poiGoodsPrice);
        long size = RamUsageEstimator.sizeOf(bytes);
//        PoiGoodsPrice deserialize = (PoiGoodsPrice) FstSerialize.deserialize(bytes);
        log.info(SIZE, FstSerialize.class.getSimpleName(), size);
    }

    @Test
    public void kryoSerializeTest() {

        byte[] bytes = KryoSerialize.serialize(poiGoodsPrice);
        long size = RamUsageEstimator.sizeOf(bytes);
//        PoiGoodsPrice deserialize = (PoiGoodsPrice) KryoSerialize.deserialize(bytes);
        log.info(SIZE, KryoSerialize.class.getSimpleName(), size);
    }

    @Test
    public void protostuffSerializeTest() {

        byte[] bytes = ProtostuffSerialize.serialize(poiGoodsPrice);
        long size = RamUsageEstimator.sizeOf(bytes);
//        PoiGoodsPrice deserialize = ProtostuffSerialize.deserialize(bytes, PoiGoodsPrice.class);
        log.info(SIZE, ProtostuffSerialize.class.getSimpleName(), size);
    }
}
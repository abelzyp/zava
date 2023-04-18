package serialize;

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
public class NormalSerializationTest {

    private static final String SIZE = "%s方式,序列化后大小:%s字节";

    private static PoiGoodsPrice poiGoodsPrice = new SerializeModelBuilder().buildPoiGoodsPrice();

    @Test
    public void objectSizeTest() {
        Triple<Long, Long, String> sizeTriple = ObjectSize.size(poiGoodsPrice);
        System.out.println("对象本身大小:" + sizeTriple.getLeft() + "字节,对象引用综合大小:" + sizeTriple.getMiddle() + "字节,可读结果:" + sizeTriple.getRight());
    }

    @Test
    public void jdkSerializeTest() throws IOException, ClassNotFoundException {

        byte[] bytes = JdkSerialize.serialize(poiGoodsPrice);
        long size = RamUsageEstimator.sizeOf(bytes);
//        PoiGoodsPrice deserialize = (PoiGoodsPrice) JdkSerialize.deserialize(bytes);
        String sizeOut = String.format(SIZE, JdkSerialize.class.getSimpleName(), size);
        System.out.println(sizeOut);
    }

    @Test
    public void gsonSerialzeTest() {

        String serialize = GsonSerialize.serialize(poiGoodsPrice);
        long size = RamUsageEstimator.sizeOf(serialize.getBytes());
//        PoiGoodsPrice deserialize = (PoiGoodsPrice) GsonSerialize.deserialize(serialize, PoiGoodsPrice.class);
        String sizeOut = String.format(SIZE, GsonSerialize.class.getSimpleName(), size);
        System.out.println(sizeOut);
    }

    @Test
    public void fastjsonSerializeTest() {

        String serialize = FastjsonSerialize.serialize(poiGoodsPrice);
        long size = RamUsageEstimator.sizeOf(serialize.getBytes());
//        PoiGoodsPrice deserialize = (PoiGoodsPrice) FastjsonSerialize.deserialize(serialize, PoiGoodsPrice.class);
        String sizeOut = String.format(SIZE, FastjsonSerialize.class.getSimpleName(), size);
        System.out.println(sizeOut);
    }

    @Test
    public void jacksonSerializeTest() throws IOException {

        String serialize = JacksonSerialize.serialize(poiGoodsPrice);
        long size = RamUsageEstimator.sizeOf(serialize.getBytes());
//        PoiGoodsPrice deserialize = (PoiGoodsPrice) JacksonSerialize.deserialize(serialize, PoiGoodsPrice.class);
        String sizeOut = String.format(SIZE, JacksonSerialize.class.getSimpleName(), size);
        System.out.println(sizeOut);
    }

    @Test
    public void fstSerializeTest() {

        byte[] bytes = FstSerialize.serialize(poiGoodsPrice);
        long size = RamUsageEstimator.sizeOf(bytes);
//        PoiGoodsPrice deserialize = (PoiGoodsPrice) FstSerialize.deserialize(bytes);
        String sizeOut = String.format(SIZE, FstSerialize.class.getSimpleName(), size);
        System.out.println(sizeOut);
    }

    @Test
    public void kryoSerializeTest() {

        byte[] bytes = KryoSerialize.serialize(poiGoodsPrice);
        long size = RamUsageEstimator.sizeOf(bytes);
//        PoiGoodsPrice deserialize = (PoiGoodsPrice) KryoSerialize.deserialize(bytes);
        String sizeOut = String.format(SIZE, KryoSerialize.class.getSimpleName(), size);
        System.out.println(sizeOut);
    }

    @Test
    public void protostuffSerializeTest() {

        byte[] bytes = ProtostuffSerialize.serialize(poiGoodsPrice);
        long size = RamUsageEstimator.sizeOf(bytes);
//        PoiGoodsPrice deserialize = ProtostuffSerialize.deserialize(bytes, PoiGoodsPrice.class);
        String sizeOut = String.format(SIZE, ProtostuffSerialize.class.getSimpleName(), size);
        System.out.println(sizeOut);
    }
}
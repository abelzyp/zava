package serialize.size;

import org.apache.commons.lang3.tuple.Triple;
import org.apache.lucene.util.RamUsageEstimator;

/**
 * RamUsageEstimator 根据java对象在堆内存中的存储格式，
 * 通过计算Java对象头、实例数据、引用等的大小，相加而得，如果有引用，还能递归计算引用对象的大小。
 *
 * @author zhangyupeng
 * @date 2019-05-07
 */
public class ObjectSize {

    public static Triple<Long, Long, String> size(Object o) {
        //计算指定对象本身在堆空间的大小，单位字节
        long shallowSize = RamUsageEstimator.shallowSizeOf(o);
        //计算指定对象及其引用树上的所有对象的综合大小，单位字节
        long size = RamUsageEstimator.sizeOf(o);
        //计算指定对象及其引用树上的所有对象的综合大小，返回可读的结果，如：2KB
        String humanSize = RamUsageEstimator.humanSizeOf(o);
        return Triple.of(shallowSize, size, humanSize);
    }
}
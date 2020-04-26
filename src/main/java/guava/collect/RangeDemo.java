package guava.collect;

import com.google.common.collect.BoundType;
import com.google.common.collect.Range;

/**
 * @author Zhang Yupeng
 * @since 2020/4/26
 */
public class RangeDemo {

    public static Range<Integer> range(int checkIn, int checkOut) {
        return Range.range(checkIn, BoundType.CLOSED, checkOut, BoundType.OPEN);
    }
}
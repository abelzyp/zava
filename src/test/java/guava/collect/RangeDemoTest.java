package guava.collect;

import com.google.common.collect.Range;
import org.junit.Test;

/**
 * @author Zhang Yupeng
 * @since 2020/4/26
 */
public class RangeDemoTest {

    @Test
    public void range() {
        Range<Integer> range = RangeDemo.range(20200202, 20200219);
        System.out.println(range);
    }
}
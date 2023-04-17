package commons;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

import java.util.Arrays;

/**
 * 用于对数组的操作，如添加、查找、删除、子数组、倒序、元素类型转换等
 *
 * @author Abel
 * @date 2018/11/2
 */
public class ArrayUtilsTest {

    @Test
    public void test() {
        new ArrayUtils();

        Integer[] integers1 = new Integer[]{1, 3, 2, 5, 4, 5};
        Integer[] integers2 = null;
        System.out.println(ArrayUtils.toString(integers1));

        System.out.println(Arrays.toString(ArrayUtils.nullToEmpty(integers2)));

        //交换从offset1开始的len个元素与offset2开始的len个元素
        ArrayUtils.swap(integers1, 0, 3, 2);
        System.out.println(Arrays.toString(integers1));
    }
}
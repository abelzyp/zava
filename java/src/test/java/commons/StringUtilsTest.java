package commons;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * Apache Commons StringUtils
 * * 判空、缩写、首字母大写、重复字符串、判断组成结构、匹配次数、反转、大小写转换
 *
 * @author Abel
 * @date 2018/11/2
 */
public class StringUtilsTest {

    @Test
    public void test() {
        String s1 = null;
        String s2 = "";
        String s3 = " ";
        String s4 = "zhang yu peng is good";
        String s5 = "yu peng";

        Assert.assertTrue(StringUtils.isAllEmpty(s1));
        Assert.assertTrue(StringUtils.isAllEmpty(s2));
        Assert.assertFalse(StringUtils.isAllEmpty(s3));
        Assert.assertEquals(7, StringUtils.length(s5));

        System.out.println(StringUtils.abbreviate(s4, 9));
    }
}
package guava;

import com.google.common.base.Splitter;
import org.junit.Test;

/**
 * @author zhangyupeng
 * @date 2018/6/20
 */
public class SplitterTest {

    @Test
    public void splitterTest() {
        System.out.println(Splitter.on("-").limit(3).trimResults().split(" a-b-c-d"));
        System.out.println(Splitter.fixedLength(3).split("1 2 3 4 5 6 7 8 9"));
        System.out.println(Splitter.on(" ").omitEmptyStrings().splitToList("1  2 3"));
        System.out.println(Splitter.on(",").omitEmptyStrings().split("1,,,,2,,,3"));//[1, 2, 3]
        System.out.println(Splitter.on(" ").trimResults().split("1 2 3")); //[1, 2, 3],默认的连接符是,
        System.out.println(Splitter.on(";").withKeyValueSeparator(":").split("a:1;b:2;c:3"));
    }

    @Test
    public void splitToList() {
        String ages = "1,4,6";
        Splitter.on(",").omitEmptyStrings().splitToList(ages);

        System.out.println(Splitter.on("-").limit(3).trimResults().split(" a-b-c-d"));
    }
}
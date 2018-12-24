package guava.base;

import org.junit.Test;

import java.util.List;

/**
 * @author Abel
 * @date 2018-12-24
 */
public class SplitterUtilsTest {

    private static final String stringWithHyphen = " a-b-c-d";

    @Test
    public void splitStringWithSeparator() {
        List<String> stringList = SplitterUtils.splitStringWithSeparator(stringWithHyphen, "-");
        System.out.println(stringList);
    }
}
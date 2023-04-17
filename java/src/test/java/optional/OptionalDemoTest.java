package optional;

import org.junit.Test;

import java.util.Properties;

import static optional.OptionalDemo.readDuration;
import static org.junit.Assert.assertEquals;

/**
 * @author zhangyupeng
 * @date 2018/8/25
 */
public class OptionalDemoTest {

    @Test
    public void readDurationTest() {
        Properties props = new Properties();
        props.setProperty("a", "5");
        props.setProperty("b", "true");
        props.setProperty("c", "-1");

        assertEquals(5, readDuration(props, "a"));
        assertEquals(0, readDuration(props, "b"));
        assertEquals(0, readDuration(props, "c"));
        assertEquals(0, readDuration(props, "d"));
    }
}
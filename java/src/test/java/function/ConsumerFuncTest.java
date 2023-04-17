package function;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Abel
 * @date 2018/10/12
 */
public class ConsumerFuncTest {

    @Test
    public void forEach() {
        ConsumerFunc.forEach(Arrays.asList(1, 2, 3, 4, 5), System.out::println);
    }
}
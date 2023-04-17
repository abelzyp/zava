package function;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author Abel
 * @date 2018/10/12
 */
public class FunctionFuncTest {

    @Test
    public void map() {
        List<Integer> l = FunctionFunc.map(Arrays.asList("lambdas", "in", "action"), String::length);
        Assert.assertEquals("[7, 2, 6]", l.toString());
    }
}
package future;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Abel
 * @date 2018/10/16
 */
public class FutureExecutorTest {

    @Test
    public void futureExecutor() {
        Assert.assertEquals(4, new FutureExecutor().futureExecutor().intValue());
    }
}
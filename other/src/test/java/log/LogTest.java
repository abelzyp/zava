package log;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Zhang
 * @since 2023/4/17
 */
public class LogTest {


    private Logger logger = LoggerFactory.getLogger(LogTest.class);

    @Test
    public void logTest() {
        logger.info("======测试======");
    }
}

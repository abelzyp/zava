package gson;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

/**
 * @author zhangyupeng
 * @date 2018/6/7
 */
public class UserTest {

    /**
     * 测试lombok的@Builder注解
     */
    @Test
    public void userTest() {
        User user = User.builder()
                        .userId(200700036)
                        .userName("abel")
                        .password("123456")
                        .credits(5000)
                        .lastIp("127.0.0.1")
                        .lastVisit(new Date())
                        .build();
        Assert.assertEquals(200700036, user.getUserId());
    }
}
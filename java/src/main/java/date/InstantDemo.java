package date;

import java.time.Instant;
import java.time.temporal.ChronoField;

import static java.lang.System.out;

/**
 * @author zhangyupeng
 * @date 2018/8/18
 */
public class InstantDemo {
    public static void main(String[] args) {
        Instant instant = Instant.ofEpochSecond(3);
        out.println(instant);

        out.println(Instant.now().get(ChronoField.MICRO_OF_SECOND));
        //帮助你获取当前时刻的时间戳
        out.println(Instant.now());
    }
}
package date;

import java.time.LocalTime;
import java.time.temporal.ChronoField;

import static java.lang.System.out;

/**
 * @author zhangyupeng
 * @date 2018/8/18
 */
public class LocalTimeDemo {
    public static void main(String[] args) {
        LocalTime time = LocalTime.of(15, 25, 26, 256);
        out.println(time.getHour());
        out.println(time.getMinute());
        out.println(time.getSecond());

        out.println(LocalTime.now());

        out.println(time.get(ChronoField.HOUR_OF_AMPM));
        out.println(time.get(ChronoField.HOUR_OF_DAY));
        out.println(time.get(ChronoField.MINUTE_OF_DAY));
        out.println(time.get(ChronoField.SECOND_OF_DAY));

        out.println(LocalTime.parse("16:26:27"));
    }
}
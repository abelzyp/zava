package date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static java.lang.System.out;

/**
 * {@link LocalDateTimeDemo}和{@link LocalDateDemo}、{@link LocalTimeDemo}之间可以互转
 * 通过 {@link LocalDateTime#toLocalDate()}或者{@link LocalDateTime#toLocalTime()}
 *
 * @author zhangyupeng
 * @date 2018/8/18
 */
public class LocalDateTimeDemo {
    public static void main(String[] args) {
        LocalDateTime dateTime1 = LocalDateTime.of(2018, 8, 18, 0, 35, 26);
        out.println(dateTime1);

        out.println("==========");

        LocalDateTime dateTime2 = LocalDateTime.of(LocalDate.now(), LocalTime.of(23, 59, 59));
        out.println(dateTime2);
    }
}
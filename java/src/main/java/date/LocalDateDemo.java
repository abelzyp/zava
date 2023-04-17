package date;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoField;

import static java.lang.System.out;

/**
 * 通过{@link LocalDate#atTime(LocalTime)}可以转{@link java.time.LocalDateTime}
 *
 * @author zhangyupeng
 * @date 2018/8/18
 */
public class LocalDateDemo {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2018, 8, 18);
        out.println(date.getYear());
        out.println(date.getMonthValue());
        out.println(date.getDayOfMonth());
        out.println(date.isLeapYear());

        out.println(LocalDate.now());

        out.println(date.get(ChronoField.YEAR));
        out.println(date.get(ChronoField.MONTH_OF_YEAR));
        out.println(date.get(ChronoField.DAY_OF_MONTH));

        out.println(LocalDate.parse("2018-08-08"));
    }
}
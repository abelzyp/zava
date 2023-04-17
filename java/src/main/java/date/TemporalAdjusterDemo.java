package date;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static java.time.temporal.TemporalAdjusters.*;

/**
 * @author zhangyupeng
 * @date 2018/8/19
 */
public class TemporalAdjusterDemo {
    public static void main(String[] args) {
        LocalDate date1 = LocalDate.now();
        LocalDate date2 = date1.with(nextOrSame(DayOfWeek.SUNDAY));
        LocalDate date3 = date2.with(lastDayOfMonth());
        System.out.println(date3);

        LocalDate date4 = LocalDate.now();
        LocalDate date5 = date4.with(dayOfWeekInMonth(2, DayOfWeek.FRIDAY));
        System.out.println(date5);

        LocalDate nextWorkingDay = date4.with(new NextWorkingDay());
        System.out.println(nextWorkingDay);
    }
}
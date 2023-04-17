package date;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * Duration用于以秒和纳秒衡量时间长短
 * Period用于以年、月、日方式对时间建模
 *
 * @author zhangyupeng
 * @date 2018/8/19
 */
public class DurationAndPeriodDemo {
    public static void main(String[] args) {
        //构建Period的几种方式
        Period lifeLong = Period.between(LocalDate.of(1992, 3, 1), LocalDate.now());
        System.out.println(lifeLong);

        Period tenDays = Period.ofDays(10);
        System.out.println(tenDays);

        Period twoYearsSixMonthsOneDay = Period.of(2, 6, 1);
        System.out.println(twoYearsSixMonthsOneDay);


        //构建Duration的几种方式
        Duration lifeLongLong = Duration.between(LocalTime.of(1, 50, 3), LocalTime.now());
        System.out.println(lifeLongLong.toString());

        Duration threeMinutes = Duration.ofMinutes(3);
        System.out.println(threeMinutes);

        Duration fourMinutes = Duration.of(4, ChronoUnit.MINUTES);
        System.out.println(fourMinutes);
    }
}
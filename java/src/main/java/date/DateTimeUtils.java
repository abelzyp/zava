package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 工具类
 *
 * @author Abel
 * @date 2018/10/23
 */
class DateTimeUtils {

    /**
     * @param yyyyMmDd yyyyMmDd格式日期，例如20180808
     * @return 转指定日期为LocalDate
     */
    static LocalDate parseYyyyMmDdToLocalDate(String yyyyMmDd) {
        Objects.requireNonNull(yyyyMmDd, "yyyyMmDd");
        DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;
        return LocalDate.parse(yyyyMmDd, formatter);
    }

    /**
     * @param yyyyMmDd yyyyMmDd格式日期，例如20180808
     * @return 转换指定日期为Date格式
     * @throws ParseException 类型转换异常
     */
    static Date parseYyyyMmDdToDate(String yyyyMmDd) throws ParseException {
        Objects.requireNonNull(yyyyMmDd);
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        return format.parse(yyyyMmDd);
    }

    /**
     * @param localDate localDate
     * @return 转换LocalDate为yyyyMMdd格式
     */
    static String parseLocalDateToYyyyMmDd(LocalDate localDate) {
        Objects.requireNonNull(localDate);
        return localDate.format(DateTimeFormatter.BASIC_ISO_DATE);
    }

    /**
     * 当前日期与给定日期的间隔天数
     *
     * @param endDate 指定日期
     * @return 间隔天数
     */
    static long intervalLocalDate(LocalDate endDate) {
        return Math.abs(LocalDate.now().until(endDate, ChronoUnit.DAYS));
    }

    /**
     * 当前日期与给定日期的间隔天数
     *
     * @param yyyyMMdd 指定日期
     * @return 间隔天数
     */
    static long intervalLocalDate(String yyyyMMdd) {
        DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;
        LocalDate thatDay = LocalDate.parse(yyyyMMdd, formatter);
        return intervalLocalDate(thatDay);
    }

    /**
     * 两个日期的间隔天数
     *
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @return 间隔天数
     */
    static long intervalLocalDate(LocalDate startDate, LocalDate endDate) {
        return Math.abs(startDate.until(endDate, ChronoUnit.DAYS));
    }

    /**
     * 两个Date类型日期的间隔天数
     *
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @return 间隔天数
     */
    static long intervalDate(Date startDate, Date endDate) {
        LocalDate startLocalDate = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate endLocalDate = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return intervalLocalDate(startLocalDate, endLocalDate);
    }

    /**
     * 计算两个yyyyMMdd格式日期的间隔天数
     *
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @return 间隔天数
     */
    static long intervalYyyyMmDd(String startDate, String endDate) {
        DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;
        LocalDate startLocalDate = LocalDate.parse(startDate, formatter);
        LocalDate endLocalDate = LocalDate.parse(endDate, formatter);
        return intervalLocalDate(startLocalDate, endLocalDate);
    }

    /**
     * @param startDate 开始日期,yyyyMMdd格式
     * @param endDate   结束日期,yyyyMMdd格式
     * @return 遍历开始日期和结束日期, 包含开始日期和结束日期
     */
    static List<String> traversingTwoYyyyMmDd(String startDate, String endDate) {
        LocalDate startLocalDate = parseYyyyMmDdToLocalDate(startDate);
        LocalDate endLocalDate = parseYyyyMmDdToLocalDate(endDate);

        long traverse = ChronoUnit.DAYS.between(startLocalDate, endLocalDate);
        if (traverse < 1) {
            return new ArrayList<>();
        }
        return Stream.iterate(startLocalDate, d -> d.plusDays(1))
                //这里可以调整是否包含结束日期
                .limit(traverse + 1)
                .map(DateTimeUtils::parseLocalDateToYyyyMmDd)
                .collect(Collectors.toList());
    }

    /**
     * 获取基于当前日期的昨日日期
     *
     * @return 昨日日期，yyyyMMdd格式
     */
    public static String getYesterdayYyyyMMdd() {
        return LocalDate.now().minusDays(1L).format(DateTimeFormatter.BASIC_ISO_DATE);
    }
}
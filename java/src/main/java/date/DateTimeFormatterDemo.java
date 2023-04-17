package date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 所有的DateTimeFormatter实例都线程安全
 *
 * @author zhangyupeng
 * @date 2018/8/20
 */
public class DateTimeFormatterDemo {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        String s1 = date.format(DateTimeFormatter.BASIC_ISO_DATE);
        String s2 = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(s1);
        System.out.println(s2);

        LocalDate date1 = LocalDate.parse("20180820", DateTimeFormatter.BASIC_ISO_DATE);
        LocalDate date2 = LocalDate.parse("2018-08-20", DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(date1);
        System.out.println(date2);

        //按某个模式创建DateTimeFormatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = LocalDate.now().format(formatter);
        System.out.println(formattedDate);
    }
}
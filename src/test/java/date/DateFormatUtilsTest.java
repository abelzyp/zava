package date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * Apache Commons lang3 日期测试
 *
 * @author zhangyupeng
 * @date 2019/11/25
 */
public class DateFormatUtilsTest {

    @Test
    public void test() {
        String yyyyMMdd = getNextDate(3, "yyyyMMdd");
        System.out.println(yyyyMMdd);
    }

    private String getNextDate(int days, String format) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, days);
        Date date = cal.getTime();
        return DateFormatUtils.format(date, format);
    }
}
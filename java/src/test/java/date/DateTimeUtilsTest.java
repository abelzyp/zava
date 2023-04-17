package date;

import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * @author Abel
 * @date 2018/10/23
 */
public class DateTimeUtilsTest {

    private String yyyyMmDd1 = "20080808";
    private String yyyyMmDd2 = "20150202";

    private long interval = 2369;
    private LocalDate localDate1 = DateTimeUtils.parseYyyyMmDdToLocalDate(yyyyMmDd1);
    private LocalDate localDate2 = DateTimeUtils.parseYyyyMmDdToLocalDate(yyyyMmDd2);
    private Date date1 = DateTimeUtils.parseYyyyMmDdToDate(yyyyMmDd1);
    private Date date2 = DateTimeUtils.parseYyyyMmDdToDate(yyyyMmDd2);

    public DateTimeUtilsTest() throws ParseException {
    }

    @Test
    public void parseYyyyMmDdToLocalDateTest() {
        Assert.assertEquals(localDate1, DateTimeUtils.parseYyyyMmDdToLocalDate(yyyyMmDd1));
    }

    @Test
    public void parseLocalDateToYyyyMmDdTest() {
        Assert.assertEquals(yyyyMmDd1, DateTimeUtils.parseLocalDateToYyyyMmDd(localDate1));
    }

    @Test
    public void intervalLocalDateTest() {
        Assert.assertEquals(DateTimeUtils.intervalLocalDate(localDate1), DateTimeUtils.intervalLocalDate(yyyyMmDd1));
        Assert.assertEquals(interval, DateTimeUtils.intervalLocalDate(localDate1, localDate2));
    }

    @Test
    public void intervalDateTest() {
        Assert.assertEquals(interval, DateTimeUtils.intervalDate(date1, date2));
    }

    @Test
    public void intervalYyyyMmDdTest() {
        Assert.assertEquals(interval, DateTimeUtils.intervalYyyyMmDd(yyyyMmDd1, yyyyMmDd2));
    }

    @Test
    public void traversingTwoYyyyMmDdTest() {
        List<String> traversingList = DateTimeUtils.traversingTwoYyyyMmDd(yyyyMmDd1, yyyyMmDd2);
        Assert.assertEquals(2370, traversingList.size());
    }

    @Test
    public void getYesterdayYyyyMMddTest() {
        String yesterdayYyyyMMdd = DateTimeUtils.getYesterdayYyyyMMdd();
        System.out.println(yesterdayYyyyMMdd);
    }
}

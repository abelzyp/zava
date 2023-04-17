package date;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

/**
 * @author zhangyupeng
 * @date 2018/8/25
 */
public class NextWorkingDayTest {

    @Test
    public void getNextWorkingDay() {
        LocalDate date20180824 = LocalDate.of(2018, 8, 24);
        LocalDate realNextWorkingDay = date20180824.with(new NextWorkingDay());
        LocalDate expectedNextWorkingDay = LocalDate.of(2018, 8, 27);
        Assert.assertEquals(expectedNextWorkingDay, realNextWorkingDay);
    }
}
package serialize;

import com.google.common.collect.Lists;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author zhangyupeng
 * @date 2019-04-24
 */
public class SerializeModelBuilder {

    public GoodsPrice buildGoodsPrice() {
        return GoodsPrice.builder()
                .goodsId(395529380)
                .partnerId(445265172)
                .goodsPriceCalendarList(build30PriceCalendar())
                .surcharge(500_00)
                .grossProfit(100_00)
                .goodsName("产品")
                .build();
    }

    private List<GoodsPriceCalendar> build30PriceCalendar() {
        List<GoodsPriceCalendar> list = Lists.newArrayList();
        IntStream.rangeClosed(1, 30)
                .forEach(value -> list.add(buildGoodsPriceCalendar()));
        return list;
    }

    private GoodsPriceCalendar buildGoodsPriceCalendar() {
        return GoodsPriceCalendar.builder()
                .date(LocalDate.now().getDayOfYear())
                .salePrice(1000_00)
                .originPrice(1000_00)
                .basePrice(900_00)
                .subPrice(500_00)
                .subRatio(50)
                .inventory(27)
                .build();
    }
}
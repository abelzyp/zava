package serialize.model;

import org.apache.commons.compress.utils.Lists;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author zhangyupeng
 * @date 2019-04-24
 */
public class SerializeModelBuilder {

    /**
     * 构造1个poi下10个产品，每个产品包含5天价格日历
     */
    public PoiGoodsPrice buildPoiGoodsPrice() {
        return PoiGoodsPrice.builder()
                .poiId(395529)
                .goodsPriceList(buildGoodsPriceList())
                .build();
    }

    private List<GoodsPrice> buildGoodsPriceList() {
        List<GoodsPrice> list = Lists.newArrayList();
        IntStream.rangeClosed(1, 10)
                .forEach(value -> list.add(buildGoodsPrice()));
        return list;
    }

    private GoodsPrice buildGoodsPrice() {
        return GoodsPrice.builder()
                .goodsId(395529380)
                .partnerId(445265172)
                .goodsPriceCalendarList(buildPriceCalendarList())
                .surcharge(500_00)
                .grossProfit(100_00)
                .goodsName("产品")
                .build();
    }

    private List<GoodsPriceCalendar> buildPriceCalendarList() {
        List<GoodsPriceCalendar> list = Lists.newArrayList();
        IntStream.rangeClosed(1, 5)
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
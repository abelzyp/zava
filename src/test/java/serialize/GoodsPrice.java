package serialize;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @author zhangyupeng
 * @date 2019-04-24
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class GoodsPrice implements Serializable {

    private static final long serialVersionUID = 8252570977670817713L;

    /**
     * goodsId
     */
    private long goodsId;

    /**
     * 供应商Id
     */
    private int partnerId;

    /**
     * 价格日历
     */
    private List<GoodsPriceCalendar> goodsPriceCalendarList;

    /**
     * 总税费
     */
    private int surcharge;

    /**
     * 总卖价模式佣金
     */
    private int grossProfit;

    /**
     * 产品名称
     */
    private String goodsName;
}
package serialize;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author zhangyupeng
 * @date 2019-04-24
 */
@Getter
@Setter
@Builder
public class GoodsPriceCalendar implements Serializable {

    private static final long serialVersionUID = -1479984063603041294L;

    /**
     * 价格日期，格式为yyyyMMdd
     */
    private int date;

    /**
     * 产品原始卖价
     */
    private int salePrice;

    /**
     * 原价
     */
    private int originPrice;

    /**
     * 底价
     */
    private int basePrice;

    /**
     * 底价模式佣金
     */
    private int subPrice;

    /**
     * 低价模式佣金比
     */
    private int subRatio;

    /**
     * 库存
     */
    private int inventory;
}
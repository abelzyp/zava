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
 * @date 2019-04-29
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class PoiGoodsPrice implements Serializable {

    private static final long serialVersionUID = -4262490958130325266L;
    /**
     * poiId
     */
    private int poiId;

    /**
     * 产品列表
     */
    private List<GoodsPrice> goodsPriceList;
}
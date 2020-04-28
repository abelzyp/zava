package lombok;

import lombok.experimental.Accessors;

/**
 * @author Zhang Yupeng
 * @since 2020/4/28
 */
@Setter
@Getter
@Accessors(chain = true)
public class AccessorsDemo {

    private int a;
    private String b;
}
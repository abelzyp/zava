package optional.util;

import java.util.Optional;

/**
 * @author zhangyupeng
 * @date 2018/8/25
 */
public class OptionalUtility {

    /**
     * 这个工具把老的parseInt方法返回值包Optional
     */
    public static Optional<Integer> stringToInt(String s) {
        try {
            return Optional.of(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }
}
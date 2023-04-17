package optional;

import optional.util.OptionalUtility;

import java.util.Optional;
import java.util.Properties;

/**
 * @author zhangyupeng
 * @date 2018/8/25
 */
class OptionalDemo {

    /**
     * Optional组合用法
     * 实现一个传递属性，测试String转int获取结果值
     */
    static int readDuration(Properties props, String name) {
        return Optional.ofNullable(props.getProperty(name))
                       .flatMap(OptionalUtility::stringToInt)
                       .filter(i -> i > 0)
                       .orElse(0);
    }
}
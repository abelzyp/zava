package function;

import java.util.List;
import java.util.function.Consumer;

/**
 * @author Abel
 * @date 2018/10/12
 */
class ConsumerFunc {

    static <T> void forEach(List<T> list, Consumer<T> c) {
        for (T i : list) {
            c.accept(i);
        }
    }
}
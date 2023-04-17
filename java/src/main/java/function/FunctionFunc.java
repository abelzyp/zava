package function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @author Abel
 * @date 2018/10/12
 */
public class FunctionFunc {

    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for (T s : list) {
            result.add(f.apply(s));
        }
        return result;
    }
}
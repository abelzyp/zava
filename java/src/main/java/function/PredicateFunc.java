package function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author Abel
 * @date 2018/10/12
 */
public class PredicateFunc {

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> results = new ArrayList<>();
        for (T s : list) {
            if (p.test(s)) {
                results.add(s);
            }
        }
        return results;
    }
}
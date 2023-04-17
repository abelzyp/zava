package optional;

import java.util.Optional;
import java.util.function.Function;

/**
 * {@link java.util.Optional#map(Function)}和{@link java.util.Optional#flatMap(Function)}的区别
 * https://stackoverflow.com/a/30864741/6745783
 *
 * @author zhangyupeng
 * @date 2018/8/23
 */
public class MapAndFlatMapDemo {
    public static void main(String[] args) {
        Optional<String> s = Optional.of("input");
        System.out.println(s.map(MapAndFlatMapDemo::getOutput));
        System.out.println(s.flatMap(MapAndFlatMapDemo::getOutputOpt));
    }

    private static Optional<String> getOutputOpt(String input) {
        return input == null ? Optional.empty() : Optional.of("output for " + input);
    }

    private static String getOutput(String input) {
        return input == null ? null : "output for " + input;
    }
}
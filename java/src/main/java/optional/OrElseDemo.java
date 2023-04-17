package optional;

import java.util.Optional;

/**
 * https://stackoverflow.com/q/33170109/6745783
 *
 * @author zhangyupeng
 * @date 2018/8/23
 */
public class OrElseDemo {
    public static void main(String[] args) {
        System.out.println(Optional.of("A").orElse(B()));
        System.out.println(Optional.of("A").orElseGet(() -> B()));
    }

    private static String B() {
        System.out.println("B()...");
        return "B";
    }
}
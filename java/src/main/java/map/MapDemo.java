package map;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * @author zhangyupeng
 * @date 2018/8/18
 */
public class MapDemo {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>(10);
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.put(4, 4);
        map.put(5, 5);
        System.out.println(map);

        IntStream.range(0, 10)
                 .forEach(i -> map.computeIfAbsent(i, MapDemo::absentCompute));

        System.out.println(map);

    }

    private static Integer absentCompute(Integer key) {
        return (int) Math.pow(key, 2);
    }
}
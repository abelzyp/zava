package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhangyupeng
 * @date 2018/8/26
 */
public class StreamDemo {

    /**
     * 两个数字列表，返回所有数对
     */
    public static void main(String[] args) {
        List<Integer> num1 = Arrays.asList(1, 2, 3);
        List<Integer> num2 = Arrays.asList(3, 4);

        List<int[]> listArray = num1.stream()
                                    .flatMap(i -> num2.stream().map(j -> new int[]{i, j}))
                                    .collect(Collectors.toList());
        listArray.forEach(ints -> System.out.print(Arrays.toString(ints)));
    }
}
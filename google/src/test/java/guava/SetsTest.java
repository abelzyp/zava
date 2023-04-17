package guava;

import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.Set;

/**
 * 交集、差集、并集
 *
 * @author zhangyupeng
 * @date 2018/6/20
 */
public class SetsTest {

    @Test
    public void test() {
        Set<Integer> set1 = Sets.newHashSet(1, 2, 3, 4, 5);
        Set<Integer> set2 = Sets.newHashSet(3, 4, 5, 6);
        Sets.SetView<Integer> inter = Sets.intersection(set1, set2); //交集
        System.out.println(inter);
        Sets.SetView<Integer> diff = Sets.difference(set1, set2); //差集,在A中不在B中
        System.out.println(diff);
        Sets.SetView<Integer> union = Sets.union(set1, set2); //并集
        System.out.println(union);
    }
}
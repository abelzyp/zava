package guava;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author zhangyupeng
 * @date 2018/6/20
 */
public class ImmutableTest {

    @Test
    public void test() {
        ImmutableSet<Integer> set1 = ImmutableSet.of(1, 2, 3, 4, 5);
        ImmutableSet<Integer> set2 = ImmutableSet.copyOf(set1);
        ImmutableSet<Integer> set3 = set1;
        Assert.assertEquals(set1, set2);
        Assert.assertEquals(set1, set3);
        System.out.println(set1.hashCode());
        System.out.println(set2.hashCode());
        System.out.println(set3.hashCode());

        ImmutableSet<Integer> set4 = ImmutableSet.<Integer>builder().addAll(set1).add(666).build();
        ImmutableList<Integer> set5 = set1.asList();
        System.out.println(set4);
    }
}
package guava;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import org.junit.Test;

/**
 * 允许重复，但是不保证顺序
 *
 * @author zhangyupeng
 * @date 2018/6/20
 */
public class MultisetTest {

    @Test
    public void test() {
        Multiset<String> set = HashMultiset.create();
        set.add("a");
        set.add("a");
        set.add("a");
        set.add("b");
        set.add("b");
        System.out.println(set);
        //所有元素计数的总和,包括重复元素
        System.out.println(set.size());
        //所有元素计数的总和,不包括重复元素
        System.out.println(set.elementSet().size());


        //添加或删除指定元素使其在集合中的数量是count
        System.out.println(set.setCount("c", 4));

        System.out.println(set);
        System.out.println(set.size());

        //给定元素在Multiset中的计数
        System.out.println(set.count("a"));

        //清空集合
        set.clear();
        System.out.println(set);
    }
}
package guava;

import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import org.junit.Test;

import java.util.List;

/**
 * 常见的静态方法：
 * 　　natural()：使用Comparable类型的自然顺序，例如：整数从小到大，字符串是按字典顺序;
 * 　　usingToString()：使用toString()返回的字符串按字典顺序进行排序；
 * 　　arbitrary()：返回一个所有对象的任意顺序，即compare(a,b) == 0 就是 a == b (identity equality)。本身的排序是没有任何含义，但是在VM的生命周期是一个常量。
 * 　　reverse(): 返回与当前Ordering相反的排序:
 * 　　nullsFirst(): 返回一个将null放在non-null元素之前的Ordering，其他的和原始的Ordering一样；
 * 　　nullsLast()：返回一个将null放在non-null元素之后的Ordering，其他的和原始的Ordering一样；
 * 　　compound(Comparator)：返回一个使用Comparator的Ordering，Comparator作为第二排序元素，例如对bug列表进行排序，先根据bug的级别，再根据优先级进行排序；
 * 　　lexicographical()：返回一个按照字典元素迭代的Ordering；
 * 　　onResultOf(Function)：将function应用在各个元素上之后, 在使用原始ordering进行排序；
 * 　　greatestOf(Iterable iterable, int k)：返回指定的第k个可迭代的最大的元素，按照这个从最大到最小的顺序。是不稳定的。
 * 　　leastOf(Iterable<E> iterable,int k)：返回指定的第k个可迭代的最小的元素，按照这个从最小到最大的顺序。是不稳定的。
 * 　　isOrdered(Iterable)：是否有序，Iterable不能少于2个元素。
 * 　　isStrictlyOrdered(Iterable)：是否严格有序。请注意，Iterable不能少于两个元素。
 * 　　sortedCopy(Iterable)：返回指定的元素作为一个列表的排序副本。
 *
 * @author zhangyupeng
 * @date 2018/6/21
 */
public class OrderingTest {

    @Test
    public void orderingTest() {
        List<String> list = Lists.newArrayList();
        list.add("peida");
        list.add("jerry");
        list.add("harry");
        list.add("eva");
        list.add("john");
        list.add("neron");

        System.out.println(list);

        Ordering<String> naturalOrdering = Ordering.natural();
        Ordering<Object> usingToStringOrdering = Ordering.usingToString();
        Ordering<Object> arbitraryOrdering = Ordering.arbitrary();

        System.out.println("naturalOrdering:" + naturalOrdering.sortedCopy(list));
        System.out.println("usingToStringOrdering:" + usingToStringOrdering.sortedCopy(list));
        System.out.println("arbitraryOrdering:" + arbitraryOrdering.sortedCopy(list));
    }
}
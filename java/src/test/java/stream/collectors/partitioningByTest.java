package stream.collectors;

import org.junit.Test;
import stream.util.Dish;
import stream.util.Menu;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author zhangyupeng
 * @date 2018/9/13
 */
public class partitioningByTest {

    /**
     * 分区是分组的特殊情况,谓词为分区函数,返回一个bool值
     */
    @Test
    public void test() {
        Map<Boolean, List<Dish>> partitionedMenu = Menu.menu.stream()
                                                            .collect(Collectors.partitioningBy(Dish::isVegetarian));
        System.out.println(partitionedMenu);
    }

    /**
     * partitioningBy重载版本,传递两个收集器
     */
    @Test
    public void test2() {
        Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianDishesByType = Menu.menu.stream()
                                                                                   .collect(Collectors.partitioningBy(Dish::isVegetarian, Collectors.groupingBy(Dish::getType)));
        System.out.println(vegetarianDishesByType);
    }

    /**
     * collectingAndThen
     */
    @Test
    public void test3() {
        Map<Boolean, Dish> mostCaloricPartitionedByVegetarian = Menu.menu.stream()
                                                                         .collect(Collectors.partitioningBy(Dish::isVegetarian,
                                                                                                            Collectors.collectingAndThen(
                                                                                                                    Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)),
                                                                                                                    Optional::get)));
        System.out.println(mostCaloricPartitionedByVegetarian);

    }
}
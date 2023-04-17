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
 * @date 2018/9/11
 */
public class GroupingByTest {

    /**
     * groupingBy接收一个 分类函数
     */
    @Test
    public void test() {
        Map<Dish.Type, List<Dish>> dishesByType = Menu.menu.stream()
                                                           .collect(Collectors.groupingBy(Dish::getType));
        System.out.println(dishesByType);
    }

    /**
     * 自定义分组
     */
    @Test
    public void groupingByTest() {
        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = Menu.menu.stream()
                                                                      .collect(Collectors.groupingBy(dish -> {
                                                                          if (dish.getCalories() <= 400) {
                                                                              return CaloricLevel.DIET;
                                                                          } else if (dish.getCalories() <= 700) {
                                                                              return CaloricLevel.NORMAL;
                                                                          } else {
                                                                              return CaloricLevel.FAT;
                                                                          }
                                                                      }));
        System.out.println(dishesByCaloricLevel);
    }

    /**
     * 多级分组
     * 把第二个收集器传递给外层收集器实现
     */
    @Test
    public void groupingByGroupingByTest() {
        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel = Menu.menu.stream()
                                                                                          .collect(Collectors.groupingBy(Dish::getType, Collectors.groupingBy(dish -> {
                                                                                              if (dish.getCalories() <= 300) {
                                                                                                  return CaloricLevel.DIET;
                                                                                              } else if (dish.getCalories() <= 600) {
                                                                                                  return CaloricLevel.NORMAL;
                                                                                              } else {
                                                                                                  return CaloricLevel.FAT;
                                                                                              }
                                                                                          })));
        System.out.println(dishesByTypeCaloricLevel);
    }

    @Test
    public void collectingAndThenTest() {
        Map<Dish.Type, Dish> mostCaloricByType = Menu.menu.stream()
                                                          .collect(Collectors.groupingBy(Dish::getType, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)));
        System.out.println(mostCaloricByType);
    }

    public enum CaloricLevel {
        DIET, NORMAL, FAT
    }
}
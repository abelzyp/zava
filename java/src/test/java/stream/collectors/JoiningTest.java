package stream.collectors;

import org.junit.Assert;
import org.junit.Test;
import stream.util.Dish;
import stream.util.Menu;

import java.util.stream.Collectors;

/**
 * @author zhangyupeng
 * @date 2018/9/11
 */
public class JoiningTest {

    /**
     * joining 3个重载方法
     * 1.{@link Collectors#joining()}
     * 2.{@link Collectors#joining(CharSequence)}
     * 3.{@link Collectors#joining(CharSequence, CharSequence, CharSequence)}
     */
    @Test
    public void joiningTest() {
        String shortMenu = Menu.menu.stream().map(Dish::getName).collect(Collectors.joining(","));
        String menuString = "pork,beef,chicken,french fries,rice,season fruit,pizza,prawns,salmon";
        Assert.assertEquals(shortMenu, menuString);
    }
}
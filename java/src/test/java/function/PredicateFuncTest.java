package function;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author Abel
 * @date 2018/10/12
 */
public class PredicateFuncTest {

    @Test
    public void filter() {
        List<String> listOfStrings = new ArrayList<>(Arrays.asList("abel", "", "zhang"));
        Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
        List<String> nonEmptyStringList = PredicateFunc.filter(listOfStrings, nonEmptyStringPredicate);
        System.out.println(nonEmptyStringList);
    }
}
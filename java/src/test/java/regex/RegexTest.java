package regex;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Zhang Yupeng
 * @since 2022/8/2
 */
public class RegexTest {

    @Test
    public void test() {
        String expression = "-40+(-6-4)+-2-91";
        //断言数字左边为符号，符号-会出现0次或1次，再出现数字至少一次的数字
        //或者以符号-开头，后面是数字
        String reg = "((?<=\\(|-|\\+|/|\\*)-?\\d+)|(^-[0-9]+)";
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(expression);

        while (m.find()) {
            System.out.println(m.group());
        }
    }
}

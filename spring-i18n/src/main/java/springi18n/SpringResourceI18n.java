package springi18n;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.Locale;

/**
 * @author Zhang
 * @since 2023/5/13
 */
public class SpringResourceI18n {

    public static String getSpringResourceI18n(Object[] objs, Locale locale) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean_resource.xml");
        //springResource为资源文件的key值
        //objs为资源文件value值所需要的参数
        //Locale.CHINA为国际化的语言
        return context.getMessage("springResource", objs, locale);
    }

    public static void main(String[] args) {
        //传递动态参数，使用数组形式对应{0}{1}顺序
        Object[] objs1 = {"ChinaBape", new Date().toString()};
        System.out.println(getSpringResourceI18n(objs1, Locale.CHINA));

        Object[] objs2 = {"UsBape", new Date().toString()};
        System.out.println(getSpringResourceI18n(objs2, Locale.US));
    }
}

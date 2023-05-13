package javai18n;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Locale用于指定当前用户所属的语言环境信息，包含了language和country信息
 * ResourceBundle用于查找绑定对应的资源文件
 * <p>
 * 配置文件命名规则：basename_language_country.properties，必须遵循以上命名规则Java才会识别。
 * 其中，basename是必须的，语言和国家是可选的。
 * 这里存在优先级概念，如果同时提供messages.properties和messages_zh_CN.properties两个配置文件，
 * 若提供的locale符合zh_CN，则优先查找messages_zh_CN.properties配置文件，若没查到再查找messages.properties文件。
 * <p>
 * 配置文件路径：所有配置文件须放在classpath中，一般放在resource目录下。
 *
 * @author Zhang
 * @since 2023/5/13
 */
public class ResourceI18n {

    public static String getResourceI18n(String baseName, String language, String country, String key) {
        ResourceBundle bundle = ResourceBundle.getBundle(baseName, new Locale(language, country));
        return bundle.getString(key);
    }

    public static void main(String[] args) {
        System.out.println(getResourceI18n("messages", "zh", "CN", "languageTest"));
        System.out.println(getResourceI18n("messages", "en", "GB", "languageTest"));
    }
}

package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Zhang
 * @since 2023/4/25
 */
@Configuration
@ComponentScan({"controller", "service", "dao"})
public class SpringConfig {
    //全注解开发
    //不再使用Spring配置文件(即bean.xml)，写一个配置类来代替配置文件
}

package bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * bean的后置处理器会在生命周期的初始化前后添加额外的操作，需要实现BeanPostProcessor接口，且配置到IoC容器中。
 * 注意:bean后置处理器不是单独针对某一个bean生效，而是针对IoC容器中所有bean都会执行。
 *
 * @author Zhang
 * @since 2023/4/23
 */
public class PersonBeanPost implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("3 bean后置处理器(初始化之前)" + beanName + ":" + bean);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("5 bean后置处理器(初始化之后)" + beanName + ":" + bean);
        return bean;
    }
}

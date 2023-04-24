package bean;

/**
 * 1 bean对象创建(调用无参构造函数)
 * 2 给bean对象设置相关属性
 * 3 bean后置处理器(初始化之前)
 * 4 bean对象初始化(调用指定初始化方法)
 * 5 bean后置处理器(初始化之后)
 * 6 bean对象创建完毕(可以使用)
 * 7 bean对象销毁(配置指定销毁方法)
 * 8 IoC容器关闭
 *
 * @author Zhang
 * @since 2023/4/23
 */
public class Person {
    public Person() {
        System.out.println("1 bean对象创建(调用无参构造函数)");
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("2 给bean对象设置相关属性");
        this.name = name;
    }

    /**
     * 初始化的方法
     */
    public void initMethod() {
        System.out.println("4 bean对象初始化(调用指定初始化方法)");
    }

    /**
     * 销毁的方法
     */
    public void destroyMethod() {
        System.out.println("7 bean对象销毁(配置指定销毁方法)");
    }
}

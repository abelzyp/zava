package reflect;

import java.lang.reflect.ParameterizedType;

/**
 * @author Zhang
 * @since 2023/4/11
 */
public class BaseDao<T> {
    private Class clazz;

    public BaseDao() {
        //获得当前类型的带有泛型类型的父类 (运行期this其实是BaseDao的某个子类,ptClass其实就是BaseDao本身)
        ParameterizedType ptClass = (ParameterizedType) this.getClass().getGenericSuperclass();
        //获得运行期的泛型类型
        clazz = (Class) ptClass.getActualTypeArguments()[0];
        System.out.println(clazz.getSimpleName());
    }
}

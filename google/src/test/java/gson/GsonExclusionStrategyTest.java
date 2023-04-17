package gson;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import org.junit.Test;

/**
 * 基于策略是利用Gson提供的ExclusionStrategy接口，需要使用GsonBuilder,
 * 相关API 2个，分别是addSerializationExclusionStrategy 和addDeserializationExclusionStrategy 分别针对序列化和反序化时。
 *
 * @author zhangyupeng
 * @date 2018/6/17
 */
public class GsonExclusionStrategyTest {

    @Test
    public void test() {
        Gson gson = new GsonBuilder()
                .addSerializationExclusionStrategy(new ExclusionStrategy() {
                    @Override
                    //这里做判断，决定是否排除该字段，return true为排除
                    public boolean shouldSkipField(FieldAttributes f) {
                        //按字段名排除
                        if ("finalField".equals(f.getName())) {
                            return true;
                        }
                        //按注解排除
                        Expose expose = f.getAnnotation(Expose.class);
                        if (null != expose && !expose.deserialize()) {
                            return true;
                        }
                        return false;
                    }

                    @Override
                    //直接排除某各类，return true为排除
                    public boolean shouldSkipClass(Class<?> clazz) {
                        return (int.class == clazz || Integer.class == clazz);
                    }
                })
                .create();
    }
}
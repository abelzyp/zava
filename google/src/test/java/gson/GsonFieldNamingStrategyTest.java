package gson;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;

import java.lang.reflect.Field;

/**
 * GsonBuilder提供了FieldNamingStrategy接口和setFieldNamingPolicy和setFieldNamingStrategy 两个方法。
 *
 * @author zhangyupeng
 * @date 2018/6/17
 */
public class GsonFieldNamingStrategyTest {

    @Test
    public void test() {
        Gson gsonDefault = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_DASHES)
                .create();

        Gson gson = new GsonBuilder()
                .setFieldNamingStrategy(new FieldNamingStrategy() {
                    @Override
                    public String translateName(Field f) {
                        //自定义规则
                        return null;
                    }
                })
                .create();
    }
}
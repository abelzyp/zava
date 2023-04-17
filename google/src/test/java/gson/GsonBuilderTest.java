package gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;

/**
 * @author zhangyupeng
 * @date 2018/6/17
 */
public class GsonBuilderTest {

    @Test
    public void test() {
        Gson gson = new GsonBuilder()
                //序列化null值
                .serializeNulls()
                //设置日期和时间格式，还有2个重载，在序列化和反序化时均生效
                .setDateFormat("yyyy-MM-dd")
                //禁止序列化内部类
                .disableInnerClassSerialization()
                //生成不可执行的Json（多了 )]}' 这4个字符）
                .generateNonExecutableJson()
                //禁止转义html标签
                .disableHtmlEscaping()
                //格式化输出
                .setPrettyPrinting()
                .create();

        User user = new User(200700036, "abel", "123456");
        gson.toJson(user, System.out);
    }
}
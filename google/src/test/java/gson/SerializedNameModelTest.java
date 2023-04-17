package gson;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author zhangyupeng
 * @date 2018/6/16
 */
public class SerializedNameModelTest {

    @Test
    public void test() {
        Gson gson = new Gson();

        SerializedNameModel model = new SerializedNameModel("abel", 26, "abelzyp@foxmail.com");
        System.out.println(gson.toJson(model));

        //注：当上面的三个属性(email_address、email、emailAddress)中出现任意一个时均可以得到正确的结果。
        String modelJson = "{\"name\":\"abel\",\"age\":26,\"email_address\":\"abelzyp@foxmail.com\"}";
        SerializedNameModel serializedNameModel = gson.fromJson(modelJson, SerializedNameModel.class);
        System.out.println(serializedNameModel.getEmailAddress());
        Assert.assertEquals(model.getEmailAddress(), serializedNameModel.getEmailAddress());

        //写到控制台
        gson.toJson(serializedNameModel, System.out);
    }
}
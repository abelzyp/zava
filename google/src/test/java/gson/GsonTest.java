package gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhangyupeng
 * @date 2018/6/17
 */
public class GsonTest {

    @Test
    public void test() {
        //数组方式
        Gson gson = new Gson();
        String[] strings = gson.fromJson(DataArray.ARRAY, String[].class);
        System.out.println(Arrays.toString(strings));

        //集合方式
        List<String> stringList = gson.fromJson(DataArray.ARRAY, new TypeToken<List<String>>() {
        }.getType());
        System.out.println(stringList);
    }
}
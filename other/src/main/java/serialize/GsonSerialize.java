package serialize;

import com.google.gson.Gson;

/**
 * Google的Gson序列化
 * -序列化速度:较慢
 * -序列化文件大小:较大
 * -编程模型复杂度:简单
 *
 * @author zhangyupeng
 * @date 2019-04-24
 */
public class GsonSerialize {

    private static Gson gson = new Gson();

    public static String serialize(Object obj) {
        return gson.toJson(obj);
    }

    static Object deserialize(String json, Class<?> clazz) {
        return gson.fromJson(json, clazz);
    }
}
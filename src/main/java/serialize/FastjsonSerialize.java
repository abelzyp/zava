package serialize;

import com.alibaba.fastjson.JSON;

/**
 * Alibaba的FastJSON序列化
 * -序列化速度:较快
 * -序列化文件大小:较大
 * -编程模型复杂度:简单
 *
 * @author zhangyupeng
 * @date 2019-04-24
 */
public class FastjsonSerialize {

    public static String serialize(Object obj) {
        String json = JSON.toJSONString(obj);
        return json;
    }

    public static Object deserialize(String json, Class<?> clazz) {
        Object obj = JSON.parseObject(json, clazz);
        return obj;
    }
}
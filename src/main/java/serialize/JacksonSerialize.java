package serialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Jackson序列化
 * -序列化速度:一般
 * -序列化文件大小:较大
 * -编程模型复杂度:简单
 *
 * @author zhangyupeng
 * @date 2019-04-24
 */
public class JacksonSerialize {

    public static String serialize(Object obj) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(obj);
    }

    static Object deserialize(String json, Class<?> clazz) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, clazz);
    }
}
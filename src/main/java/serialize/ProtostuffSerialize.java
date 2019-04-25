package serialize;

import com.google.common.base.Preconditions;
import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhangyupeng
 * @date 2019-04-25
 */
public class ProtostuffSerialize {

    private static final Map<Class<?>, Schema<?>> SCHEMA_CACHE = new ConcurrentHashMap<>();

    @SuppressWarnings("unchecked")
    public static <T> byte[] serialize(T obj) {
        if (null == obj) {
            return null;
        }
        Class<T> clazz = (Class<T>) obj.getClass();
        Schema<T> schema = getSchema(clazz);
        LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
        return ProtostuffIOUtil.toByteArray(obj, schema, buffer);
    }

    public static <T> T deserialize(byte[] bytes, Class<T> clazz) {
        Schema<T> schema = getSchema(clazz);
        T obj = schema.newMessage();
        ProtostuffIOUtil.mergeFrom(bytes, obj, schema);
        return obj;
    }

    @SuppressWarnings("unchecked")
    private static <T> Schema<T> getSchema(Class<T> clazz) {
        Preconditions.checkNotNull(clazz);
        Schema<T> schema = (Schema<T>) SCHEMA_CACHE.get(clazz);
        if (null == schema) {
            schema = RuntimeSchema.getSchema(clazz);
            if (null != schema) {
                SCHEMA_CACHE.put(clazz, schema);
            }
        }
        return Preconditions.checkNotNull(schema);
    }
}
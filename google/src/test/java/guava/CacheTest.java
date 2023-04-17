package guava;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 从缓存中取key X的值，如果该值已经缓存过了，则返回缓存中的值，如果没有缓存过，可以通过某个方法来获取这个值。
 * 当大量线程用相同的key获取缓存值时，只会有一个线程进入load方法，而其他线程则等待，直到缓存值被生成。这样也就避免了缓存穿透的危险。
 *
 * @author Abel
 * @date 2018/11/2
 */
public class CacheTest {

    /**
     * CacheLoader的定义比较宽泛，是针对整个cache定义的，可以认为是统一的根据key值load value的方法。
     * 而callable的方式较为灵活，允许你在get的时候指定。
     */
    @Test
    public void cacheTest() {
        Cache<String, String> cache = CacheBuilder.newBuilder()
                                                  .maximumSize(100)
                                                  .expireAfterAccess(3, TimeUnit.SECONDS)
                                                  .build();
        cache.put("j", "java");
        cache.put("c", "cpp");
        cache.put("s", "scala");
        cache.put("g", "go");
        try {
            String result1 = cache.get("j", () -> "过期啦哈哈哈");
            System.out.println(result1);
            TimeUnit.SECONDS.sleep(5);
            String result2 = cache.get("j", () -> "过期啦哈哈哈");
            System.out.println(result2);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void loadingCacheTest() {
        LoadingCache<String, String> cache = CacheBuilder.newBuilder()
                                                         //最大缓存数
                                                         .maximumSize(100)
                                                         //过期时间
                                                         .expireAfterAccess(3, TimeUnit.SECONDS)
                                                         .build(new CacheLoader<String, String>() {
                                                             @Override
                                                             public String load(String key) {
                                                                 return key + "过期啦哈哈哈";
                                                             }
                                                         });
        cache.put("j", "java");
        cache.put("c", "cpp");
        cache.put("s", "scala");
        cache.put("g", "go");

        try {
            System.out.println(cache.get("j"));
            TimeUnit.SECONDS.sleep(5);
            System.out.println(cache.get("s"));
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test() {
        ListeningExecutorService backgroundRefreshPools =
                MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(20));

        LoadingCache<String, Object> cache = CacheBuilder.newBuilder()
                                                         .maximumSize(100)
                                                         .refreshAfterWrite(10, TimeUnit.MINUTES)
                                                         .build(new CacheLoader<String, Object>() {
                                                             @Override
                                                             public Object load(String key) {
                                                                 return key;
                                                             }

                                                             @Override
                                                             public ListenableFuture<Object> reload(String key, Object oldValue) {
                                                                 return backgroundRefreshPools.submit(() -> "xxx");
                                                             }
                                                         });

        try {
            System.out.println(cache.get("xxx"));
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
package spi;

/**
 * SPI ，全称为 Service Provider Interface，是一种服务发现机制。
 * 它通过在ClassPath路径下的META-INF/services文件夹查找文件，自动加载文件里所定义的类。
 *
 * @author Zhang Yupeng
 * @since 2022/1/15
 */
public interface SpiService {
    void execute();
}

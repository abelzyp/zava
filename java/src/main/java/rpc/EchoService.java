package rpc;

/**
 * 接口定义
 * 服务提供者，运行在服务端，负责提供接口定义和服务实现类
 *
 * @author Zhang Yupeng
 * @since 2021/2/3
 */
public interface EchoService {
    String echo(String ping);
}
package rpc;

import java.net.InetSocketAddress;

/**
 * @author Zhang Yupeng
 * @since 2021/2/3
 */
public class RpcTest {
    public static void main(String[] args) {
        // 创建一个异步发布服务端的线程并启动，用于接收RPC客户端的请求，根据请求参数调用服务实现类，返回结果给客户端
        new Thread(() -> {
            try {
                RpcExporter.exporter("localhost", 8088);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        // 创建客户端服务代理类，构造RPC请求参数，发起RPC调用，将调用结果输出到控制台
        RpcImporter<EchoService> importer = new RpcImporter<>();
        EchoService echo = importer.importer(EchoServiceImpl.class, new InetSocketAddress("localhost", 8088));
        System.out.println(echo.echo("Are you ok ?"));
    }
}
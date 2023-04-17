package rpc;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * RPC客户端本地服务代理源码
 * 运行在RPC客户端，通过代理调用远程服务提供者，然后将结果进行封装返回给本地消费者
 *
 * @author Zhang Yupeng
 * @since 2021/2/3
 */
public class RpcImporter<S> {

    public S importer(final Class<?> serviceClass, final InetSocketAddress addr) {
        // 将本地接口调用转换成JDK动态代理，在动态代理中实现接口的远程调用
        return (S) Proxy.newProxyInstance(serviceClass.getClassLoader(), new Class<?>[]{serviceClass.getInterfaces()[0]}, (proxy, method, args) -> {
            Socket socket = null;
            ObjectOutputStream output = null;
            ObjectInputStream input = null;
            try {
                // 创建Socket客户端，根据指定地址连接远程服务提供者
                socket = new Socket();
                socket.connect(addr);
                // 将远程服务调用所需的接口类、方法名、参数列表等编码后发送给服务提供者
                output = new ObjectOutputStream(socket.getOutputStream());
                output.writeUTF(serviceClass.getName());
                output.writeUTF(method.getName());
                output.writeObject(method.getParameterTypes());
                output.writeObject(args);
                // 同步阻塞等待服务端返回应答，获取应答之后返回
                input = new ObjectInputStream(socket.getInputStream());
                return input.readObject();
            } finally {
                if (socket != null) {
                    socket.close();
                }
                if (output != null) {
                    output.close();
                }
                if (input != null) {
                    input.close();
                }
            }
        });
    }
}
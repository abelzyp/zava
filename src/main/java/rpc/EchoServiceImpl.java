package rpc;

/**
 * 实现代码
 *
 * @author Zhang Yupeng
 * @since 2021/2/3
 */
public class EchoServiceImpl implements EchoService {
    @Override
    public String echo(String ping) {
        return ping != null ? ping + " --> I am ok." : " I am ok.";
    }
}
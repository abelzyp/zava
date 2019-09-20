package designpattern.chainofresponsibility;

/**
 * @author zhangyupeng
 * @date 2019-09-20
 */
public class ConcreteHandler extends Handler {

    @Override
    public void handleSelf(Context context) {
        if (getNextHandler() != null) {
            System.out.println("放过请求");
            getNextHandler().handleSelf(context);
        } else {
            System.out.println("处理请求");
        }
    }
}
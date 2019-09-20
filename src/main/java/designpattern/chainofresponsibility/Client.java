package designpattern.chainofresponsibility;

/**
 * @author zhangyupeng
 * @date 2019-09-20
 */
public class Client {
    public static void main(String[] args) {
        //组装责任链
        Handler handler1 = new ConcreteHandler();
        Handler handler2 = new ConcreteHandler();
        handler1.setNextHandler(handler2);

        //提交请求
        handler1.handleSelf(new Context());
    }
}
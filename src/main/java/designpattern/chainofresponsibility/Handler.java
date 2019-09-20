package designpattern.chainofresponsibility;

/**
 * 抽象处理者
 *
 * @author zhangyupeng
 * @date 2019-09-20
 */
public abstract class Handler {

    /**
     * 持有对下家的引用
     */
    protected Handler nextHandler;

    /**
     * 处理
     *
     * @param context 责任链处理上下文
     */
    public abstract void handleSelf(Context context);

    /**
     * 取值方法
     */
    public Handler getNextHandler() {
        return nextHandler;
    }

    /**
     * 设置方法,设置下家
     *
     * @param nextHandler 下一个处理者
     */
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
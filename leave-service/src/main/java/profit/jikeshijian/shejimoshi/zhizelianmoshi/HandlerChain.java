package profit.jikeshijian.shejimoshi.zhizelianmoshi;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: huangxiaogen
 * @Date: 2020/07/19/下午4:13
 * @Description:
 */

/**
 * 分析：
 * 1。上面的代码实现不够优雅。处理器类的 handle() 函数，不仅包含自己的业务逻辑
 * 2。还包含对下一个处理器的调用，也就是代码中的 successor.handle()。
 * 3。一个不熟悉这 种代码结构的程序员，在添加新的处理器类的时候
 * 4。很有可能忘记在 handle() 函数中调用 successor.handle()，这就会导致代码出现 bug。
 *
 * 针对这个问题优化：
 * 1。针对这个问题，我们对代码进行重构，利用模板模式，将调用 successor.handle() 的逻辑 从具体的处理器类中剥离出来，放到抽象父类中。
 * 2。这样具体的处理器类只需要实现自己的业 务逻辑就可以了
 * 3。
 * 4。
 *
 *
 *
 *
 *
 */
public class HandlerChain {
    private Handler head = null;
    private Handler tail = null;

    public void addHandler(Handler handler) {
        handler.setSuccessor(null);
        if (head == null) {
            head = handler;
            tail = handler;
            return;
        }
        tail.setSuccessor(handler);
        tail = handler;
    }

    public void handle() {
        if (head != null) {
            head.handle();
        }
    }
}

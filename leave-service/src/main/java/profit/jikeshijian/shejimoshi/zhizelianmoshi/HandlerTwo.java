package profit.jikeshijian.shejimoshi.zhizelianmoshi;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: huangxiaogen
 * @Date: 2020/07/19/下午4:20
 * @Description:
 */

public abstract class HandlerTwo {
    protected Handler successor = null;
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public final void handle(){
        boolean handled = doHandle();
        if (successor != null && !handled) {
            successor.handle();
        }
    }

    protected abstract boolean doHandle();
}

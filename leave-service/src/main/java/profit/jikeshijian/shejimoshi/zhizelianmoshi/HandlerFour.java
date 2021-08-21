package profit.jikeshijian.shejimoshi.zhizelianmoshi;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: huangxiaogen
 * @Date: 2020/07/19/下午4:40
 * @Description:
 */

public abstract class HandlerFour {
    protected HandlerFour successor = null;
    public void setSuccessor(HandlerFour successor) {
        this.successor = successor;
    }
    public final void handle(){
         doHandle();
        if (successor != null ) {
            successor.handle();
        }
    }

    protected abstract void doHandle();
}

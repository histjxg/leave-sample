package profit.jikeshijian.shejimoshi.guanchazhemoshi.eventbus;

import java.util.concurrent.Executor;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: huangxiaogen
 * @Date: 2020/07/18/下午12:06
 * @Description:
 */

public class AsyncEventBus extends EventBus {
    public AsyncEventBus(Executor executor) {
        super(executor);
    }
}

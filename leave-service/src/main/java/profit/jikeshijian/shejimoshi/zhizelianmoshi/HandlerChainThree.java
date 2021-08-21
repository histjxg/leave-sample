package profit.jikeshijian.shejimoshi.zhizelianmoshi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: huangxiaogen
 * @Date: 2020/07/19/下午4:29
 * @Description:
 */

public class HandlerChainThree {
    private List<IHandlerThree> handlers = new ArrayList<>();

    public void addHandler(IHandlerThree handler) {
        this.handlers.add(handler);
    }

    public void handle() {
        for (IHandlerThree handler : handlers) {
            boolean handled = handler.handle();
            if (handled) {
                break;
            }
        }
    }
}

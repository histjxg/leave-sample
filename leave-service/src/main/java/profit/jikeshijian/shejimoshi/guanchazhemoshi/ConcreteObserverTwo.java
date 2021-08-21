package profit.jikeshijian.shejimoshi.guanchazhemoshi;

import sun.plugin2.message.Message;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: huangxiaogen
 * @Date: 2020/07/13/上午9:22
 * @Description:
 */

public class ConcreteObserverTwo implements Observer{
    @Override
    public void update(Message message) {
        //TODO: 获取消息通知，执行自己的逻辑...
        System.out.println("ConcreteObserverTwo is notified.");
    }
}

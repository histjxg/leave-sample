package profit.jikeshijian.shejimoshi.guanchazhemoshi;

import sun.plugin2.message.Message;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: huangxiaogen
 * @Date: 2020/07/13/上午9:19
 * @Description:
 */

public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(Message message);
}

package profit.jikeshijian.shejimoshi.guanchazhemoshi;

import sun.plugin2.message.Conversation;
import sun.plugin2.message.Message;
import sun.plugin2.message.Serializer;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: huangxiaogen
 * @Date: 2020/07/13/上午9:23
 * @Description:
 */

/**
 *1.观察者模式的“模板代码”，只能反映大体的设计思路
 * 2.在真实的 软件开发中，并不需要照搬上面的模板代码
 * 3.观察者模式的实现方法各式各样，函数、类的 命名等会根据业务场景的不同有很大的差别，比如 register 函数还可以叫作 attach
 * 4.remove 函数还可以叫作 detach 等等。不过，万变不离其宗，设计思路都是差不多的。
 *
 *
 *
 */
public class ObserverDemo {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        subject.registerObserver(new ConcreteObserverOne());
        subject.registerObserver(new ConcreteObserverTwo());
        subject.notifyObservers(new Message(1,new Conversation()) {
            @Override
            public void writeFields(Serializer serializer) throws IOException {

            }

            @Override
            public void readFields(Serializer serializer) throws IOException {

            }
        });
    }
}

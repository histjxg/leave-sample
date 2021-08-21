package profit.jikeshijian.shejimoshi.guanchazhemoshi;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: huangxiaogen
 * @Date: 2020/07/15/上午11:12
 * @Description:
 */

/**
 *
 * 1。利用 EventBus 框架实现的观察者模式，跟从零开始编写的观察者模式相比
 * 2。从大的流程上来说，实现思路大致一样，都需要定义 Observer，并且通过 register() 函数注册Observer
 * 3。也都需要通过调用某个函数(比如，EventBus 中的 post() 函数)来给 Observer 发送消息(在 EventBus 中消息被称作事件 event)。
 * 4。
 * 5。但在实现细节方面，它们又有些区别。基于 EventBus，我们不需要定义 Observer 接口，
 * 6。任意类型的对象都可以注册到 EventBus 中，通过 @Subscribe 注解来标明类中哪个函数可以接收被观察者发送的消息。
 *  接下来，我们详细地讲一下，Guava EventBus 的几个主要的类和函数。
 *  EventBus、AsyncEventBus
 *Guava EventBus 对外暴露的所有可调用接口，都封装在 EventBus 类中。
 *其中， EventBus 实现了同步阻塞的观察者模式，AsyncEventBus 继承自 EventBus，提供了异步 非阻塞的观察者模式。
 *
 *
 *
 *
 */
public class RegNotificationObserverThree {
//    private NotificationService notificationService;
//    @Subscribe
    public void handleRegSuccess(long userId) {
//        notificationService.sendInboxMessage(userId, "...");
    }

}

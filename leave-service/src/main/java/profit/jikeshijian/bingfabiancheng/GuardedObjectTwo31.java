package profit.jikeshijian.bingfabiancheng;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Predicate;

/**
 *
 *
 我们可以参考大堂经理识别就餐人的办法，来扩展一下Guarded Suspension模式，从而使它能够很方便地解决小灰同学的问题。
 1。在小灰的程序中，每个发送到MQ的消息，都有一个唯一性的属性id
 2。所以我们可以维护一个MQ消息id和GuardedObject对象实例的关系
    所以我们可以维护一个MQ消息id和GuardedObject对象实例的关系，这个关系可以类比大堂经理大脑里维护的包间和就餐人的关系。


 下面的示例代码是扩展Guarded Suspension模式的实现
     1。扩展后的GuardedObject内部维护了一个Map，其Key是MQ消息id
     2。而Value是GuardedObject对象实例，同时增加了静态方法create()和fireEvent()；
     3。create()方法用来创建一个GuardedObject对象实例，并根据key值将其加入到Map中
     4。而fireEvent()方法则是模拟的大堂经理根据包间找就餐人的逻辑



 *
 *
 *
 *
 *
 */



public class GuardedObjectTwo31<T> {
    //受保护的对象
    private T obj;
    final Lock lock = new ReentrantLock();
    final Condition done = lock.newCondition();
    final int timeout = 2;
    //保存所有GuardedObject
    final static Map<Object, GuardedObjectTwo31> gos = new ConcurrentHashMap<>();

    //静态方法创建GuardedObject
    static <K> GuardedObjectTwo31 create(K key) {
        GuardedObjectTwo31 go = new GuardedObjectTwo31();
        gos.put(key, go);
        return go;
    }

    static <K, T> void fireEvent(K key, T obj) {
        GuardedObjectTwo31 go = gos.remove(key);
        if (go != null) {
            go.onChanged(obj);
        }
    }

    //获取受保护对象
    T get(Predicate<T> p) {
        lock.lock();
        try {
            //MESA管程推荐写法
            while (!p.test(obj)) {
                done.await(timeout, TimeUnit.SECONDS);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
        //返回非空的受保护对象
        return obj;
    }

    //事件通知方法
    void onChanged(T obj) {
        lock.lock();
        try {
            this.obj = obj;
            done.signalAll();
        } finally {
            lock.unlock();
        }
    }



    //处理浏览器发来的请求
    /*
        Respond handleWebReq() {
            int id = 序号生成器.get();
            //创建一消息
            Message msg1 = new Message(id, "{...}");
            //创建GuardedObject实例
            GuardedObject<Message> go = GuardedObject.create(id);
            //发送消息
            send(msg1);
            //等待MQ消息
            Message r = go.get(t -> t != null);
        }

        void onMessage(Message msg) {
            //唤醒等待的线程
            GuardedObject.fireEvent(msg.id, msg);
        }
    */
}

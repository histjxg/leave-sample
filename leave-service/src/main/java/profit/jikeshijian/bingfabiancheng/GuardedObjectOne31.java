package profit.jikeshijian.bingfabiancheng;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Predicate;

/**
 *
 *
 *
 *
 GuardedObject的内部实现非常简单,是管程的一个经典用法
     1.get()方法通过条件变量的await()方法实现等待
     2.onChanged()方法通过条件变量的signalAll()方法实现唤醒功能。
     3.逻辑还是很简单的，所以这里就不再详细介绍了

 Guarded Suspension模式里GuardedObject有两个核心方法
 一个是get()方法
 一个是onChanged()方法
 在处理Web请求的方法handleWebReq()中，可以调用GuardedObject的get()方法来实现等待
 在MQ消息的消费方法onMessage()中，可以调用GuardedObject的onChanged()方法来实现唤醒。


 *
 *

 */


public class GuardedObjectOne31<T> {
    //受保护的对象
    T obj;
    final Lock lock = new ReentrantLock();
    final Condition done = lock.newCondition();
    final int timeout = 1;

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

    /**
     *
     *
    问题：
         handleWebReq()里面创建了GuardedObject对象的实例go，并调用其get()方等待结果，那在onMessage()方法中
         如何才能够找到匹配的GuardedObject对象呢？
     答案
         1。这个过程类似服务员告诉大堂经理某某包间已经收拾好了，大堂经理如何根据包间找到就餐的人
         2。现实世界里，大堂经理的头脑中，有包间和就餐人之间的关系图，所以服务员说完之后大堂经理立刻就能把就餐人找出来。
    参考代码：
         profit.jikeshijian.bingfabiancheng.GuardedObjectTwo30
    Respond handleWebReq(){
        //创建一消息
        Message30 msg1 = new
                Message("1","{...}");
        //发送消息
        send(msg1);
        //利用GuardedObject实现等待
     GuardedObject30<Message> go=new GuardedObject30<>();
        Message r = go.get(
                t->t != null);
    }
    void onMessage(Message msg){
        //如何找到匹配的go？
        GuardedObject<Message> go=???
        go.onChanged(msg);
    }

     */
}

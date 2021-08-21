package profit.lianxi;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareData{

    private int number = 0;

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    public void increment()throws Exception{
        System.out.println("生产锁"+Thread.currentThread().getName()+"获取锁开始");
        lock.lock();
        System.out.println("生产锁"+Thread.currentThread().getName()+"获取锁结束");

        try {
            //1.判断 if会出现假唤醒
            while (number!=0){
                //等待，不能生产
                System.out.println("wait 生产"+Thread.currentThread().getName()+" \t "+number);
                condition.await();
            }
            number++;
            System.out.println("生产"+Thread.currentThread().getName()+" \t "+number);
            //通知唤醒
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void decrement()throws Exception{
        Class<String> stringClass = String.class;
        String s = stringClass.getConstructor().newInstance();
        String.class.newInstance();


        
        lock.lock();
        try {
            //1.判断 if会出现假唤醒
            while(number==0){
                //等待，不能生产
                System.out.println("wait 消费"+Thread.currentThread().getName()+" \t "+number);

                condition.await();
            }
            number--;
            System.out.println("消费"+Thread.currentThread().getName()+" \t "+number);
            //通知唤醒
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}

/**
 *
 *
 * 对于从wait中被notify的进程来说，它在被notify之后还需要重新检查是否符合执行条件，
 * 如果不符合，就必须再次被wait，如果符合才能往下执行。所以：wait方法应该使用循环模式来调用。
 * 按照上面的生产者和消费者问题来说：错误情况一：如果有两个生产者A和B，一个消费者C。当存储空间满了之后，
 * 生产者A和B都被wait，进入等待唤醒队列。当消费者C取走了一个数据后，如果调用了notifyAll（），
 * 注意，此处是调用notifyAll（），则生产者线程A和B都将被唤醒，如果此时A和B中的wait不在while循环中而是在if中，
 * 则A和B就不会再次判断是否符合执行条件，都将直接执行wait（）之后的程序，那么如果A放入了一个数据至存储空间，
 * 则此时存储空间已经满了；但是B还是会继续往存储空间里放数据，错误便产生了。
 * 错误情况二：如果有两个生产者A和B，一个消费者C。当存储空间满了之后，生产者A和B都被wait，
 * 进入等待唤醒队列。当消费者C取走了一个数据后，如果调用了notify（），则A和B中的一个将被唤醒，
 * 假设A被唤醒，则A向存储空间放入了一个数据，至此空间就满了。A执行了notify（）之后，如果唤醒了B，
 * 那么B不会再次判断是否符合执行条件，
 * 将直接执行wait（）之后的程序，这样就导致向已经满了数据存储区中再次放入数据。错误产生。
 *
 *
 * 题目：一个初始值为零的变量，两个线程对其交替操作，一个加1(传统版的多线程交互)
 * 一个减1，来5轮
 * 1 线程    操作(方法)    资源类
 * 2判断     干活     通知
 * 3.防止虚假唤醒机制 必须要要用while，用if可能会带来虚假唤醒机制
 * 多线程都是用while判断：
 *
 */
public class ProdConsumer_TraditionDemo {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try{
                    shareData.increment();
                    System.out.println(Thread.currentThread().getName()+i);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        },"AA").start();
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try{
                    shareData.decrement();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        },"BB").start();
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try{
                    shareData.increment();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        },"cc").start();
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try{
                    shareData.decrement();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        },"dd").start();
    }
}

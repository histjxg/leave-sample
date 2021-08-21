package profit.lianxi;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 题目：synchronized和lock的区别？用新的lock有什么好处，你举例说说
 * 1。原始构成
 * synchronized是关键字属于JVM层面
 *   monitorenter(底层是通过monitor对象来完成，其实wait/notify等方法也依赖于monitor对象只有在同步快或方法中国呢才能减wait/notify等方法)
 *   monitorexit 两次
 *   lock是具体（java.util.concurrent.locks.lock）是api层面的锁
 *
 * 2。使用方法
 * synchronized不需要用户手动释放锁，当synchronized代码执行完后系统会自动让线程释放对锁的占用
 * reentrantlock则需要用户去手动释放锁，若没有主动释放所，就有可能导致出现死锁的现象
 * 需要lock()和unlock()方法配合try/finally语句块来完成
 *
 * 3。等待是否可中断
 * snchronized不可中断，除非抛出异常或者正常运行完成
 * Reentrantlock可中断 1.设置超时方法 try lock(long timeout ,TimeUnit unit)
 *                    2.lockInterruptibly()方代码块，调用interrupt方法可中断
 *
 * 4。加锁是否公平
 * snchronized非公平锁
 * Reentrantlock两者都可以，默认非公平锁，构造方法可以传入boolean值，true为公平锁
 *
 * 5。锁绑定多个条件，Condition
 * synchronized非公平锁
 * Reentrantlock用来实现分组唤醒的线程们，可以精确唤醒，
 * 而不是像synchronized要么随机唤醒一个线程，要么唤醒全部线程
 *
 *题目：多线程之间按顺序调用，实现A-》B——》C三个线程启动要求如下
 * AA打印5次，BB打印10次，CC打印15次
 *
 * 紧接着
 * AA打印5次，BB打印10次，CC打印15次
 * 。。。
 * 来10轮
 */
class ShareResource{
    private int number = 1;//标志位
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void print5(){
        lock.lock();
        try{
            //1判断
            while(number!=1){
                c1.await();
            }
            //2干活
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+number);
            }
            //3.通知
            number = 2;
            c2.signal();//通知二号线程
        }catch (Exception e){
            
        }
    }

    public void print10(){
        lock.lock();
        try{
            //1判断
            while(number!=2){
                c2.await();
            }
            //2干活
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+number);
            }
            //3.通知
            number = 3;
            c3.signal();//通知二号线程
        }catch (Exception e){

        }
    }
    public void print15(){
        lock.lock();
        try{
            //1判断
            while(number!=3){
                c3.await();
            }
            //2干活
            for (int i = 1; i <= 15; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+number);
            }
            //3.通知
            number = 1;
            c1.signal();//通知二号线程
        }catch (Exception e){

        }
    }

    //通知
}

public class SyncAndReentrantLockDemo {
    public static void main(String[] args) {
       /* synchronized (new Object()){

        }
        new ReentrantLock();*/
       ShareResource shareResource  = new ShareResource();
       new Thread(()->{
           for (int i = 1; i <=10; i++) {
               shareResource.print5();
           }
       },"A").start();

        new Thread(()->{
            for (int i = 1; i <= 10; i++) {
                shareResource.print10();
            }
        },"B").start();
        new Thread(()->{
            for (int i = 1; i <= 10; i++) {
                shareResource.print15();
            }
        },"C").start();
    }

}

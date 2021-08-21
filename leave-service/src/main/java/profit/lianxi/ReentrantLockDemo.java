package profit.lianxi;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Phone implements Runnable{
    Lock lock = new ReentrantLock();
    public synchronized void sendSMS() throws Exception{
        System.out.println(Thread.currentThread().getId()+"\t invoke sendSMS()");

        sendEmail();
    }
    public synchronized void sendEmail() throws Exception{

        wait(5000);
        System.out.println(Thread.currentThread().getId()+"\t invoke sendEmail()");
    }

    @Override
    public void run() {
        get();
    }
    public void get(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getId()+"\t  invoke get()");
            set();
        }finally {
            lock.unlock();
        }
    }
    public void set(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getId()+"\t invoke set()");

        }finally {
            lock.unlock();
        }
    }
}

/**
 * 可重入锁（也叫做递归锁）
 * //可重入锁（也叫做递归锁）
 //指的是同一个线程外层函数获得锁之后，内层递归函数仍然能获取该锁的代码；
 //在同一个线程在外层获取锁的时候，在进入内层方法会自动获取锁
 //也即是说，线程可以进入任何一个它已经拥有的锁所同步着的代码
 *
 */
public class ReentrantLockDemo {
    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(() -> {
            try {

               phone.sendSMS();


            }catch (Exception e){
                e.printStackTrace();
            }
        }, "t1").start();
        new Thread(() -> {
            try {

//                phone.sendEmail();
                phone.sendSMS();

            }catch (Exception e){
                e.printStackTrace();
            }
        }, "t2").start();

        System.out.println();
        System.out.println();
        System.out.println();
        Thread t3 = new Thread(phone);
        Thread t4 = new Thread(phone);
        t3.start();
        t4.start();

    }

    public void send(){
        try {
            //12
        }catch (Exception e){
            System.out.println(1);
        }

        System.out.println(12);
    }

}

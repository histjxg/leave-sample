package profit.lianxi;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class T1 {
    volatile int n = 0;
    public void add(){
        n++;
    }

    public static void main(String[] args) {
        //默认是公平锁和非公平锁
        //公平锁，先来后到， 多个线程按照申请锁的顺序来获取锁，类似排队打饭，先来后到
        // 非公平：加塞提问，某一个线程，允许加塞，指的是多个线程获取锁的顺序并不按照申请锁的顺序，
        // 有可能后申请的线程比先申请的线程优先获取锁，在高并发的时候，有可能造成优先级反转或者饥饿现象
        Lock lock = new ReentrantLock();
        //可重入锁（也叫做递归锁）
        //指的是同一个线程外层函数获得锁之后，内层递归函数仍然能获取该锁的代码；
        //在同一个线程在外层获取锁的时候，在进入内层方法会自动获取锁
        //也即是说，线程可以进入任何一个它已经拥有的锁所同步着的代码
    }
}

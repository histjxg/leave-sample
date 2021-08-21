package profit.jikeshijian.bingfabiancheng;

import java.util.concurrent.atomic.AtomicLong;

/**
 *
 *
 *
 *
 *
 *
 1。下面这个静态类ThreadId会为每个线程分配一个唯一的线程Id
 2。如果一个线程前后两次调用ThreadId的get()方法，两次get()方法的返回值是相同的。
 3。但如果是两个线程分别调用ThreadId的get()方法，那么两个线程看到的get()方法的返回值是不同的
 4。若你是初次接触ThreadLocal，可能会觉得奇怪，为什么相同线程调用get()方法结果就相同
 5。而不同线程调用get()方法结果就不同呢？



 *
 *
 *
 *
 *
 *
 */
public class ThreadLocalThreadId30 {
    static final AtomicLong nextId=new AtomicLong(0);
    //定义ThreadLocal变量
    static final ThreadLocal<Long>
            tl=ThreadLocal.withInitial(
            ()->nextId.getAndIncrement());
    //此方法会为每个线程分配一个唯一的Id
    static long get(){
        return tl.get();
    }
}

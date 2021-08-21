package profit.jikeshijian.bingfabiancheng;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.Semaphore;
import java.util.function.Function;

/**
 *
 *
 *
 *
 *
 *
 *
 工作中也遇到了一个对象池的需求
 所谓对象池呢，指的是一次性创建出 N 个 对象，之后所有的线程重复利用这 N 个对象
 当然对象在被释放前，也是不允许其他线程使用 的。
 对象池，可以用 List 保存实例对象，这个很简单。但关键是限流器的设计，、、

 这里的限流，指 的是不允许多于 N 个线程同时进入临界区。那如何快速实现一个这样的限流器呢?
 这种场景，我 立刻就想到了信号量的解决方案。
 信号量的计数器，在上面的例子中，我们设置成了 1，这个 1 表示只允许一个线程进入临界区，
 但如果我们把计数器的值设置成对象池里对象的个数 N，就能完美解决对象池的限流问题了。下 面就是对象池的示例代码。
 *
 *
 *
 *
 *
 *
 *
 *
 我们用一个 List来保存对象实例，用 Semaphore 实现限流器
 关键点：
     ObjPool 里面的 exec() 方法，这个方法里面实现了限流的功能
 exec() 的功能：
    1。 我们首先调用 acquire() 方法 (与之匹配的是在 finally 里面调用 release() 方法)
 例子：
     1。假设对象池的大小是 10，信号量的计数 器初始化为 10，
     2。那么前 10 个线程调用 acquire() 方法，都能继续执行
     3。相当于通过了信号灯， 而其他线程则会阻塞在 acquire() 方法上。
         对于通过信号灯的线程：
             1。我们为每个线程分配了一个 对象 t(这个分配工作是通过 pool.remove(0) 实现的)
             3。分配完之后会执行一个回调函数 func，而函数的参数正是前面分配的对象 t ;
             3。执行完回调函数之后，它们就会释放对象(这个释 放工作是通过 pool.add(t) 实现的)
             4。同时调用 release() 方法来更新信号量的计数器
     4。如果此 时信号量里计数器的值小于等于 0，那么说明有线程在等待，此时会自动唤醒等待的线程。

 问题：
    对象池的例子中Vector能否换成ArrayList？
     答案：
        不可以
     原因：
         1。Semaphore可以允许多个线程访问一个临界区
         2。那就意味着可能存在多个线程同时访问ArrayList
            ArrayList不是线程安全的
 注意：
     Semaphore
         优点：
            允许多个线程访问一个临界区，
         缺点：
             当多个线程进入临界区时，如果需要访问共享变量就会存在并发问题，所以必须加锁
 *
 *
 *
 *

 */
public class ObjPoolSemaphoreN16<T, R> {
    final List<T> pool;
    // 用信号量实现限流器
    final Semaphore sem;
    // 构造函数
    ObjPoolSemaphoreN16(int size, T t){
        pool = new Vector<T>(){};
        for(int i=0; i<size; i++){
            pool.add(t);
        }
        sem = new Semaphore(size);
    }
    // 利用对象池的对象，调用 func
    R exec(Function<T,R> func) throws InterruptedException {
        T t = null;
        sem.acquire();
        try {
            System.out.println(123);
            t = pool.remove(0); //拿出元素使用
            return func.apply(t); //使用元素
        } finally {
            pool.add(t); //使用完放进去
            sem.release();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // 创建对象池
        ObjPoolSemaphoreN16<Long, String> pool =
                new ObjPoolSemaphoreN16<Long, String>(10, 2l);
        // 通过对象池获取 t，之后执行
        for (int i=0;i<12;i++){
            System.out.println("---------------"+i);
            pool.exec(t -> {
                System.out.println(t);
                return t.toString();
            });
        }


    }

}

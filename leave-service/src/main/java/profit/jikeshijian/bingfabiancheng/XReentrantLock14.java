package profit.jikeshijian.bingfabiancheng;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 *
 *
 1。当线程 T1 执行到 ① 处时，已经获取到了锁 rtl ，
 2。当在 ① 处调用 get() 方法时，会在 ② 再次对锁 rtl 执行加锁操作
 3。此时，如果锁 rtl 是可重入的，那么线程 T1 可以再次加锁成功；
 4。如果锁 rtl 是不可重入的，那么线程 T1 此时会被阻塞。
 5。
 5。
 6。

 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
public class XReentrantLock14 {
    private final Lock rtl =
      new ReentrantLock();
    int value;
    public int get() {
        // 获取锁
        rtl.lock();        // ②
        try {
            return value;
        } finally {
            // 保证锁能释放
            rtl.unlock();
        }
    }
    public void addOne() {
        // 获取锁
        rtl.lock();
        try {
            value = 1 + get();// ①
        } finally {
            // 保证锁能释放
            rtl.unlock();
        }
    }
}

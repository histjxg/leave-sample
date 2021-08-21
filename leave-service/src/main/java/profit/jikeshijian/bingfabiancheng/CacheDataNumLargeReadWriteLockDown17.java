package profit.jikeshijian.bingfabiancheng;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 *
 以下代码来源自 ReentrantReadWriteLock 的官方示例，略做了改动。
 问题：锁的降级
 你会发现在代码1处，获取读锁的时候线程 还是持有写锁的，这种锁的降级是支持的。

 *
 *
 *
 *
 *
 *
 *
 */
public class CacheDataNumLargeReadWriteLockDown17 {
    Object data;
    volatile boolean cacheValid;
    final ReadWriteLock rwl = new ReentrantReadWriteLock();
    // 读锁
    final Lock r = rwl.readLock();
    // 写锁
    final Lock w = rwl.writeLock();

    void processCachedData() {
        // 获取读锁
        r.lock();
        if (!cacheValid) {
            // 释放读锁，因为不允许读锁的升级
            r.unlock();
            // 获取写锁
            w.lock();
            try {
                // 再次检查状态
                if (!cacheValid) {
                    // data = ...
                    cacheValid = true;
                }
                // 释放写锁前，降级为读锁
                // 降级是可以的
                r.lock(); //①
            } finally {
                // 释放写锁
                w.unlock();
            }
        }
        // 此处仍然持有读锁
        try {
            //use(data);
        } finally {
            r.unlock();
        }
    }


}

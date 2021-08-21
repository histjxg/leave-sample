package profit.jikeshijian.bingfabiancheng;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 *
 在1处获取读锁，在3处释放读锁，那是否可以在2处的下面增加验证缓存并更新缓存的逻辑呢?
 问题：锁的升级
    先是获取读锁，然后再升级为写锁
 结论：ReadWriteLock 并不支持这种升级。
分析：
     读锁还没有释放，此 时获取写锁，会导致写锁永久等待
     最终导致相关线程都被阻塞，永远也没有机会被唤醒。锁的 升级是不允许的，这个你一定要注意。
 *
 *
 *
 *
 *
 *
 *
 */
public class CacheNumLargeReadWriteLockUP17<K,V> {
    final Map<K, V> m = new HashMap<>();
    final ReadWriteLock rwl = new ReentrantReadWriteLock();
    final Lock r = rwl.readLock();
    final Lock w = rwl.writeLock();

    V get(K key) {
        V v = null;
        // 读缓存
        r.lock();         //①
        try {
            v = m.get(key);// ②
            if (v == null) {
                w.lock();
                try {
                    // 再次验证并更新缓存
                    // 省略详细代码
                } finally{
                    w.unlock();
                }
            }
        } finally {
            r.unlock();     //③
        }
        // 缓存中存在，返回
        if (v != null) {   //④
            return v;
        }
        // 缓存中不存在，查询数据库
        w.lock();         //⑤
        try {
            // 再次验证
            // 其他线程可能已经查询过数据库
            v = m.get(key); //⑥
            if (v == null) {  //⑦
                // 查询数据库
               // v = 省略代码无数
                m.put(key, v);
            }
        } finally {
            w.unlock();
        } return v;
    }

}

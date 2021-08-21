package profit.jikeshijian.bingfabiancheng;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 *
 *
 我们声明了一个 Cache<K, V> 类，其中类型参数 K 代表缓存里 key 的类型，V 代表缓存里 value 的类型
 缓存的数据保存在 Cache 类内部的 HashMap 里面，HashMap 不是线 程安全的
 这里我们使用读写锁 ReadWriteLock 来保证其线程安全
 ReadWriteLock 是一个接 口，它的实现类是 ReentrantReadWriteLock
 过名字你应该就能判断出来，它是支持可重入 的。下面我们通过 rwl 创建了一把读锁和一把写锁。

 *
 *
 Cache 这个工具类，我们提供了两个方法，一个是读缓存方法 get()
 另一个是写缓存方法 put()。读缓存需要用到读锁，读锁的使用和前面我们介绍的 Lock 的使用是相同的
 都是 try{}finally{}这个编程范式。写缓存则需要用到写锁，写锁的使用和读锁是类似的
 这样看来，读 写锁的使用还是非常简单的。
 *
 *
 *
 *
 *


 */


public class CacheNumNotLargeReadWriteLock17<K,V> {

    final Map<K, V> m = new HashMap<>();
    final ReadWriteLock rwl = new ReentrantReadWriteLock();
    // 读锁
    final Lock r = rwl.readLock();
    // 写锁
    final Lock w = rwl.writeLock();

    // 读缓存
    V get(K key) {
        r.lock();
        try {
            return m.get(key);
        } finally {
            r.unlock();
        }
    }

    // 写缓存
    V put(K key, V v) {
        w.lock();
        try {
            return m.put(key, v);
        } finally {
            w.unlock();
        }
    }

}

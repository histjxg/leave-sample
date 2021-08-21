package profit.jikeshijian.bingfabiancheng;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 *
 下面的这段代码实现了按需加载的功能，这里我们假设缓存的源头是数据库
 需要注意的 是，如果缓存中没有缓存目标对象，那么就需要从数据库中加载
 后写入缓存，写缓存需要用 到写锁，所以在代码中的5处，我们调用了 w.lock()来获取写锁。

 另外，还需要注意的是，在获取写锁之后，我们并没有直接去查询数据库，而是在代码67处，
 重新验证了一次缓存中是否存在，再次验证如果还是不存在，
 我们才去查询数据库并更新本地缓存。为什么我们要再次验证呢?

 原因：
 在高并发的场景下，有可能会有多线程竞争写锁
 假设缓存是空的，没有缓存任何东西， 如果此时有三个线程 T1、T2 和 T3 同时调用 get() 方法，并且参数 key 也是相同的
 那么它们会 同时执行到代码5处，但此时只有一个线程能够获得写锁
 假设是线程 T1，线程 T1 获取写锁之 后查询数据库并更新缓存，最终释放写锁。
 此时线程 T2 和 T3 会再有一个线程能够获取写锁，假 设是 T2，如果不采用再次验证的方式，此时 T2 会再次查询数据库
 T2 释放写锁之后，T3 也会 再次查询一次数据库
 而实际上线程 T1 已经把缓存的值设置好了，T2、T3 完全没有必要再次查 询数据库。

    目的
 所以，再次验证的方式，能够避免高并发场景下重复查询数据的问题。

 *
 *
 *
 *
 *
 *
 *
 */
public class CacheNumLargeReadWriteLock17<K,V> {
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

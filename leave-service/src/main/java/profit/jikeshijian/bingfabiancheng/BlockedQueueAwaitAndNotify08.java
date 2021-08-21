package profit.jikeshijian.bingfabiancheng;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 *
 *
 1.对于入队操作，如果队列已满，就需要等待直到队列不满，所以这里用了notFull.await();。
 2.对于出队操作，如果队列为空，就需要等待直到队列不空，所以就用了notEmpty.await();。
 3.如果入队成功，那么队列就不空了，就需要通知条件变量：队列不空notEmpty对应的等待队列。
 4.如果出队成功，那就队列就不满了，就需要通知条件变量：队列不满notFull对应的等待队列。


 await() 和前面我们提到的 wait() 语义是一样的；signal() 和前面我们提到的 notify() 语义是一样的。
 *
 *
 *
 *
 * @param <T>
 */
public class BlockedQueueAwaitAndNotify08<T> {
    final Lock lock =
            new ReentrantLock();
    // 条件变量：队列不满
    final Condition notFull =
            lock.newCondition();
    boolean notFullBoolean = false;

    // 条件变量：队列不空
    final Condition notEmpty =
            lock.newCondition();
    boolean notEmptyBoolean = false;


    // 入队
    void enq(T x) throws InterruptedException {
        lock.lock();
        try {
            while (!notEmptyBoolean){
                notFullBoolean=true;
                // 等待队列不满
                notFull.await();
            }
            // 省略入队操作...
            // 入队后, 通知可出队
            notEmpty.signal();
        }finally {
            lock.unlock();
        }
    }
    // 出队
    void deq() throws InterruptedException {
        lock.lock();
        try {
            while (!notFullBoolean){
                notEmptyBoolean=true;
                // 等待队列不空
                notEmpty.await();
            }
            // 省略出队操作...
            // 出队后，通知可入队
            notFull.signal();
        }finally {
            lock.unlock();
        }
    }
}

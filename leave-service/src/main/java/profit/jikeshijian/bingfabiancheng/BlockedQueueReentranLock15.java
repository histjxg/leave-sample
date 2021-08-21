package profit.jikeshijian.bingfabiancheng;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockedQueueReentranLock15 <T>{
    final Lock lock = new ReentrantLock();
    // 条件变量：队列不满
    final Condition notFull = lock.newCondition();
    // 条件变量：队列不空
    final Condition notEmpty = lock.newCondition();
    // 阻塞单列最大长度
    int capacity = 0;
    // 当前已经存在下标：入队
    int putIndex = 0;
    // 当前已经存在下标：出队
    int takeIndex = 0;
    // 元素总数
    int elementsSize = 0;
    // 元素数组
    Object[] items;


    // 构造方法
    //构造方法中根据外界输入的队列最大长度初始化了内部的元素数组。
    public BlockedQueueReentranLock15(int capacity) {
        this.capacity = capacity;
        items = new Object[capacity];
        System.out.println("capacity=" + capacity + ",items.size=" + items.length);
    }

    /**
     *
      入队
     首先获取可重入锁，如果加锁成功则进入临界区逻辑，否则尝试解锁。
     当队列已经满时，则进入阻塞状态，等待队列不满。
     如果队列不满则进行入队，当前下标的元素即为要入队的元素，元素总长度增1。
     *
     *

     */

    void enq(T x) {
        lock.lock();
        try {
            // 队列已满
            while (items.length == elementsSize) {
                // 等待队列不满
                notFull.await();
            }
            // 入队操作...
            items[putIndex] = x;
            if (++putIndex == items.length)
                putIndex = 0;
            ++elementsSize;
            // 入队后, 通知可出队
            notEmpty.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            System.out.println(x.toString() + "--入队完成");
        }
    }


    /**
     出队
     首先获取可重入锁，如果加锁成功则进入临界区逻辑，否则尝试解锁。
     当队列已经空，则进入阻塞状态，等待队列不空。
     如果队列不空则进行出队操作，先暂存当前下标的元素，并将当前下标的元素标记为空（NULL）；元素总长度减1，解锁后返回当前已经出队的元素。
     */
    T deq() {
        lock.lock();
        T x = null;
        try {
            // 队列已空
            while (items.length == 0) {
                // 等待队列不空
                notEmpty.await();
            }
            // 出队操作...
            x = (T) items[takeIndex];
            items[takeIndex] = null;
            if (++takeIndex == items.length)
                takeIndex = 0;
            elementsSize--;
            // 出队后，通知可入队
            notFull.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return x;
    }
    //获取对应下标的元素，如果元素不存在则返回空
    public T get(int index) {
        return (T) items[index];
    }

    public static void main(String[] args) {
        BlockedQueueReentranLock15<String> blockedQueue = new BlockedQueueReentranLock15<>(20);
        for (int i = 0; i < 20; i++) {
            blockedQueue.enq("snowalker:" + i);
        }

        System.out.println("入队结束:-------------------------");
        for (int i = 0; i < 20; i++) {
            System.out.println(blockedQueue.get(i));
        }

        for (int i = 0; i < 20; i++) {
            blockedQueue.deq();
        }
        System.out.println("出队结束:-------------------------");
        for (int i = 0; i < 20; i++) {
            System.out.println(blockedQueue.get(i));
        }




    }
}

package profit.jikeshijian.bingfabiancheng;

import java.util.concurrent.Semaphore;

/**
 *
 *
 *
 *
 * 实现思路：
 * 就像我们用互斥锁一样，只需要在进入临界区之前执行一下 down() 操作
 * 退出临 界区之前执行一下 up() 操作就可以了
 *acquire() 就是信号量里的 down() 操作
 *release() 就是信号量里的 up() 操作
 *up，down方法属于profit.jikeshijian.bingfabiancheng.Semaphore16
 *
 *
 *
 *
 *
 *
 信号量如何保证互斥的
 假设两个线程 T1 和 T2 同时访问 addOne() 方法，当它们同时调用 acquire() 的时候
 由于 acquire() 是一个原子操作，所以只能有一个线程(假设 T1)把信号量里的计数器减为 0
 另外一个线程(T2)则是将计数器减为 -1。对于线 程 T1，信号量里面的计数器的值是 0，大于等于 0，所以线程 T1 会继续执行
 对于线程 T2，信 号量里面的计数器的值是 -1，小于 0，按照信号量模型里对 down() 操作的描述，线程 T2 将被 阻塞。
 所以此时只有线程 T1 会进入临界区执行count+=1;
 当线程 T1 执行 release() 操作，也就是 up() 操作的时候，信号量里计数器的值是 -1，加 1 之后 的值是 0，小于等于 0
 按照信号量模型里对 up() 操作的描述，此时等待队列中的 T2 将会被唤 醒。
 于是 T2 在 T1 执行完临界区代码之后才获得了进入临界区执行的机会，从而保证了互斥 性。
 *
 *
 */
public class SemaphoreexclusionOne16 {
    static int count;
    // 初始化信号量
    static final Semaphore s = new Semaphore(1); // 用信号量保证互斥

    static void addOne() throws InterruptedException {
        s.acquire();
        try {
            count += 1;
        } finally {
            s.release();
        }
    }
}

package profit.jikeshijian.bingfabiancheng;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 我们可以用下面的示例代码来模拟该应用
 如果你执行下面的这段代码，会发现它永远执行不到最后一行。
 执行过程中没有任何异常，但是应用已经停止响应了。

 当出现类似问题：
 首选的诊断方法：是查看线程栈；
 分析
 1。下图是上面示例代码停止响应后的线程栈，你会发现线程池中的两个线程全部都阻塞在 l2.await();
 2。这行代码上了，也就是说，线程池里所有的线程都在等待L2阶段的任务执行完，
 问题：
    那L2阶段的子任务什么时候能够执行完呢？永远都没那一天了，为什么呢？
 原因：
    因为线程池里的线程都阻塞了，没有空闲的线程执行L2阶段的任务了。
 方法一：
    最简单粗暴的办法就是将线程池的最大线程数调大
     前提：
        如果能够确定任务的数量不是非常多的话，这个办法也是可行的，否则这个办法就行不通了

 方法二：
     这种问题通用的解决方案是为不同的任务创建不同的线程池
  L1阶段的任务和L2阶段的任务如果各自都有自己的线程池，就不会出现这种问题了。


 *
 *
 *
 *
 *
 *
 */
public class ThreadPoolDeadLockThree34 {
    public static void main(String[] args) throws InterruptedException {
        //L1、L2阶段共用的线程池
        ExecutorService es = Executors.
                newFixedThreadPool(2);
        //L1阶段的闭锁
        CountDownLatch l1 = new CountDownLatch(2);
        for (int i = 0; i < 2; i++) {
            System.out.println("L1");
            //执行L1阶段任务
            es.execute(() -> {
                //L2阶段的闭锁
                CountDownLatch l2 = new CountDownLatch(2);
                //执行L2阶段子任务
                for (int j = 0; j < 2; j++) {
                    es.execute(() -> {
                        System.out.println("L2");
                        l2.countDown();
                    });
                }
                //等待L2阶段任务执行完
                try {
                    l2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                l1.countDown();
            });
        }
        //等着L1阶段任务执行完
        l1.await();
        System.out.println("end");
    }
}

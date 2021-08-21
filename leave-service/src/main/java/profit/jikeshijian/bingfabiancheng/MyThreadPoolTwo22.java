package profit.jikeshijian.bingfabiancheng;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 *
 *
 1。在MyThreadPool的内部，我们维护了一个阻塞队列workQueue和一组工作线程
 2。工作线程的个数由构造函数中的poolSize来指定
 3。用户通过调用execute()方法来提交Runnable任务，execute()方法的内部实现仅仅是将任务加入到workQueue中
 4。MyThreadPool内部维护的工作线程会消费workQueue中的任务并执行任务
 5。相关的代码就是代码①处的while循环。
 6。





 *
 *
 *
 *
 *
 *
 *
 */

//简化的线程池，仅用来说明工作原理
public class MyThreadPoolTwo22 {
    //利用阻塞队列实现生产者-消费者模式  ？
    BlockingQueue<Runnable> workQueue;
    //保存内部工作线程
    List<WorkerThread> threads
            = new ArrayList<>();
    // 构造方法
    MyThreadPoolTwo22(int poolSize,
            BlockingQueue<Runnable> workQueue){
        this.workQueue = workQueue;
        // 创建工作线程
        for(int idx=0; idx<poolSize; idx++){
            WorkerThread work = new WorkerThread();
            work.start();
            threads.add(work);
        }
    }
    // 提交任务
    void execute(Runnable command) throws InterruptedException {
        workQueue.put(command);
    }
    // 工作线程负责消费任务，并执行任务
    class WorkerThread extends Thread{
        public void run() {
            //循环取任务并执行
            while(true){ //①
                Runnable task = null;
                try {
                    task = workQueue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                task.run();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        /** 下面是使用示例 **/
        // 创建有界阻塞队列
        BlockingQueue<Runnable> workQueue =
                new LinkedBlockingQueue<>(2);
        // 创建线程池
        MyThreadPoolTwo22 pool = new MyThreadPoolTwo22(
                10, workQueue);
        // 提交任务
        pool.execute(()->{
            System.out.println("hello");
        });
    }
}

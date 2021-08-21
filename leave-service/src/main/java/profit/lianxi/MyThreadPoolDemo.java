package profit.lianxi;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池的好处，不用new thread 不用垃圾回收器
 * 为什么用，线程池的好处
 * 线程池的工作主要是控制运行的线程数量，处理过程中将任务放入队列，然后在线程创建后启动这些任务
 * 如果数量超过了最大数量的线程排队等待，等其他线程执行完毕，两队列中取出任务来执行
 *
 * 他的主要特点为：线程复用；控制最大并发数，管理线程
 * 第一：降低资源，通过重复利用以创建的线程降低线程和销毁造成的消耗
 * 第二：提高响应速度，当任务到达时，任务可以不需要的等待线程创建就能立即执行
 * 第三：提高线程的可管理性，线程是稀缺资源，如果无限制的创建，不仅会消耗系统资源，还会降低系统的稳定性
 * 使用线程池的可以进行统一的分配，调优和监控
 * threadPoolExecutor：原理
 * 第四种使用java多线程的方式：线程池的方式
 */
public class MyThreadPoolDemo {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        //threadPoolInit();
       ExecutorService threadPool = new ThreadPoolExecutor(2,5,1L,TimeUnit.SECONDS,new LinkedBlockingQueue<>(3),Executors.defaultThreadFactory(),new ThreadPoolExecutor.DiscardPolicy());
        try{
          //  RejectedExecutionHandler rejected = null;
          // rejected = new ThreadPoolExecutor.AbortPolicy();//默认，队列满了丢任务抛出异常
         // rejected = new ThreadPoolExecutor.DiscardPolicy();//队列满了丢任务不异常
            // rejected = new ThreadPoolExecutor.DiscardOldestPolicy();//将最早进入队列的任务删，之后再尝试加入队列
          //rejected = new ThreadPoolExecutor.CallerRunsPolicy();//如果添加到线程池失败，那么主线程会自己去执行该任务

            //最大线程数怎么考虑：cpu密集型：Runtime.getRuntime().availableProcessors() cpu核数+1
            //IO密集性：测试环境配置：那种好用那种，由于IO密集性任务线程并不是一直在执行任务，则应配置尽可能多的线程，如cpu核数*2
            //
            for (int i = 1; i <=10; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务");
                    try {
                        TimeUnit.MILLISECONDS.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();

        }

    }

    private static void threadPoolInit() {
        //Array Arrays

        //Collection collections

        //Executor executors
        List<String> list = Arrays.asList("a","b","c");
        System.out.println(Runtime.getRuntime().availableProcessors());
        //ExecutorService threadPool = Executors.newFixedThreadPool(5); //一个池五个线程
        // ExecutorService threadPool = Executors.newSingleThreadExecutor();//一池一线程
        ExecutorService threadPool = Executors.newCachedThreadPool();//一个池n个线程

        //模拟10个用户来办理业务，每个用户就是一个来自外部的请求线程
        try{
            for (int i = 0; i <9 ; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务");
                    try {
                        TimeUnit.MILLISECONDS.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();

        }
    }
}

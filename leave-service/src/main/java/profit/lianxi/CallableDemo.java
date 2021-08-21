package profit.lianxi;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/*class MyThread implements Runnable{

    @Override
    public void run() {

    }
}*/

/**
 * FutureTask适配器，综合版本，Callable有返回值，thread启动线程；
 */
class MyThread implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("*****************come in callable");
        TimeUnit.SECONDS.sleep(2);
        return 1024;
    }
}

//
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //futureTask适配器  Callable传参数，并且实现了Runnable方法
        //将来的任务  面向接口编程，适配的原理
        //两个线程：一个main线程  一个AAfutureTask
        FutureTask<Integer> futureTask = new FutureTask(new MyThread());
        Thread t1 = new Thread(futureTask,"AA");
        t1.start();
     //   int result = futureTask.get();//要求获得callable的计算结果，如果没有计算完成就要去强求，会导致阻塞，直到计算完成

        System.out.println(Thread.currentThread().getName()+"******************");
        while (futureTask.isDone()){

        }

        System.out.println("***********result***********"+futureTask.get());

    }
}

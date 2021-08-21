package profit.jikeshijian.bingfabiancheng;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 *
 *
 *
 1。需要你注意的是Runnable接口的实现类Task声明了一个有参构造函数 Task(Result r)
 2。创建Task对象的时候传入了result对象，这样就能在类Task的run()方法中对result进行各种操作了
 3。result相当于主线程和子线程之间的桥梁，通过它主子线程可以共享数据。

 *
 *
 *
 *
 *
 *
 *
 */
public class ThreadPoolExecutorOne23 {
    public  void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor
                = Executors.newFixedThreadPool(1);
        // 创建Result对象r
        ResultOne23 r = new ResultOne23();
        r.setAAA("A");
        // 提交任务
        Future<ResultOne23> future =
                executor.submit(new Task(r), r);
        ResultOne23 fr = future.get();
        // 下面等式成立
        /**
             fr === r;
             fr.getAAA() === a;
             fr.getXXX() === x
         */


    }


    class Task implements Runnable{
        ResultOne23 r;
        //通过构造函数传入result
        Task(ResultOne23 r){
            this.r = r;
        }
        public void run() {
            //可以操作result
            String a = r.getAAA();
             r.setXXX("x");
        }
    }
}

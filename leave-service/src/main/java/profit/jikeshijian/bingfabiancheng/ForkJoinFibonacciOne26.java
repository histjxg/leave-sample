package profit.jikeshijian.bingfabiancheng;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 *
 *
 接下来我们就来实现一下
 如何用Fork/Join这个并行计算框架计算斐波那契数列
 1。首先我们需要创建一个分治任务线程池以及计算斐波那契数列的分治任务
 2。之后通过调用分治任务线程池的 invoke() 方法来启动分治任务
 3。由于计算斐波那契数列需要有返回值，所以Fibonacci 继承自RecursiveTask。
 4。分治任务Fibonacci 需要实现compute()方法，这个方法里面的逻辑和普通计算斐波那契数列非常类似
 5。区别之处在于计算 Fibonacci(n - 1) 使用了异步子任务，这是通过 f1.fork() 这条语句实现的。

 *
 *
 *
 *
 *
 *
 */
public class ForkJoinFibonacciOne26 {
    public static void main(String[] args){
        //创建分治任务线程池
        ForkJoinPool fjp =
                new ForkJoinPool(4);
        //创建分治任务
        Fibonacci fib =
                new Fibonacci(30);
        //启动分治任务
        Integer result =
                fjp.invoke(fib);
        //输出结果
        System.out.println(result);
    }
    //递归任务
    static class Fibonacci extends RecursiveTask<Integer> {
        final int n;
        Fibonacci(int n){this.n = n;}
        protected Integer compute(){
            if (n <= 1)
                return n;
            Fibonacci f1 =
                    new Fibonacci(n - 1);
            //创建子任务
            f1.fork();
            Fibonacci f2 =
                    new Fibonacci(n - 2);
            //等待子任务结果，并合并结果
            return f2.compute() + f1.join();
        }
    }
}

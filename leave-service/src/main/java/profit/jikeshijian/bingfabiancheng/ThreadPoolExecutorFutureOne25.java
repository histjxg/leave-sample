package profit.jikeshijian.bingfabiancheng;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 *
过程：
 1。用三个线程异步执行询价
 2。通过三次调用Future的get()方法获取询价结果
 3。之后将询价结果保存在数据库中。
 *
 *
 */

public class ThreadPoolExecutorFutureOne25 {
    public static void main(String[] args) {
        // 创建线程池
        ExecutorService executor = Executors.newFixedThreadPool(3);
        // 异步向电商S1询价
        Future<Integer> f1 = executor.submit(() -> getPriceByS1());
        // 异步向电商S2询价
        Future<Integer> f2 = executor.submit(() -> getPriceByS2());
        // 异步向电商S3询价
        Future<Integer> f3 = executor.submit(() -> getPriceByS3());

        // 获取电商S1报价并异步保存
        executor.execute(() -> {
            //>save(f2.get())
        });

        // 获取电商S2报价并异步保存
        executor.execute(() -> {
           // save(f2.get()
        });

        // 获取电商S3报价并异步保存
        executor.execute(() -> {
            //save(f3.get()
        });
    }

    public static Integer getPriceByS1() {
        return 10;
    }

    public static Integer getPriceByS2() {
        return 20;
    }

    public static Integer getPriceByS3() {
        return 30;
    }

}

package profit.jikeshijian.bingfabiancheng;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 *
 *
代码过程：
     1。增加一个阻塞队列，获取到S1、S2、S3的报价都进入阻塞队列
     2。然后在主线程中消费阻塞队列，这样就能保证先获取到的报价先保存到数据库了
 代码分析：
    下面的示例代码展示了如何利用阻塞队列实现先获取到的报价先保存到数据库。



 *
 *
 *
 */
public class ThreadPoolExecutorBlockingTwo25 {
    public static void main(String[] args) throws InterruptedException {
        // 创建线程池
        ExecutorService executor = Executors.newFixedThreadPool(3);
        // 异步向电商S1询价
        Future<Integer> f1 = executor.submit(() -> getPriceByS1());
        // 异步向电商S2询价
        Future<Integer> f2 = executor.submit(() -> getPriceByS2());
        // 异步向电商S3询价
        Future<Integer> f3 = executor.submit(() -> getPriceByS3());
        // 创建阻塞队列
        BlockingQueue<Integer> bq =
                new LinkedBlockingQueue<>();
        //电商S1报价异步进入阻塞队列
        executor.execute(()-> {
            try {
                bq.put(f1.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
        //电商S2报价异步进入阻塞队列
        executor.execute(()-> {
            try {
                bq.put(f2.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
        //电商S3报价异步进入阻塞队列
        executor.execute(()-> {
            try {
                bq.put(f3.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
        //异步保存所有报价
        for (int i=0; i<3; i++) {
            Integer r = bq.take();
            executor.execute(() -> {
                //save(r)
            });
        }
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

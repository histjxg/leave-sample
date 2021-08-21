package profit.jikeshijian.bingfabiancheng;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 *
过程：
1.我们没有指定completionQueue，因此默认使用无界的LinkedBlockingQueue
 2.之后通过CompletionService接口提供的submit()方法提交了三个询价操作
 3.这三个询价操作将会被CompletionService异步执行
 4.最后，我们通过CompletionService接口提供的take()方法获取一个Future对象（前面我们提到过，加入到阻塞队列中的是任务执行结果的Future对象）
 5.，调用Future对象的get()方法就能返回询价操作的执行结果了。
 *
 *
 */

public class ThreadPoolExecutorCompletionServiceThree25 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // 创建线程池
        ExecutorService executor =
                Executors.newFixedThreadPool(3);
        // 创建CompletionService
        CompletionService<Integer> cs = new ExecutorCompletionService<>(executor);
        // 异步向电商S1询价
        cs.submit(()->getPriceByS1());
        // 异步向电商S2询价
        cs.submit(()->getPriceByS2());
        // 异步向电商S3询价
        cs.submit(()->getPriceByS3());
        // 将询价结果异步保存到数据库
        for (int i=0; i<3; i++) {
            Integer r = cs.take().get();
            executor.execute(() -> {
                //save(r);
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

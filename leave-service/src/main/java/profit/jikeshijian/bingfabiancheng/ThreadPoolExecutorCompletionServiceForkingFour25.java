package profit.jikeshijian.bingfabiancheng;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 *
 下面的示例代码就展示了具体是如何实现的
 1。首先我们创建了一个线程池executor 、一个CompletionService对象cs和一个Future<Integer>类型的列表 futures
 2。每次通过调用CompletionService的submit()方法提交一个异步任务
 3。会返回一个Future对象，我们把这些Future对象保存在列表futures中
 4。通过调用 cs.take().get()，我们能够拿到最快返回的任务执行结果
 5。只要我们拿到一个正确返回的结果，就可以取消所有任务并且返回最终结果了

 *
 *
 */

public class ThreadPoolExecutorCompletionServiceForkingFour25 {
    public Integer  main(String[] args) throws InterruptedException, ExecutionException {
        // 创建线程池
        ExecutorService executor = Executors.newFixedThreadPool(3);
        // 创建CompletionService
        CompletionService<Integer> cs = new ExecutorCompletionService<>(executor);
        // 用于保存Future对象
        List<Future<Integer>> futures = new ArrayList<>(3);
        //提交异步任务，并保存future到futures
        futures.add(cs.submit(() -> geocoderByS1()));
        futures.add(cs.submit(() -> geocoderByS2()));
        futures.add(cs.submit(() -> geocoderByS3()));
        // 获取最快返回的任务执行结果
        Integer r = 0;
        try {
            // 只要有一个成功返回，则break
            for (int i = 0; i < 3; ++i) {
                r = cs.take().get();
                //简单地通过判空来检查是否成功返回
                if (r != null) {
                    break;
                }
            }
        } finally {
            //取消所有任务
            for (Future<Integer> f : futures)
                f.cancel(true);
        }
        // 返回结果
        return r;
    }

    public static Integer geocoderByS1() {
        return 10;
    }

    public static Integer geocoderByS2() {
        return 20;
    }

    public static Integer geocoderByS3() {
        return 30;
    }

}

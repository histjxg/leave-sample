package profit.jikeshijian.bingfabiancheng;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 *
 *
 下面是代码实现
 你先略过runAsync()、supplyAsync()、thenCombine()这些不太熟悉的方法
 1.需手工维护线程，没有繁琐的手工维护线程的工作，给任务分配线程的工作也不需要我们关注；
 2.语义更清晰
    例如 f3 = f1.thenCombine(f2, ()->{}) 能够清晰地表述“任务3要等待任务1和任务2都完成后才能开始”；
 3.代码更简练并且专注于业务逻辑，几乎所有代码都是业务逻辑相关的。
 *
 *
 *
 *
 *
 *
 *
 */
public class CompletableFutureBoilWater24 {
    public  void boilWater() {
        //任务1：洗水壶->烧开水
        CompletableFuture<Void> f1 =
                CompletableFuture.runAsync(()->{
                    System.out.println("T1:洗水壶...");
                    sleep(1, TimeUnit.SECONDS);

                    System.out.println("T1:烧开水...");
                    sleep(15, TimeUnit.SECONDS);
                });
        //任务2：洗茶壶->洗茶杯->拿茶叶
        CompletableFuture<String> f2 =
                CompletableFuture.supplyAsync(()->{
                    System.out.println("T2:洗茶壶...");
                    sleep(1, TimeUnit.SECONDS);

                    System.out.println("T2:洗茶杯...");
                    sleep(2, TimeUnit.SECONDS);

                    System.out.println("T2:拿茶叶...");
                    sleep(1, TimeUnit.SECONDS);
                    return "龙井";
                });
        //任务3：任务1和任务2完成后执行：泡茶
        CompletableFuture<String> f3 =
                f1.thenCombine(f2, (__, tf)->{
                    System.out.println("T1:拿到茶叶:" + tf);
                    System.out.println("T1:泡茶...");
                    return "上茶:" + tf;
                });
        //等待任务3执行结果
        System.out.println(f3.join());
    }

    //等待任务3执行结果


    void sleep(int t, TimeUnit u) {
        try {
            u.sleep(t);
        }catch(InterruptedException e){}
    }

    public static void main(String[] args) {
        CompletableFutureBoilWater24 completableFutureBoilWater24 =new CompletableFutureBoilWater24();
        completableFutureBoilWater24.boilWater();
    }
}

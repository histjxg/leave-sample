package profit.jikeshijian.bingfabiancheng;

public class ThreadPoolPDOrdersOptimisedTwo19 {
    /**
     *
     *
     *
     *
     下面的代码就是用线程池优化后的
     1。我们首先创建了一个固定大小为 2 的线程池，之后在 while 循环里重复利用。
     2。一切看上去都很顺利，但是有个问题好像无解了
     3。那就是主线程如何知 道 getPOrders() 和 getDOrders() 这两个操作什么时候执行完
     4。前面主线程通过调用线程 T1 和 T2 的join() 方法来等待线程 T1 和 T2 退出
     问题
     5。但是在线程池的方案里，线程根本就不会退出，所以 join() 方法已经失效了。

     创建 2 个线程的线程池
    Executor executor = Executors.newFixedThreadPool(2);
    while(存在未对账订单){
        // 查询未对账订单
        executor.execute(() -> {
            pos = getPOrders();
        });
        // 查询派送单
        executor.execute(() -> {
            dos = getDOrders();
        });

        ？？如何实现等待？？

        // 执行对账操作
        diff = check(pos, dos);
        // 差异写入差异库
        save(diff);
    }
    *
     */


}

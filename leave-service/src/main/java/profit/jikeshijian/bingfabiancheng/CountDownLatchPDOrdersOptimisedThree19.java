package profit.jikeshijian.bingfabiancheng;

public class CountDownLatchPDOrdersOptimisedThree19 {

    /**
     *
     下面的代码示例中
     1。在 while 循环里 面，我们首先创建了一个CountDownLatch
     2。计数器的初始值等于2，之后在pos = getPOrders();和dos = getDOrders()
     3。两条语句的后面对计数器执行减1操作，这个对计数器减1的操作 是通过调用latch.countDown() 来实现的。
     4。在主线程中，我们通过调用latch.await() 来实现对计数器等于 0 的等待。




    // 创建 2 个线程的线程池
    Executor executor =
            Executors.newFixedThreadPool(2);
    while(存在未对账订单){
        // 计数器初始化为 2
        CountDownLatch latch =
                new CountDownLatch(2);
        // 查询未对账订单
        executor.execute(()-> {
            pos = getPOrders();
            latch.countDown();
        });
        // 查询派送单
        executor.execute(()-> {
            dos = getDOrders();
            latch.countDown();
        });

        // 等待两个查询操作结束
        latch.await();

        // 执行对账操作
        diff = check(pos, dos);
        // 差异写入差异库
        save(diff);
    }

     */

}

package profit.jikeshijian.bingfabiancheng;

public class ParallelPDOrdersOptimisedOne19 {
    /**
     *
     *
    思路：
     1。创建了两个线程 T1 和 T2，并行执行查询未对账订单 getPOrders() 和查询派送单 getDOrders() 这两个操作
     2。在主线程 中执行对账操作 check() 和差异写入 save() 两个操作。
     注意的是：
        1。主线程需要等待线程 T1 和 T2 执行完才能执行 check() 和 save() 这两个操作
        2。为此我们通过调用 T1.join() 和 T2.join() 来实现等待
        3。当 T1 和 T2 线程退出时，调用 T1.join() 和 T2.join() 的主线程就会从阻塞态被唤醒
        4。从而执行之后的 check() 和 save()。




     while(存在未对账订单){
        // 查询未对账订单
        Thread T1 = new Thread(()->{
            pos = getPOrders();
        });
        T1.start();
        // 查询派送单
        Thread T2 = new Thread(()->{
            dos = getDOrders();
        });
        T2.start();
        // 等待 T1、T2 结束
        T1.join();
        T2.join();
        // 执行对账操作
        diff = check(pos, dos);
        // 差异写入差异库
        save(diff);
    }

     **/

}

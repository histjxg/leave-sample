package profit.jikeshijian.bingfabiancheng;

public class CyclicBarrierPDOrdersOptimisedFour19 {
    /**
     *

     在下面的代码中
     1。我们首先创建了一个计数器初始值为 2 的 CyclicBarrier
         注意：
             创建 CyclicBarrier 的时候，我们还传入了一个回调函数，当计数器减到 0 的时候
             会调用这个回调函数
     2。线程 T1 负责查询订单，当查出一条时，调用 barrier.await()来将计数器减 1，同时等待计数器变成 0
     3。线程 T2 负责查询派送单，当查出一条时，也调用 barrier.await() 来将计数器减1，同时等待计数器变成0
     4。当T1和T2都调用 barrier.await() 的时候，计数器会减到0
     5。此时T1和T2就可以执行下一条语句了，同时 会调用 barrier 的回调函数来执行对账操作。
     注意
     CyclicBarrier 的计数器有自动重置的功能，当减到 0 的时候，会自动重置设置的初始值。
     '这个功能用起来实在是太方便了
     7。







    // 订单队列
    Vector<P> pos;
    // 派送单队列
    Vector<D> dos;
    // 执行回调的线程池
    Executor executor =
            Executors.newFixedThreadPool(1);
    final CyclicBarrier barrier =
            new CyclicBarrier(2, ()->{
                executor.execute(()->check());
            });

    void check(){
        P p = pos.remove(0);
        D d = dos.remove(0);
        // 执行对账操作
        diff = check(p, d);
        // 差异写入差异库
        save(diff);
    }

    void checkAll(){
        // 循环查询订单库
        Thread T1 = new Thread(()->{
            while(存在未对账订单){
                // 查询订单库
                pos.add(getPOrders());
                // 等待
                barrier.await();
            }
        });
        T1.start();
        // 循环查询运单库
        Thread T2 = new Thread(()->{
            while(存在未对账订单){
                // 查询运单库
                dos.add(getDOrders());
                // 等待
                barrier.await();
            }
        });
        T2.start();
    }

     */

}

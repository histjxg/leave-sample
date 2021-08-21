package profit.jikeshijian.bingfabiancheng;

public class SerialPDOrdersOptimisedOne19 {

    /**
    核心功能：
         1。在一个单线程里面循环查询订单
         2。派送单，然后执行对账，最后将写入差异库

        while(存在未对账订单){
            // 查询未对账订单
            pos = getPOrders();
            // 查询派送单
            dos = getDOrders();
            // 执行对账操作
            diff = check(pos, dos);
            // 差异写入差异库
            save(diff);
        }
     *
     */

}

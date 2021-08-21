package profit.jikeshijian.bingfabiancheng;

/**
 *
 *
 思考：
     1。“同时申请”这个操作是一个临界区，我们也需要一个角色（Java 里面的类）来管理这个临界区
     2。我们就把这个角色定为 Allocator。它有两个重要功能，
            分别是：同时申请资源 apply() 和同时释放资源 free()。
 具体实现：
     1。账户 Account 类里面持有一个 Allocator 的单例（必须是单例，只能由一个人来分配资源）
     2。当账户 Account 在执行转账操作的时候，
     3。首先向 Allocator 同时申请转出账户和转入账户这两个资源，成功后再锁定这两个资源
     4。当转账操作执行完，释放锁之后
     5。我们需通知 Allocator 同时释放转出账户和转入账户这两个资源
 *
 *
 *
 */
public class AccountDeadLockDestroyHaveAndWait05 {
    // actr 应该为单例
    private AllocatorDeadLock05 actr;
    private int balance;
    // 转账
    void transfer(AccountDeadLockDestroyHaveAndWait05 target, int amt){
        // 一次性申请转出账户和转入账户，直到成功
        while(!actr.apply(this, target));
        try{
            // 锁定转出账户
            synchronized(this){
                // 锁定转入账户
                synchronized(target){
                    if (this.balance > amt){
                        this.balance -= amt;
                        target.balance += amt;
                    }
                }
            }
        } finally {
            actr.free(this, target);
        }
    }
}

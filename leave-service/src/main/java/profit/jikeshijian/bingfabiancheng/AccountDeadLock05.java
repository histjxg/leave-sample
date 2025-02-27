package profit.jikeshijian.bingfabiancheng;

public class AccountDeadLock05 {
    private int balance;

    /**
     *
     分析代码可能执行的过程：
         1。假设线程 T1 执行账户 A 转账户 B 的操作，账户 A.transfer(账户 B)
         2。同时线程 T2 执行账户 B 转账户 A 的操作，账户 B.transfer(账户 A)
         3。当 T1 和 T2 同时执行完①处的代码时，T1 获得了账户 A 的锁（对于 T1，this 是账户 A）
         4。而 T2 获得了账户 B 的锁（对于 T2，this 是账户 B）
         5。之后 T1 和 T2 在执行②处的代码时，T1 试图获取账户 B 的锁时，发现账户 B 已经被锁定（被 T2 锁定），所以 T1 开始等待
         6。T2 则试图获取账户 A 的锁时，发现账户 A 已经被锁定（被 T1 锁定），所以 T2 也开始等待
     现象：
        于是 T1 和 T2 会无期限地等待下去
     */
    // 转账
    void transfer(AccountDeadLock05 target, int amt){
        // 锁定转出账户
        synchronized(this) {
            // 锁定转入账户
            synchronized(target) {
                if (this.balance > amt) {
                    this.balance -= amt;
                    target.balance += amt;
                }
            }
        }
    }
}

package profit.jikeshijian.bingfabiancheng;

public class AccountAtomicRelatedSynchronized04 {
    private int balance;
    // 转账
    synchronized void transfer(
            AccountAtomicRelatedSynchronized04 target, int amt){
        if (this.balance > amt) {
            this.balance -= amt;
            target.balance += amt;
        }
    }
    //分析
    //在这段代码中，临界区内有两个资源，分别是转出账户的余额 this.balance 和转入账户的余额 target.balance，并且用的是一把锁 this
    //符合我们前面提到的，多个资源可以用一把锁来保护，这看上去完全正确呀。真的是这样吗？
    //可惜，这个方案仅仅是看似正确，为什么呢？

    //问题就出在 this 这把锁上，this 这把锁可以保护自己的余额 this.balance
    //却保护不了别人的余额 target.balance，就像你不能用自家的锁来保护别人家的资产，也不能用自己的票来保护别人的座位一样。
//模拟场景
    //假设有 A、B、C 三个账户，余额都是 200 元，我们用两个线程分别执行两个转账操作
    //账户 A 转给账户 B 100 元，账户 B 转给账户 C 100 元，
    //最后我们期望的结果应该是账户 A 的余额是 100 元，账户 B 的余额是 200 元， 账户 C 的余额是 300 元。
    //



/*
    分析执行过程：
        1。假设线程 1 执行账户 A 转账户 B 的操作，线程 2 执行账户 B 转账户 C 的操作
        2。这两个线程分别在两颗 CPU 上同时执行
    问题：
        这两个线程不是互斥的，可以同时进入临界区 transfer()
    原因：
        1。因为线程 1 锁定的是账户 A 的实例（A.this）
        2。而线程 2 锁定的是账户 B 的实例（B.this）
    现象：
        1。线程 1 和线程 2 都会读到账户 B 的余额为 200
        2。导致最终账户 B 的余额可能是 300，可能是 100，就是不可能是 200。
            100：线程 1 后于线程 2 写 B.balance，线程 2 写的 B.balance 值被线程 1 覆盖
            300：线程 1 先于线程 2 写 B.balance，线程 1 写的 B.balance 值被线程 2 覆盖
*/



}

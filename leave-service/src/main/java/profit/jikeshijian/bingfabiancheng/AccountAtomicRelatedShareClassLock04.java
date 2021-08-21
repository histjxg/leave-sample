package profit.jikeshijian.bingfabiancheng;

public class AccountAtomicRelatedShareClassLock04 {
    private int balance;
    /*
    用 Account.class 作为共享的锁，不用担心它的唯一性
    原因：
        1。Account.class 是所有 Account 对象共享的
        2。且这个对象是 Java 虚拟机在加载 Account 类的时候创建的
    优点：
        我们就无需在创建 Account 对象时传入了，代码更简单*/


    // 转账
    void transfer(AccountAtomicRelatedShareClassLock04 target, int amt){
        synchronized(AccountAtomicRelatedShareClassLock04.class) {
            if (this.balance > amt) {
                this.balance -= amt;
                target.balance += amt;
            }
        }
    }
}

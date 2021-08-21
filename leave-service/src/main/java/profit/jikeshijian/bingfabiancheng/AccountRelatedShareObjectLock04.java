package profit.jikeshijian.bingfabiancheng;

public class AccountRelatedShareObjectLock04 {
    //Account 默认构造函数变为 private，同时增加一个带 Object lock 参数的构造函数
    //创建 Account 对象时，传入相同的 lock，这样所有的 Account 对象都会共享这个 lock 了
/*/缺点：
    1。要求在创建 Account 对象的时候必须传入同一个对象
        原因：
            如果创建 Account 对象时，传入的 lock 不是同一个对象，那可就惨了，会出现锁自家门来保护他家资产的荒唐事
    2。传入共享的 lock 真的很难
        原因：
            创建 Account 对象的代码很可能分散在多个工程中
            */
    private Object lock;
    private int balance;
    private AccountRelatedShareObjectLock04(){}
    // 创建 Account 时传入同一个 lock 对象
    public AccountRelatedShareObjectLock04(Object lock) {
        this.lock = lock;
    }
    // 转账
    void transfer(AccountRelatedShareObjectLock04 target, int amt){
        // 此处检查所有对象共享的锁
        synchronized(lock) {
            if (this.balance > amt) {
                this.balance -= amt;
                target.balance += amt;
            }
        }
    }
}

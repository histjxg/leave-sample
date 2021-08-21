package profit.jikeshijian.bingfabiancheng;

public class AccountAtomicRelatedQues04 {
    //说明：
//例如银行业务里面的转账操作，账户 A 减少 100 元，账户 B 增加 100 元。
//这两个账户就是有关联关系的。那对于像转账这种有关联关系的操作，我们应该怎么去解决呢？
//先把这个问题代码化。我们声明了个账户类：Account，该类有一个成员变量余额：balance，还有一个用于转账的方法：transfer()
//然后怎么保证转账操作 transfer() 没有并发问题呢？
//演进：参考：  AccountRelatedSynchronized04
    private int balance;
    // 转账
    void transfer(
            AccountAtomicRelatedQues04 target, int amt){
        if (this.balance > amt) {
            this.balance -= amt;
            target.balance += amt;
        }
    }
}

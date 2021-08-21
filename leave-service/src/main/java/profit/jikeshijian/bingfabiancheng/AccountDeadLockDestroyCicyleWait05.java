package profit.jikeshijian.bingfabiancheng;
/**
 *
 *
 说明：
     1。①~⑥处的代码对转出账户（this）和转入账户（target）排序，
     2。然后按照序号从小到大的顺序锁定账户
 *
 *
 *
 */
public class AccountDeadLockDestroyCicyleWait05 {
    private int id;
    private int balance;
    // 转账
    void transfer(AccountDeadLockDestroyCicyleWait05 target, int amt){
        AccountDeadLockDestroyCicyleWait05 left = this ;     //  ①
        AccountDeadLockDestroyCicyleWait05 right = target;    //②
        if (this.id > target.id) { //③
            left = target;         //  ④
            right = this;          //  ⑤
        }                        //  ⑥
        // 锁定序号小的账户
        synchronized(left){
            // 锁定序号大的账户
            synchronized(right){
                if (this.balance > amt){
                    this.balance -= amt;
                    target.balance += amt;
                }
            }
        }
    }
}

package profit.jikeshijian.bingfabiancheng;

public class AccountDeadLockDestroyAlone {
    /**
     *
     本意是通过破坏不可抢占条件来避免死锁问题，但是它的实现中有一个致命的问题
     那就是：
     1。while(true) 没有break条件，从而导致了死循环
     2。除此之外，这个实现虽然不存在死锁问题，但还是存在活锁问题的
     3。解决活锁问题很简单，
     方法
        只需要随机等待一小段时间就可以了。
     具体实现
     修复后的代码如下所示，我仅仅修改了两个地方
     1。一处是转账成功之后break
     2。另一处是在while循环体结束前增加了Thread.sleep(随机时间)。
    private int balance;
    private final Lock lock
            = new ReentrantLock();
    // 转账
    void transfer(Account tar, int amt){
        while (true) {
            if(this.lock.tryLock()) {
                try {
                    if (tar.lock.tryLock()) {
                        try {
                            this.balance -= amt;
                            tar.balance += amt;
                            //新增：退出循环
                            break;
                        } finally {
                            tar.lock.unlock();
                        }
                    }//if
                } finally {
                    this.lock.unlock();
                }
            }//if
            //新增：sleep一个随机时间避免活锁
            Thread.sleep(随机时间);
        }//while
    }//transfer

     */
}

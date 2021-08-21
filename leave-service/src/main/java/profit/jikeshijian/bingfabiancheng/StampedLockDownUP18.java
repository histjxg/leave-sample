package profit.jikeshijian.bingfabiancheng;

import java.util.concurrent.locks.StampedLock;

/**
 *
 *
 StampedLock 支持锁的降级(通过 tryConvertToReadLock() 方法实现)和
 升级(通过 tryConvertToWriteLock() 方法实现)但是建议你要慎重使用
 下面的代码也源自 Java 的官方示 例，我仅仅做了一点修改，隐藏了一个 Bug，
 你来看看 Bug 出在哪里吧

 答案：
 1。在锁升级成功的时候，
 2。最后没有释放最新的写锁，
 3。可以在if块的break上加个stamp=ws进 行释放
 bug是tryConvertToWriteLock返回的write stamp没有重新赋值给stamp

 *
 *
 *
 *
 *
 */
public class StampedLockDownUP18 {
    private double x, y;
    final StampedLock sl = new StampedLock();

    //
    void moveIfAtOrigin(double newX, double newY) {
        long stamp = sl.readLock();
        try {
            while (x == 0.0 && y == 0.0) {
                long ws = sl.tryConvertToWriteLock(stamp); //升级
                if (ws != 0L) {
                    x = newX;
                    y = newY;
                    break;
                } else {
                    sl.unlockRead(stamp);
                    stamp = sl.writeLock();
                }
            }
        } finally {
            sl.unlock(stamp);
        }
    }
}


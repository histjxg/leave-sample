package profit.jikeshijian.bingfabiancheng;

import java.util.concurrent.locks.StampedLock;

/**
 *
 *
 下面这段代码是出自 Java SDK 官方示例，并略做了修改
 。在 distanceFromOrigin() 这个方法 中，首先通过调用 tryOptimisticRead()
 获取了一个 stamp，这里的 tryOptimisticRead() 就是我们 前面提到的乐观读。
 之后将共享变量 x 和 y 读入方法的局部变量中，不过需要注意的是
 由于 tryOptimisticRead() 是无锁的，所以共享变量 x 和 y 读入方法局部变量时
 x 和 y 有可能被其他 线程修改了
 因此最后读完之后，还需要再次验证一下是否存在写操作，这个验证操作是通过调 用 validate(stamp) 来实现的。
 *
 *
 *
 *
 升级锁的过程：
 1。如果执行乐观读操作的期间，存在写操作，会把乐观读升级为悲观读 锁
 2。这个做法挺合理的，否则你就需要在一个循环里反复执行乐观读
 3。直到执行乐观读操作的期 间没有写操作(只有这样才能保证 x 和 y 的正确性和一致性)
 4。而循环读会浪费大量的 CPU
 5。升级为悲观读锁，代码简练且不易出错，建议你在具体实践时也采用这样的方法。



 StampedLock 读模板:模版
         final StampedLock sl =new StampedLock();

         // 乐观读
         long stamp =sl.tryOptimisticRead();
         // 读入方法局部变量
         ......
         // 校验 stamp
         if (!sl.validate(stamp)){
             // 升级为悲观读锁
             stamp = sl.readLock();
             try {
                 // 读入方法局部变量
                 .....
             } finally {
                 // 释放悲观读锁
                 sl.unlockRead(stamp);
             }
         }
         // 使用方法局部变量执行业务操作
         ......


 StampedLock 写模板:
     long stamp = sl.writeLock();
     try {
         // 写共享变量
         ......
     } finally {
        sl.unlockWrite(stamp);
     }






 *
 *
 *
 *
 */
public class PointStampedLock18 {
        private int x, y;
        final StampedLock sl =
                new StampedLock();
        // 计算到原点的距离
        double distanceFromOrigin() {
            // 乐观读
            long stamp =
                    sl.tryOptimisticRead();
            // 读入局部变量，
            // 读的过程数据可能被修改
            int curX = x, curY = y;
            // 判断执行读操作期间，
            // 是否存在写操作，如果存在，
            // 则 sl.validate 返回 false
            if (!sl.validate(stamp)){
                // 升级为悲观读锁
                stamp = sl.readLock();
                try {
                    curX = x;
                    curY = y;
                } finally {
                    // 释放悲观读锁
                    sl.unlockRead(stamp);
                }
            }
            return Math.sqrt(curX * curX + curY * curY);
        }

}

package profit.jikeshijian.bingfabiancheng;

import java.util.concurrent.atomic.AtomicLong;

/**
 *
 *
 * 1。我们在 setUpper() 和 setLower() 中增加了参数校验，这乍看上去好像是对的
 *2。但其实存在并发问题，问题在于存在竞态条件
 *3。这里我顺便插一句，其实当你看到代码里出现 if 语句的时候，就应该立刻意识到可能存在竞态条件。
 *
 *模拟：
 * 1。假设库存的下限和上限分别是 (2,10)，线程 A 调用 setUpper(5) 将上限设置为 5
 * 2。线程 B 调用 setLower(7) 将下限设置为 7，如果线程 A 和线程 B 完全同时执行
 * 3。你会发现线程 A 能够通过参数校验，因为这个时候，下限还没有被线程 B 设置，还是 2，而 5>2
 * 4。线程 B 也能够通过参数校验，因为这个时候，上限还没有被线程 A 设置，还是 10，而 7<10
 * 5。当线程 A 和线程 B 都通过参数校验后，就把库存的下限和上限设置成 (7, 5) 了
 * 问题：
        显然此时的结果是不符合库存下限要小于库存上限这个约束条件的。

 思考：
 1。在没有识别出库存下限要小于库存上限这个约束条件之前
 2。我们制定的并发访问策略是利用原子类，但是这个策略
 3。完全不能保证库存下限要小于库存上限这个约束条件
 4。所以说，在设计阶段，我们一定要识别出所有共享变量之间的约束条件
 5。如果约束条件识别不足，很可能导致制定的并发访问策略南辕北辙。
 *
 *
 *
 */
public class SafeShareVarAddCondtionWM12 {
    // 库存上限
    private final AtomicLong upper =
            new AtomicLong(0);
    // 库存下限
    private final AtomicLong lower =
            new AtomicLong(0);
    // 设置库存上限
    void setUpper(long v){
        // 检查参数合法性
        if (v < lower.get()) {
            throw new IllegalArgumentException();
        }
        upper.set(v);
    }
    // 设置库存下限
    void setLower(long v){
        // 检查参数合法性
        if (v > upper.get()) {
            throw new IllegalArgumentException();
        }
        lower.set(v);
    }
    // 省略其他业务代码
}

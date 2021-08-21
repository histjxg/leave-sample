package profit.jikeshijian.bingfabiancheng;

import java.util.concurrent.atomic.AtomicLong;

/**
 *
 *说明
     在类 SafeWM 中，声明了两个成员变量 upper 和 lower，
        分别代表库存上限和库存下限，
     这两个变量用了 AtomicLong 这个原子类，
    原子类是线程安全的，所以这两个成员变量的 set 方法就不需要同步了
 *
 *
 *
 * 问题：
 * 1。忽视了一个约束条件，就是库存下限要小于库存上限，这个约束条件能够直接加到上面的 set 方法上吗？
 * 演进一
 * 参考SafeShareVarAddCondtionWM12
 *
 *
 */
public class SafeShareVarCondtionWM12 {
    // 库存上限
    private final AtomicLong upper =
            new AtomicLong(0);
    // 库存下限
    private final AtomicLong lower =
            new AtomicLong(0);
    // 设置库存上限
    void setUpper(long v){
        upper.set(v);
    }
    // 设置库存下限
    void setLower(long v){
        lower.set(v);
    }
    // 省略其他业务代码
}

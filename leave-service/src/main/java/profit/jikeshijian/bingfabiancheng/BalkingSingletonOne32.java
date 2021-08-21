package profit.jikeshijian.bingfabiancheng;

/**
 *
 *
 *
 所以可以用Balking模式来实现线程安全的单例模式，下 面的示例代码是其实现
 1。这个实现虽然功能上没有问题，但是性能却很差，
 2。因为互斥锁synchronized将 getInstance()方法串行化了，那有没有办法可以优化一下它的性能呢?
 3。
 4。
 *
 *
 *
 */
public class BalkingSingletonOne32 {
    private static BalkingSingletonOne32 singleton; //构造方法私有化

    private BalkingSingletonOne32() {
    } //获取实例(单例)

    public synchronized static BalkingSingletonOne32 getInstance() {
        if (singleton == null) {
            singleton = new BalkingSingletonOne32();
        }
        return singleton;
    }
}

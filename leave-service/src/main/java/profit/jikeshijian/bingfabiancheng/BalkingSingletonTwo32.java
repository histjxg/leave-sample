package profit.jikeshijian.bingfabiancheng;

/**
 *
 *
 *
 那就是经典的双重检查(Double Check)方案，下面的示例代码是其详细实现
 1。双重 检查方案中，一旦Singleton对象被成功创建之后，就不会执行synchronized(Singleton.class){}相关的代 码，
 2。也就是说，此时getInstance()方法的执行路径是无锁的，从而解决了性能问题。不过需要你注意的是， 这个方案中使用了volatile来禁止编译优化
 3。
 4。
 *
 *
 *
 */
public class BalkingSingletonTwo32 {
    private static BalkingSingletonTwo32 singleton; //构造方法私有化

    private BalkingSingletonTwo32() {
    } //获取实例(单例)

    public synchronized static BalkingSingletonTwo32 getInstance() {
        //第一次检查
        if (singleton == null) {
            synchronized (BalkingSingletonTwo32.class) { //获取锁后二次检查 if(singleton==null){
                singleton = new BalkingSingletonTwo32();
            }
        }
        return singleton;

    }
}

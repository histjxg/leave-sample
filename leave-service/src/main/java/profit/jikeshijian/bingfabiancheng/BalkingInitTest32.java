package profit.jikeshijian.bingfabiancheng;

/**
 *

 Balking模式有一个非常典型的应用场景就是单次初始化,下面的示例代码是它的实现。
 1.这个实现方案中， 我们将init()声明为一个同步方法，这样同一个时刻就只有一个线程能够执行init()方法
 2.init()方法在第一次 执行完时会将inited设置为true，这样后续执行init()方法的线程就不会再执行doInit()了。


 *
 *
 *
 *
 *
 *
 */
public class BalkingInitTest32 {
    boolean inited = false;
    synchronized void init() {
        if (inited) {
            return;
        } //省略doInit的实现
        //doInit();
        inited=true;
    }
}

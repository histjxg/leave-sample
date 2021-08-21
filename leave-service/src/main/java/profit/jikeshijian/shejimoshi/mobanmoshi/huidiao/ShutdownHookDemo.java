package profit.jikeshijian.shejimoshi.mobanmoshi.huidiao;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: huangxiaogen
 * @Date: 2020/07/18/下午7:56
 * @Description:
 */

/**
 *
 *我们再来看 addShutdownHook() 的代码实现，
 * 1.从代码中我们可以发现，有关 Hook 的逻辑都被封装到 ApplicationShutdownHooks 类 中了。
 * 2.当应用程序关闭的时候，JVM 会调用这个类的 runHooks() 方法，创建多个线程， 并发地执行多个 Hook
 * 3.我们在注册完 Hook 之后，并不需要等待 Hook 执行完成，所以，这也算是一种异步回调。
 * 4.
 *
 *
 *
 */
public class ShutdownHookDemo {
    private static class ShutdownHook extends Thread {
        @Override
        public void run(){
            System.out.println("I am called during shutting down.");
        }
    }

    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new ShutdownHook());
    }
}

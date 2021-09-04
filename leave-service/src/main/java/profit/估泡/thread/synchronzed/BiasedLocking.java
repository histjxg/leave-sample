package profit.估泡.thread.synchronzed;

import org.openjdk.jol.info.ClassLayout;

/**
 * 轻量级锁
 * 上面这个程序只有一个线程去调用sync方法，故而讲道理应该是偏向锁，但是此时却是轻量级锁
 *
 * 而且你会发现最后输出的结果（第一个字节）依 然是00000001和无锁的时候一模一样，其实这是因为虚拟机在启动的时候对于偏向锁有延迟，
 *
 * 比如把上述代码当中加上 睡眠5秒的代码,结果就会不一样了，
 * jvm配置了参数
 */
public class BiasedLocking {
    public static void main(String[] args) {
        //-XX:+UseBiasedLocking -XX:BiasedLockingStartupDelay=0
        B b = new B();
        System.out.println("befor lock");
        System.out.println(ClassLayout.parseInstance(b).toPrintable()); //偏向锁
        synchronized (b){
            System.out.println("lock ing");
            System.out.println(ClassLayout.parseInstance(b).toPrintable());//偏向锁
        }
        System.out.println("after lock");
        System.out.println(ClassLayout.parseInstance(b).toPrintable());//偏向锁
    }
}

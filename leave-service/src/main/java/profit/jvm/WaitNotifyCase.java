package profit.jvm;

import java.util.concurrent.TimeUnit;

/**
 * Created by huangxiaogen on 2021/8/18 上午11:44
 */
public class WaitNotifyCase{
    public static void main(String[] args) {
        final Object lock = new Object();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程 A 等待 获得 锁");
                synchronized (lock) {
                    try {
                        System.out.println("线程 A 获得 锁");
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("线程 A 开始 执行 wait() ");
                        lock.wait();
                        System.out.println("线程 A 结束 执行 wait()");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程 B 等待 获得 锁");
                synchronized (lock) {
                    System.out.println("线程 B 获得 锁");
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lock.notify();
                    System.out.println("线程 B 执行 notify()");
                }
            }
        }).start();
    }
}

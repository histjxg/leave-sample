package profit.lianxi;

import java.util.concurrent.TimeUnit;

class HoldThread implements Runnable{

    private String lockA;
    private String lockB;

    public HoldThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName()+"\t 自己持有"+lockA+"\t 尝试获得"+lockB);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB){
                System.out.println(Thread.currentThread().getName()+"\t 自己持有"+lockB+"\t 尝试获得"+lockA);

            }
        }
    }
}

/**
 *
 * 死锁是指两个或两个以上的进程在执行过程中，
 * 因争夺资源而造成的一种互相等待的现象，
 * 若无外力干涉那它们复发推进下去
 */
public class DeadLockDemo {
    public static void main(String[] args) {
        String lockA ="lockA";
        String lockB ="lockB";
        new Thread(new HoldThread(lockA,lockB),"threadAAAA").start();
        new Thread(new HoldThread(lockB,lockA),"threadBBB").start();
        /**
         * linux ps -ef|grep xxx   ls -l
         *jstack pid > dump_file_name
         1
         举例：dump pid 为 4738 的 java 进程的线程栈到 app_thread_dump.txt 文件

         jstack 4738 > app_thread_dump.txt
         *
         */
    }

}

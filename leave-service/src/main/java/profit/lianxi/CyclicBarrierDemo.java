package profit.lianxi;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 做加法
 * CyclicBarrier可以使一定数量的线程反复地在栅栏位置处汇集。当线程到达栅栏位置时将调用await方法，
 * 这个方法将阻塞直到所有线程都到达栅栏位置。如果所有线程都到达栅栏位置，那么栅栏将打开，
 * 此时所有的线程都将被释放，而栅栏将被重置以便下次使用。
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
            System.out.println("****************召唤神龙");
        });
        for (int i = 0; i < 7; i++) {
            final int tempt =i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t 收集到第： "+tempt+" 陇海线糊");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}

package profit.lianxi;

import profit.lianxi.enums.CountryEnum;;

import java.util.concurrent.CountDownLatch;

/**
 * countdownlatch 做减法
 * 　CountDownLatch能够使一个或多个线程等待其他线程完成各自的工作后再执行，当一个线程调用await方法时，调用线程会被阻塞
 * 其他线程调用countdown方法计数器会减一，调用countdown方法的线程不会阻塞，当计数器变为零时，因调用await方法被阻塞的线程的唤醒，继续执行
 * countdownlatch主要有两个方法，
 *  https://www.cnblogs.com/liun1994/p/7396026.html
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        //Thread

        CountDownLatch countDownLatch =new CountDownLatch(6);
        for (int i = 1; i <=6 ; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t 国灭");
                countDownLatch.countDown();
            }, CountryEnum.foreach_enum(i).getName()).start();

        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t  *********************秦国一统华夏");
    }

    private static void closeDoor() throws InterruptedException {
        //CountDownLatch countDownLatch =new CountDownLatch(6);
        CountDownLatch countDownLatch =new CountDownLatch(6);
        for (int i = 0; i <6 ; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t 上完自习，离开教室");
                countDownLatch.countDown();
            }, CountryEnum.foreach_enum(i).getName()).start();

        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t  *********************班长最后关门走人");
    }

}

/**
 * All rights Reserved, Designed By Suixingpay.
 *
 * @author: 王佳露[wang_jl@suixingpay.com]
 * @date: 2019年12月30日 15时56分
 * @copyright: 2018 Suixingpay. All rights reserved.
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package profit.jikeshijian.xiengnengyouhua;

/**
 * @classname: MustDeadLock
 * @description:
 * @date: 2019/12/30 15:56
 * @author: wangjialu[wang_jl@suixingpay.com]
 */
public class MustDeadLock implements Runnable{
    static Object o1 = new Object();
    static Object o2 = new Object();
    int flag = 0;
    public static void main(String[] args) {
        MustDeadLock m0 = new MustDeadLock();
        MustDeadLock m1 = new MustDeadLock();
        m0.flag = 0;
        m1.flag = 1;
        Thread thread0 = new Thread(m0);
        Thread thread1 = new Thread(m1);
        thread0.start();
        thread1.start();
    }




    @Override
    public void run() {
        System.out.println("threadName"+Thread.currentThread().getName()+"开始执行");
        if (flag == 1) {
            synchronized (o1) {
                System.out.println("threadName"+Thread.currentThread().getName()+"获得01");
                try {
                    System.out.println("threadName"+Thread.currentThread().getName()+"睡眠50秒");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                    System.out.println("threadName"+Thread.currentThread().getName()+"获得02了");
                }
            }
        }
        if (flag == 0) {

            synchronized (o2) {
                System.out.println("threadName"+Thread.currentThread().getName()+"获得02了");
                try {
                    System.out.println("threadName"+Thread.currentThread().getName()+"睡眠50秒");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1) {
                    System.out.println("threadName"+Thread.currentThread().getName()+"获得01");
                }
            }
        }
    }
}
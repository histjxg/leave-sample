package profit.lianxi;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

class MyData {
    //int number = 0;
    volatile int number = 0;
    public void addTo60(){
        this.number = 60;
    }
    //此时number是加了volatile，不保证原子性的
    public void addPlus(){
        number++;
    }
    AtomicInteger atomicInteger = new AtomicInteger();
    AtomicLong atomicLong = new AtomicLong();
    public void addAtomic(){
        atomicInteger.getAndIncrement();
    }
}

/**
 * //验证valitate的可见性
 * //int 假如int number = 0；number变量之前根本没有添加volatile关键字修饰
 * //添加volatile可以验证可见性
 * //2添加了volatile，不保证原子性
 *      2.1原子性指的是什么意思？
 *      不可分割，完整性，也即某个线程正在做某个具体的业务时，中间不可以加塞或者被分割，需要整体完成
 *      要么同事成功，要么同时失败
 *      2.2是否可以保证原子性
 *
 *  //why：为什么不能保证原子性
 *  怎么保证原子性
 *  //atomic
 *  //sync
 *  //atomicInteger
 */
public  class VolitileDemo{
    public static void main(String[] args) { //main是一切方法的入口
        // seeOkByVolatile();
        MyData myData = new MyData();
        for (int i = 1; i <= 20; i++) {
            new Thread(() -> {
               // System.out.println(Thread.currentThread().getName() + "\t comer in");
                try {
                    for (int j = 0; j < 1000; j++) {
                        myData.addPlus();
                        myData.addAtomic();
                    }
                 //  System.out.println(Thread.currentThread().getName() + "\t update number");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
        //需要等待上面20个线程全部执行完之后，在用main取得最终的结果
        //一种方法，祝线程休眠
        /*try {
            TimeUnit.SECONDS.sleep(5);
            myData.addTo60();
            System.out.println(Thread.currentThread().getName() + "\t update number");

        }catch (Exception e){
            e.printStackTrace();
        }*/

        //第二种方法：
        while(Thread.activeCount()>2){ //main线程，GC线程
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() +"\t finally int number"+myData.number);
        System.out.println(Thread.currentThread().getName() +"\t finally atomic number"+myData.atomicInteger);

    }


    //volatile可以保证可见性，及时通知其他线程，主物理内存的值已经被修改
    private static void seeOkByVolatile() {
        MyData myData = new MyData(); //资源类
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t comer in");
            try {
                TimeUnit.SECONDS.sleep(3);
                myData.addTo60();
                System.out.println(Thread.currentThread().getName() + "\t update number");

            }catch (Exception e){
                e.printStackTrace();
            }
        }, "AAA").start();
        //第二个线程；
        while (myData.number ==0){
            //mydata一直在这里等待
        }
        System.out.println(Thread.currentThread().getName() + "\t missing is over main thred get number"+myData.number);
    }
}

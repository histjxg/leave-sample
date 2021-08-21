package profit.lianxi;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class ABADemo {
    static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);
    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100,1);

    public static void main(String[] args) {
        System.out.println("-------------以下是ABA问题的产生------------------");
        new Thread(() -> {
            try {
                atomicReference.compareAndSet(100,101);
                atomicReference.compareAndSet(101,100);


            }catch (Exception e){
                e.printStackTrace();
            }
        }, "t1").start();
        new Thread(() -> {
            try {

                TimeUnit.SECONDS.sleep(1);
                System.out.println(atomicReference.compareAndSet(100, 2019)+"\t"+atomicReference.get());

            }catch (Exception e){
                e.printStackTrace();
            }
        }, "t2").start();
        try {

            TimeUnit.SECONDS.sleep(1);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("-------------以下是ABA问题的解决------------------------");
        new Thread(() -> {
            try {
                int stamp = atomicStampedReference.getStamp();
                System.out.println(Thread.currentThread().getName() + "\t第一次版本号：" + stamp);
                TimeUnit.SECONDS.sleep(1);
                atomicStampedReference.compareAndSet(100,101,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);

                System.out.println(Thread.currentThread().getName() + "\t第二次版本号：" + atomicStampedReference.getStamp());

                atomicStampedReference.compareAndSet(101,100,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
                System.out.println(Thread.currentThread().getName() + "\t第三次版本号：" + atomicStampedReference.getStamp());


            }catch (Exception e){
                e.printStackTrace();
            }
        }, "t3").start();

        new Thread(() -> {
            try {
                int stamp = atomicStampedReference.getStamp();
                System.out.println(Thread.currentThread().getName() + "\t第一次版本号：" + stamp);
                TimeUnit.SECONDS.sleep(3);
                boolean result = atomicStampedReference.compareAndSet(100, 101, stamp, stamp + 1);
               // System.out.println(Thread.currentThread().getName()+"\t"+result);
                System.out.println(Thread.currentThread().getName()+"\t当前的版本号"+atomicStampedReference.getStamp());
                System.out.println(Thread.currentThread().getName()+"\t当前的实际最新值"+atomicStampedReference.getReference());


            }catch (Exception e){
                e.printStackTrace();
            }
        }, "t4").start();
    }
}

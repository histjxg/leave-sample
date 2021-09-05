package profit.估泡.thread.synchronzed.volatiles;

import profit.jikeshijian.shejimoshi.zuhemoshi.File;


//-server -Xcomp -XX:+UnlockDiagnosticVMOptions -XX:+PrintAssembly -XX:CompileCommand=compileonly,`VolidateDemo.*`

/**
 * 提供了一种防止指令重排序的机制和通过内存屏障的机制解决我们的可见性问题
 */
public class VolidateDemo {
    public static volatile  boolean stop = false;

    public static void main(String[] args) throws InterruptedException {
        Thread thread= new Thread(()->{
            int i = 0;
            while (!stop){
                i++;
                //参考链接：https://blog.csdn.net/beArrow/article/details/105063897
//                System.out.println("rs:"+i);// 可以正常结束
//                new File("12")；io可以正常结束
//                Thread.sleep(1100);可以正常结束，线程切换，线程重新竞争，原本的缓存失效了

            }
//            System.out.println("rs:"+i);
        });
        thread.start();
        Thread.sleep(1000);
        stop = true;
    }
}

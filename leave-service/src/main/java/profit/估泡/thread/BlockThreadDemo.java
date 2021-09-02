package profit.估泡.thread;

import profit.atguigu.priciple.demeter.Demeter1;
import profit.bingfa.chapt1.Demo;

import java.util.concurrent.TimeUnit;

/**
 * 线程的生命周期
 */
public class BlockThreadDemo {
    public static void main(String[] args) {
        new Thread(()->{
            while(true){
                try{
                    TimeUnit.SECONDS.sleep(100);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        },"STATUS_01").start();


        new Thread(()->{
            while (true){
                synchronized (Demo.class){
                    try {
                        Demo.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"STATUS_02").start();
        new Thread(new BlockDemo(),"BLOKDEMO_01").start();
        new Thread(new BlockDemo(),"BLOKDEMO_02").start();

    }



    static class BlockDemo extends Thread{
        @Override
        public void run() {
            synchronized (BlockDemo.class ){
                try{
                    TimeUnit.SECONDS.sleep(100);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
}

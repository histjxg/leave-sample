package profit.估泡.thread;

import java.util.concurrent.TimeUnit;

public class InterruptDemo02 implements Runnable{
    //优雅中断
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){//false
            try {
                TimeUnit.SECONDS.sleep(200);
            } catch (InterruptedException e) {//jvm触发了 触发了线程的复位-->false  复位的原因：是为了将主动权交给自己，不应该由别人来控制

                //可以不做处理
                //继续中断
                Thread.currentThread().interrupt();
                e.printStackTrace();
                //再次抛出异常

            }
        }
        System.out.println("process on");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1= new Thread(new InterruptDemo02());
        t1.start();
//        Thread.sleep(1000);
        t1.interrupt();//有作用 true  如果是sleep，需要唤醒，然后再抛异常
//        Thread.interrupted();复位
    }
}

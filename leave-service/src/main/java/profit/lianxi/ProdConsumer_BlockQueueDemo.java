package profit.lianxi;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 为什么需要blockingQueue
 * 好处是我们不需要关心什么时候需要阻塞线程，什么需要唤醒线程，因为这一切BlockingQueue都给你一手包办了
 * 在concurrent包发布以前，在多线程环境下，我们每个程序员都必须自己去控制这些细节，
 * 尤其还要兼顾效率和线程安全，而这会给我们的程序带来不小的复杂度
 *
 */
//永远穿参穿接口
class MyResource{
    private volatile boolean FLAG = true; //默认开启，进行生产+消费
    private AtomicInteger atomicInteger = new AtomicInteger();

    BlockingQueue<String> blockingQueue = null;
    public MyResource(BlockingQueue<String> blockingQueue){
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }
    public void myProd()throws Exception{
        String data =null;
        boolean returnVal ;
        while (FLAG){
            data = atomicInteger.incrementAndGet()+"";
           returnVal = blockingQueue.offer(data,2L, TimeUnit.SECONDS);
            if (returnVal){
                System.out.println(Thread.currentThread().getName()+"\t 插入队列"+data+"成功");
            }else {
                System.out.println(Thread.currentThread().getName()+"\t 插入队列"+data+"失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName()+"  大老板叫停了，表示FLAG=false，生产动作结束");
    }
    public void myConsumer()throws Exception{

        String result = null;
        while (FLAG){
            result = blockingQueue.poll(2l,TimeUnit.SECONDS);
            if (null==result||result.equalsIgnoreCase("")){
                FLAG=false;
                System.out.println(Thread.currentThread().getName()+"\t超过两秒没有取出蛋糕");
                System.out.println();
                System.out.println();
                return;
            }
            System.out.println(Thread.currentThread().getName()+"\t消费队列"+result+"成功");

        }
    }

    public void stop(){
        this.FLAG = false;
    }


}

/**
 * volatile/cas/atomicInteger/BlockQueue/线程交互/原子引用
 */
public class ProdConsumer_BlockQueueDemo {
    public static void main(String[] args) {
        //MyResource myResource = new MyResource(new ArrayBlockingQueue<>(10));
        MyResource myResource = new MyResource(new LinkedBlockingQueue<>(10));

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"生产线程启动");
            try {
                try {
                    myResource.myProd();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }catch (Exception e){

            }
        },"prod").start();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"消费线程启动");
            try {
                try {
                    myResource.myConsumer();
                    System.out.println();
                    System.out.println();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }catch (Exception e){

            }
        },"Consumer").start();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("5秒钟时间到，大老板main停止线程运动");
        myResource.stop();

    }
}

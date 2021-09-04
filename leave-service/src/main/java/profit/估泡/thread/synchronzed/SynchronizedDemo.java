package profit.估泡.thread.synchronzed;

/**
 * 可见性原子性问题
 */
public class SynchronizedDemo {
    public static int count=0;
    public synchronized static void incr(){
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
    }
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            new Thread(()-> SynchronizedDemo.incr()).start();
        }
        Thread.sleep(3000);
        System.out.println("运行结果："+count);
    }
}

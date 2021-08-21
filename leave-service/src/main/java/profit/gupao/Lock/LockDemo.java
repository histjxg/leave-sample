package profit.gupao.Lock;

/**
 *  锁的特点
 *  排他性
 *  公平性和非公平性
 *  没有获得锁的需要等待
 *  锁的获得和释放的方法
 *  锁是否支持重入性
 *
 */

public class LockDemo {
    private static  int count = 0;

    public static void incr() {
        try {
            Thread.sleep(1);
            count++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(()-> LockDemo.incr()).start();
        }
        try {
            Thread.sleep(4000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("count=  "+count);
    }
}

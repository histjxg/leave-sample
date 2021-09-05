package profit.估泡.thread.threadlocaldemo;

/**
 * 线程隔离性
 */
public class ThreadLocalDemo {
//    private static int i=0;

    static ThreadLocal<Integer> local = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };
    public static void main(String[] args) {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(()->{
                int num= local.get(); //获得的值都是0
                local.set(num+=5);//设置local
                System.out.println(Thread.currentThread().getName()+"-"+num);
            });
        }
        for (int i = 0; i <5; i++) {
                threads[i].start();
        }

    }
}

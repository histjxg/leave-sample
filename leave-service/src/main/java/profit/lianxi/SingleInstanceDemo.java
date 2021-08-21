package profit.lianxi;

public class SingleInstanceDemo {
    private static volatile SingleInstanceDemo instance = null;
    private SingleInstanceDemo(){
        System.out.println(Thread.currentThread().getName()+"我是构造方法SingleInstanceDemo()");
    }

    //重锁
   /* public static synchronized SingleInstanceDemo getInstance(){
        if (instance == null){
            instance = new SingleInstanceDemo();
        }
        return instance;
    }*/
   //DCLdouble check lock,双端检测机制不一定线程安全，原因是有指令重排序的存在，加入volatile可以禁止指令重排
    //原因在于某一个线程执行到第一次检测，读取到instance不为null时，instance的引用对象可能没有初始化完成
    public static synchronized SingleInstanceDemo getInstance(){
        if (instance == null){
            //同步代码块
            synchronized (SingleInstanceDemo.class){
                if (instance == null){
                    instance = new SingleInstanceDemo();
                }
            }
          //  instance = new SingleInstanceDemo();
        }
        return instance;
    }


    public static void main(String[] args) {
        //main线程的操作
      //  System.out.println(SingleInstanceDemo.getInstance() == SingleInstanceDemo.getInstance());
       // System.out.println(SingleInstanceDemo.getInstance() == SingleInstanceDemo.getInstance());
       // System.out.println(SingleInstanceDemo.getInstance() == SingleInstanceDemo.getInstance());
        //并发多线程，情况发生了很大的变化
        for (int i = 1; i <20 ; i++) {
                    new Thread(() -> {
                        SingleInstanceDemo.getInstance();
                    }, String.valueOf(i)).start();
                }


    }
}

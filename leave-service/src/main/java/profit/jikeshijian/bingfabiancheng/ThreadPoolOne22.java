package profit.jikeshijian.bingfabiancheng;

public class ThreadPoolOne22 {
    // 获取空闲线程
    Thread acquire() {
        return new Thread();
    }
    // 释放线程
    void release(Thread t){
    }


        //期望的使用
      /*
       ThreadPool pool；
        Thread T1=pool.acquire();
        //传入Runnable对象
        T1.execute(()->{
            //具体业务逻辑
            //......
        });
        */
}

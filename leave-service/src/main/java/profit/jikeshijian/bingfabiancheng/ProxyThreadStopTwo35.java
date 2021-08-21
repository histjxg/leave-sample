package profit.jikeshijian.bingfabiancheng;

/**
 *
 *
 实际工作中，有些监控系统需要动态地采集一些数据
 原理：
 1。一般都是监控系统发送采集指令给被监控系统的监控代理
 2。监控代理接收到指令之后，从监控目标收集数据
 3。然后回传给监控系统

 出于对性能的考虑(有些监控项对系统性能影响很大，所以不能一直持续监控)
 动态采集功能一般都会有终止操作。


 1。下面的示例代码是监控代理简化之后的实现
 start()方法会启动一个新的线程rptThread来执行监控数据采集和回传的功能
 stop()方法需要优雅地终止线程rptThread，那stop()相关功能该如何实现呢?


 示例代码的确能够解决当前的问题，但是建议你在实际工作中谨慎使用
 原因：
 1。我们很可能在线程 的run()方法中调用第三方类库提供的方法
 2。我们没有办法保证第三方类库正确处理了线程的中断异常
例子：
 1。第三方类库在捕获到Thread.sleep()方法抛出的中断异常后，没有重新设置线程的中断状态
 2。那么就会 导致线程不能够正常终止
 建议：
     设置自己的线程终止标志位
 分析：
     1。使用 isTerminated作为线程终止标志位
     2。，此时无论是否正确处理了线程的中断异常，都不会影响线程优雅地终 止。


 *
 *
 *
 */
public class ProxyThreadStopTwo35 {
    boolean started = false; //采集线程
    Thread rptThread; //启动采集功能

    synchronized void start() {
        //不允许同时启动多个采集线程
        if (started) {
            return;
        }
        started = true;
        rptThread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                //省略采集、回传实现
                // report();
                // 每隔两秒钟采集、回传一次数据
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    //重新设置线程中断状态
                    Thread.currentThread().interrupt();
                }
            } //执行到此处说明线程⻢上终止
           started = false;
        });
        rptThread.start();
    }

    //终止采集功能
    synchronized void stop() {
        //如何实现
        rptThread.interrupt();
    }
}

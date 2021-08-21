package profit.jikeshijian.bingfabiancheng;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 *
 *
 在Java语言中，实现echo程序的服务端还是很简单的
 1。只需要30行代码就能够实现，示例代码如下
 2。我们为每个请求都创建了一个Java线程，核心代码是：new Thread(()->{…}).start()。

 问题：
    上面这个echo服务的实现方案是不具备可行性的。
原因：
 1。Java中的线程是一个重量级的对象，创建成本很高
    1。一方面创建线程比较耗时
    2。另一方面线程占用的内存也比较大
思路：
    引入线程池，
 缺点：
    但是引入线程池难免会增加复杂度
 换一个角度来思考问题
     语言、工具、框架本身应该是帮助我们更敏捷地实现方案的，而不是用来否定方案的，
     Thread-Per-Message模式作为一种最简单的分工方案

 将Java线程的调度权完全委托给操作系统
     原因：
        Java线程是和操作系统线程一一对应的
    优点：
     稳定、可靠
    缺点：
         创建成本高
     方案：
        线程池

 *
 *
 *
 *
 *
 *
 */
public class ThreadPerMessageOne33 {
    public static void main(String[] args) throws Exception {
        final ServerSocketChannel ssc = ServerSocketChannel.open().bind(new InetSocketAddress(8080));
        //处理请求
        try

        {
            while (true) {
                // 接收请求
                SocketChannel sc = ssc.accept();
                // 每个请求都创建一个线程
                new Thread(() -> {
                    try {
                        // 读Socket
                        ByteBuffer rb = ByteBuffer.allocateDirect(1024);
                        sc.read(rb);
                        //模拟处理请求
                        Thread.sleep(2000);
                        // 写Socket
                        ByteBuffer wb = (ByteBuffer) rb.flip();
                        sc.write(wb);
                        // 关闭Socket
                        sc.close();
                    } catch (Exception e) {

                    }
                }).start();
            }
        } finally

        {
            ssc.close();
        }
    }

}

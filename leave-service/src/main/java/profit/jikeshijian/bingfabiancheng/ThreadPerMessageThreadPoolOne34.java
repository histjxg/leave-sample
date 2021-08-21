package profit.jikeshijian.bingfabiancheng;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 *
 下面的示例代码是用线程池实现的echo服务端
 相比于Thread-Per-Message模式的实现，改动非常少，
 仅仅是创建了一个最多线程数为500的线程池es，然后通过es.execute()方法将请求处理的任务提交给线程池处理。

 思考：
 1。Java的线程池既能够避免无限制地创建线程导致OOM，也能避免无限制地接收任务导致OOM。
 2。只不过后者经常容易被我们忽略
 3。所以强烈建议你用创建有界的队列来接收任务。

 问题：
    当请求量大于有界队列的容量时，就需要合理地拒绝请求。如何合理地拒绝呢？
 思考：
 这需要你结合具体的业务场景来制定，即便线程池默认的拒绝策略能够满足你的需求，
 也同样建议你在创建线程池时，清晰地指明拒绝策略。
 同时，为了便于调试和诊断问题，我也强烈建议你在实际工作中给线程赋予一个业务相关的名字。
 *
 *
 *
 *
 *
 *
 */
public class ThreadPerMessageThreadPoolOne34 {
    public static void main(String[] args) throws Exception {
        ExecutorService es = Executors
                .newFixedThreadPool(500);
        final ServerSocketChannel ssc =
                ServerSocketChannel.open().bind(
                        new InetSocketAddress(8080));
        //处理请求
        try {
            while (true) {
                // 接收请求
                SocketChannel sc = ssc.accept();
                // 将请求处理任务提交给线程池
                es.execute(()->{
                    try {
                        // 读Socket
                        ByteBuffer rb = ByteBuffer
                                .allocateDirect(1024);
                        sc.read(rb);
                        //模拟处理请求
                        Thread.sleep(2000);
                        // 写Socket
                        ByteBuffer wb =
                                (ByteBuffer)rb.flip();
                        sc.write(wb);
                        // 关闭Socket
                        sc.close();
                    }catch(Exception e){
                    }
                });
            }
        } finally {
            ssc.close();
            es.shutdown();
        }
    }

}

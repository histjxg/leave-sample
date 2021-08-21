package profit.jikeshijian.bingfabiancheng;

/**
 *
 *
 Java语言目前也已经意识到轻量级线程的重要性了
 OpenJDK有个Loom项目，就是要解决Java语言的轻量级线程问题，在这个项目中，轻量级线程被叫做Fiber
 下面我们就来看看基于Fiber如何实现Thread-Per-Message模式。



 下面我们就来看看基于Fiber如何实现Thread-Per-Message模式。所以使用上还是挺简单的
 用Fiber实现echo服务的示例代码如下所示，对比Thread的实现
 你会发现改动量非常小，只需要把new Thread(()->{…}).start()换成 Fiber.schedule(()->{})就可以了。
 *
 *
 *
 *
 *
 *
 */
public class ThreadPerMessageTwo33 {
    public static void main(String[] args) throws Exception {
        /**
        final ServerSocketChannel ssc =
                ServerSocketChannel.open().bind(
                        new InetSocketAddress(8080));
        //处理请求
        try{
            while (true) {
                // 接收请求
                final SocketChannel sc =
                        ssc.accept();
                /**


                Fiber.schedule(()->{
                    try {
                        // 读Socket
                        ByteBuffer rb = ByteBuffer
                                .allocateDirect(1024);
                        sc.read(rb);
                        //模拟处理请求
                        LockSupport.parkNanos(2000*1000000);
                        // 写Socket
                        ByteBuffer wb =
                                (ByteBuffer)rb.flip();
                        sc.write(wb);
                        // 关闭Socket
                        sc.close();
                    } catch(Exception e){
                        throw new Exception(e);
                    }
                });
            }//while
        }finally{
            ssc.close();
        }


                 */
    }

}

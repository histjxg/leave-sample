package profit.jikeshijian.bingfabiancheng;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 *
 *
 *
 *
 支持分阶段提交以提升性能
 背景：
     利用生产者-消费者模式还可以轻松地支持一种分阶段提交的应用场景
         1。我们知道写文件如果同步刷盘性能 会很慢
         2。对于不是很重要的数据，我们往往采用异步刷盘的方式
案例：
 我曾经参与过一个项目，其中的日志 组件是自己实现的，采用的就是异步刷盘方式，刷盘的时机是:
 1。ERROR级别的日志需要立即刷盘;
 2。数据积累到500条需要立即刷盘;
 3。存在未刷盘数据，且5秒钟内未曾刷盘，需要立即刷盘

 这个日志组件的异步刷盘操作本质上其实就是一种分阶段提交
 下面我们具体看看用生产者-消费者模式如 何实现
 在下面的示例代码中，可以通过调用 info()和error() 方法写入日志
 这两个方法都是创建了 一个日志任务LogMsg，并添加到阻塞队列中，调用 info()和error() 方法的线程是生产者
 而真正将日 志写入文件的是消费者线程，在Logger这个类中，
 我们只创建了1个消费者线程，在这个消费者线程中，会 根据刷盘规则执行刷盘操作，逻辑很简单，这里就不赘述了。
 *
 *
 *
 *
 *
 *
 *
 */
public class LoggerProductConsumerTwo36 {
    //任务队列
    final BlockingQueue<LogMsg> bq = new LinkedBlockingQueue<>(); //flush批量
    static final int batchSize = 500; //只需要一个线程写日志
    ExecutorService es = Executors.newFixedThreadPool(1); //启动写日志线程

    void start() throws IOException {
        File file = File.createTempFile("foo", ".log");
        final FileWriter writer = new FileWriter(file);
        this.es.execute(() -> {
            try {
                //未刷盘日志数量
                int curIdx = 0;
                long preFT = System.currentTimeMillis();
                while (true) {
                    LogMsg log = bq.poll(5, TimeUnit.SECONDS);
                    //写日志
                    if (log != null) {
                        writer.write(log.toString());
                        ++curIdx;
                    }
                    //如果不存在未刷盘数据，则无需刷盘
                    if (curIdx <= 0) {
                        continue;
                    }
                    //根据规则刷盘
                    if (log != null && log.level == LEVEL.ERROR || curIdx == batchSize
                            || System.currentTimeMillis() - preFT > 5000) {
                        writer.flush();
                        curIdx = 0;
                        preFT = System.currentTimeMillis();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    writer.flush();
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }


    //写INFO级别日志
    void info(String msg) throws InterruptedException {
        bq.put(new LogMsg(LEVEL.INFO, msg));
    }

    //写ERROR级别日志
    void error(String msg) throws InterruptedException {
        bq.put(new LogMsg(LEVEL.ERROR, msg));
    }
}
//日志级别
class LogMsg {
    LEVEL level;
    String msg;
    //省略构造函数实现
    LogMsg(LEVEL lvl, String msg){} //省略toString()实现
    //String toString(){return "";}
}

enum LEVEL {
    INFO, ERROR
}



package profit.jikeshijian.bingfabiancheng;

import javafx.concurrent.Task;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/***
 *
 *
 利用生产者-消费者模式实现批量执行SQL非常简单:
     1.将原来直接INSERT数据到数据库的线程作为生产者线程，
     2.生产者线程只需将数据添加到任务队列
     3.然后消费者线程负责将任务从任务队列中批量取出并批量执行。
 示例代码：
 1。创建了5个消费者线程负责批量执行SQL，
 2。这5个消费者线程以 while(true){} 循环方式批量地获取任务并批量地执行。
 注意：
    从任务队列中获取批量任务的方法pollTasks()中，
 1。首先是以阻塞方式获取任务队列中的一条任务，
     问题：
        为什么首先采用阻塞方式？
    原因：
        因为如果任务队列中没有任务，这样的方式能够避免无谓的循环。
 2。而后则是以非阻塞的方式获取任务



 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
public class ProductConsumerOne36 {
    //任务队列
    BlockingQueue<Task> bq = new LinkedBlockingQueue<>(2000); //启动5个消费者线程

    //执行批量任务
    void start() {
        ExecutorService es = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            es.execute(() -> {
                try {
                    while (true) {
                        //获取批量任务
                        List<Task> ts = pollTasks();
                        execTasks(ts);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }

    //从任务队列中获取批量任务
    List<Task> pollTasks() throws InterruptedException {
        List<Task> ts = new LinkedList<>(); //阻塞式获取一条任务
        Task t = bq.take();
        while (t != null) {
            ts.add(t); //非阻塞式获取一条任务
            t = bq.poll();
        }
        return ts;
    }
    //批量执行任务

    public void execTasks(List<Task> ts) {
        //省略具体代码无数
    }

}

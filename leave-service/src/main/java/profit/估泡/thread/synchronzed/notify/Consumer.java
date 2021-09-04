package profit.估泡.thread.synchronzed.notify;

import java.util.Queue;

public class Consumer implements Runnable{
    private Queue<String> msg;
    private int maxSize;

    public Consumer(Queue<String> msg, int maxSize) {
        this.msg = msg;
        this.maxSize = maxSize;
    }



    @Override
    public void run() {
        while (true){
            synchronized (msg){
                while (msg.isEmpty()){
                    try {
                        msg.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("消费者消费消息："+msg.remove());
                msg.notify();//唤醒处于阻塞状态下的消费者生产者
            }
        }
    }
}

package profit.jikeshijian.bingfabiancheng;

import java.util.Queue;

/**
 *
 *
 信号量模型里面，down()、up() 这两个操作历史上最早称为 P 操作和 V 操作，
 所以信号量模型也被称为 PV 原语。
 另外，还有些人喜欢用 semWait() 和 semSignal() 来称呼它 们，虽然叫法不同，但是语义都是相同的
 在 Java SDK 并发包里，down() 和 up() 对应的则是 acquire() 和 release()。
 *
 *
 *



 *
 *
 */

public class Semaphore16 {
    // 计数器
    int count;
    // 等待队列
    Queue queue;
    // 初始化操作
    Semaphore16(int c){
        this.count=c;
    }
    //
    void down(){
        this.count--;
        if(this.count<0){
            // 将当前线程插入等待队列
            // 阻塞当前线程
        }
    }
    void up(){
        this.count++;
        if(this.count<=0) {
            // 移除等待队列中的某个线程 T
            // 唤醒线程 T
        }
    }

}

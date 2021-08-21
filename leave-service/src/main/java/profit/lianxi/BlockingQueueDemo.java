package profit.lianxi;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/***
 * ArrayBlockingQueue：是一个基于数组结构的有界阻塞队列，此列按FIFO（先进先出）原则对元素进行排序
 * LinkedBlockingQueue：一个基于连标结构的阻塞队列，此队列FIFO（先进先出）排列元素，吞吐量通常高于ArrayBlockingQueue
 * SynchronousQueue：一个不存储元素的阻塞队列。每个插入操作必须等到另一个线程调用移除操作，否则插入操作一直处于阻塞状态，吞吐量通常要高
 *
 *试图从空的阻塞队列中获取元素的线程会被阻塞，直到其他的线程往空队列插入新的元素
 * 同样：
 * 试图往已满的阻塞队列中添加新元素的线程同样也会被阻塞，直到其他的线程从列中移除一个或者多个元素或者安全清空
 * 队列后使队列重新变得空闲起来后续新增
 *
 *
 * 在多线程领域：所谓阻塞，在某些情况下会挂起线程（即阻塞）一旦条件满足，被挂起的线程又会自动被唤醒
 *
 * 为什么需要BlockingQueue
 * 好处是我们不需要关心什么时候需要阻塞队列，什么时候需要唤醒线程，因为这一切BlockingQueue都给你一手包办了
 * 在concurrent包发布以前，在多线程环境下，我们每个程序员都必须自己控制这些细节，尤其还要兼顾效率和线程安全，
 * 而这会给我们的程序带来不小复杂度。
 *
 *
 *
 *
 * 1队列
 *
 *
 *
 * 2。阻塞队列：当阻塞队列是空的时候，从队列中获取元素的操作将会被阻塞
 * 当阻塞队列是满的时候，往队列里添加元素的操作将会被阻塞
 *   2.1:阻塞队列有没有好的一面
 *   2.2：不得不阻塞，你如何管理
 */
public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        //arraylist 和 linkedList
       // List list = new ArrayList();
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        /*System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));;
        //检查队首元素是哪一个
        System.out.println(blockingQueue.element());
        // System.out.println(blockingQueue.add("e"));
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
      //  System.out.println(blockingQueue.remove());
*/
        //成功true，失败false
  /*      System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        System.out.println(blockingQueue.offer("e"));
        //检查队首元素是哪一个
        System.out.println(blockingQueue.peek());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());*/

     /*
     插不进去就不退
        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
        System.out.println("=================");
        blockingQueue.put("d");
        blockingQueue.take();
        blockingQueue.take();
        blockingQueue.take();
*/

        System.out.println(blockingQueue.offer("a",2l, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a",2l, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a",2l, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a",2l, TimeUnit.SECONDS));





    }

}

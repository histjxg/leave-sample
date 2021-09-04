package profit.估泡.thread.synchronzed.notify;

import java.util.LinkedList;
import java.util.Queue;

public class TestMain {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        int maxSize =5;
        Product product = new Product(queue,maxSize);
        Consumer consumer = new Consumer(queue,maxSize);
        Thread thread1= new Thread(product);
        Thread thread2 =new Thread(consumer);
        thread1.start();
        thread2.start();
    }
}

package profit.估泡.thread;

import profit.bingfa.chapt2.ThreadPoolDemo;

public class TestThreadDemo extends Thread{
    @Override
    public void run() {
        System.out.println("thread----------------");
    }

    public static void main(String[] args) {
        TestThreadDemo testThreadDemo = new TestThreadDemo();
        testThreadDemo.start();
        System.out.println("main----------");
    }
}

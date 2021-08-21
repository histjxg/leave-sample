package profit.jikeshijian.bingfabiancheng;

public class TestVisibility01 {
    private  long count=0;
    private void add10k(){
        int idx=0;
        while (idx++ < 10000){
            count+=1;
        }
    }
    public  long calc() throws InterruptedException {
        //创建两个线程
        Thread th1 = new Thread(()->{
            add10k();
        });
        Thread th2 = new Thread(()->{
            add10k();
        });
        //启动两个线程
        th1.start();
        th2.start();
        //等待两个线程结束
        th1.join();
        th2.join();
        return count;
    }

    public static void main(String[] args) throws InterruptedException {

        TestVisibility01 testVisibility01 = new TestVisibility01();

        long calc = testVisibility01.calc();
        System.out.println("calc的值"+calc);
    }

    //案例分析
}

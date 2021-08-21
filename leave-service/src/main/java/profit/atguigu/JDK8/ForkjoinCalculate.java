package profit.atguigu.JDK8;

import java.util.concurrent.RecursiveTask;

public class ForkjoinCalculate extends RecursiveTask<Long> {
    private static final long serialVersionUID =1324235436L;
    private long start;
    private long end;
    private static final long TREHOLD = 10000;

    public ForkjoinCalculate(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long length =end -start;
        if (length<=TREHOLD ){
            long sum= 0;
            for (long i = start; i <=end ; i++) {
                sum+=i;
            }
            return sum;
        }else {
            long mid = (start + end) / 2;
            ForkjoinCalculate left= new ForkjoinCalculate(start, mid);
            left.fork();//拆分子任务，同时压入线程队列

            ForkjoinCalculate right= new ForkjoinCalculate(mid+1, end);
            right.fork();//拆分子任务，同时压入线程队列
            return left.join()+right.join();

        }

    }
}

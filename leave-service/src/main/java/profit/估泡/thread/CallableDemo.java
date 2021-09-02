package profit.估泡.thread;

import java.util.concurrent.*;

public class CallableDemo implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("come in");
        return "Success";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        CallableDemo callableDemo = new CallableDemo();
        Future<String> submit = executorService.submit(callableDemo);
        System.out.println(submit.get());//阻塞
    }
}

package profit.jikeshijian.bingfabiancheng;

/**
 *
 *
 *
 *
 1。在小灰的这个Web项目中，用户通过浏览器发过来一个请求，会被转换成一个异步消息发送给MQ
 2。等MQ返回结果后，再将这个结果返回至浏览器。
 3。小灰同学的问题是：给MQ发送消息的线程是处理Web请求的线程T1
 4。但消费MQ结果的线程并不是线程T1，那线程T1如何等待MQ的返回结果呢？
 4。为了便于你理解这个场景，我将其代码化了，示例代码如下。




 *
 *
 *
 *
 *
 */


public class Message31 {
    String id;
    String content;

    /**
     *

    //该方法可以发送消息
    void send(Message30 msg) {
        //省略相关代码
    }

    //MQ消息返回后会调用该方法
    //该方法的执行线程不同于
    //发送消息的线程
    void onMessage(Message30 msg) {
        //省略相关代码
    }

    //处理浏览器发来的请求
    Respond handleWebReq() {
        //创建一消息
        Message30 msg1 = new Message30("1", "{...}");
        //发送消息
        send(msg1);
        //如何等待MQ返回的消息呢？
        String result = ...;
    }
     */
}

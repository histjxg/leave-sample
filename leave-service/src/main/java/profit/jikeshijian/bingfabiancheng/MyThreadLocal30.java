package profit.jikeshijian.bingfabiancheng;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MyThreadLocal30<T> {
    Map<Thread, T> locals = new ConcurrentHashMap<>();
    //获取线程变量
    T get() {
        return locals.get(
                Thread.currentThread());
    }
    //设置线程变量
    void set(T t) {
        locals.put(
                Thread.currentThread(), t);
    }
}

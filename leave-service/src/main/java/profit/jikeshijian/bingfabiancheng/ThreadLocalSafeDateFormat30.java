package profit.jikeshijian.bingfabiancheng;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 *
 问题：
    SimpleDateFormat不是线程安全的，那如果需要在并发场景下使用它，你该怎么办呢？
 方法：
    用ThreadLocal来解决
 1。不同线程调用SafeDateFormat的get()方法将返回不同的SimpleDateFormat对象实例
 2。由于不同线程并不共享SimpleDateFormat，所以就像局部变量一样，是线程安全的。
 *
 *
 *
 *
 */
public class ThreadLocalSafeDateFormat30 {
    //定义ThreadLocal变量
    static final ThreadLocal<DateFormat>
            tl=ThreadLocal.withInitial(
            ()-> new SimpleDateFormat(
                    "yyyy-MM-dd HH:mm:ss"));

    static DateFormat get(){
        return tl.get();
    }

    public static void main(String[] args) {
        DateFormat df =
                ThreadLocalSafeDateFormat30.get();
    }
}

package profit.lianxi;

import java.util.concurrent.atomic.AtomicInteger;

public class CASDemo {
    /**
     * CAS是什么
     * 底层原理和unsafe
     */
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        System.out.println(atomicInteger.compareAndSet(5, 2019));
        System.out.println(atomicInteger.compareAndSet(5, 1024));

    }
}

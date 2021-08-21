package profit.jikeshijian.javahexinjishu;

import java.util.concurrent.atomic.AtomicLong;

public class Counter07 {
    private final AtomicLong counter = new AtomicLong();

    public void increase() {
        counter.incrementAndGet();
    }
}

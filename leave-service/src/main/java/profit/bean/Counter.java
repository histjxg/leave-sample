package profit.bean;

import java.util.concurrent.atomic.AtomicLong;

public class Counter {
    private final AtomicLong counter = new AtomicLong(); public void increase() {
        counter.incrementAndGet(); }
}

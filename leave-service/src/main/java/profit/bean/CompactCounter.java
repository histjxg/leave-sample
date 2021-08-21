package profit.bean;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;

public class CompactCounter {
    private volatile long counter;
    private static final AtomicLongFieldUpdater<CompactCounter> updater = AtomicLongFieldUpdater
            .newUpdater(CompactCounter.class, "counter");

    public void increase() {
        updater.incrementAndGet(this);
    }

}

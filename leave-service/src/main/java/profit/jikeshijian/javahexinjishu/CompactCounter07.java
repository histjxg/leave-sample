package profit.jikeshijian.javahexinjishu;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
//利用原始数据类型，可以将其修改为
public class CompactCounter07 {
    private volatile long counter;
    private static final AtomicLongFieldUpdater updater = AtomicLongFieldUpdater
            .newUpdater(CompactCounter07.class, "counter");

    public void increase() {
        updater.incrementAndGet(this);
    }
}

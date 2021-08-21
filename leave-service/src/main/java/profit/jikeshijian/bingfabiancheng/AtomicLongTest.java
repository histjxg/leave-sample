package profit.jikeshijian.bingfabiancheng;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicLongTest {
    AtomicLong count = new AtomicLong(0);
    void add10k(){
        int idx = 0;
        while (idx++<10000){
            count.getAndIncrement();

        }
    }

}

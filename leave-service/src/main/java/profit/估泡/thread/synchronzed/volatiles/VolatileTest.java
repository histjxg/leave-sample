package profit.估泡.thread.synchronzed.volatiles;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: huangxiaogen
 * @Date: 2021/09/07/下午1:10
 * @Description:
 */


public class VolatileTest {

    private volatile int volatileCount = 0;
    private int count = 0;

    public static void main(String[] args) {

        VolatileTest volatileTest = new VolatileTest();

        volatileTest.increase();
        volatileTest.decrease();

    }

    private void decrease() {
        count--;
    }

    private void increase() {
        volatileCount++;
    }

}
package profit.jikeshijian.shejimoshi.guanchazhemoshi;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: huangxiaogen
 * @Date: 2020/07/14/下午10:45
 * @Description:
 * d
 */
// 第一种实现方式，其他类代码不变，就没有再重复罗列

/**
 * 缺点：
 * 1。频繁地创建和销毁线程比较耗时，并且并发线程数无法控制
 * 2。创建过多的线程会导致堆栈溢出。
 */
public class RegPromotionObserverTwo implements RegObserver {
    @Override
    public void handleRegSuccess(long userId) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //promotionService.issueNewUserExperienceCash(userId);
            }
        });
        thread.start();
    }
}

package profit.jikeshijian.shejimoshi.guanchazhemoshi;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: huangxiaogen
 * @Date: 2020/07/14/下午10:47
 * @Description:
 */

/**
 * 1。尽管利用了线程池解决了第一种实现方式的问 题，但线程池、异步执行逻辑都耦合在了 register() 函数中
 * 2。增加了这部分业务代码的维护成本。
 */
public class UserControllerTwo {
//    private UserService userService; // 依赖注入
    private List<RegObserver> regObservers = new ArrayList<>();
    private Executor executor;
    public UserControllerTwo(Executor executor) {
        this.executor = executor;
    }
    public void setRegObservers(List<RegObserver> observers) {
        regObservers.addAll(observers);
    }
    public Long register(String telephone, String password) { //省略输入参数的校验代码 //省略userService.register()异常的try-catch代码
//        long userId = userService.register(telephone, password);
        long userId = 234;
        for (RegObserver observer : regObservers) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    observer.handleRegSuccess(userId);
                } });
        }
        return userId;
    }

}

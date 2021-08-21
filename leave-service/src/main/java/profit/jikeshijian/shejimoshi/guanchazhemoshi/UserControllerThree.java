package profit.jikeshijian.shejimoshi.guanchazhemoshi;

import java.util.List;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: huangxiaogen
 * @Date: 2020/07/15/上午8:52
 * @Description:
 */

public class UserControllerThree {
//    private UserService userService; // 依赖注入
//    private EventBus eventBus;
    private static final int DEFAULT_EVENTBUS_THREAD_POOL_SIZE = 20;
    public UserControllerThree() {
        //eventBus = new EventBus(); // 同步阻塞模式
//        eventBus = new AsyncEventBus(Executors.newFixedThreadPool(DEFAULT_EVENTBUS);异步阻塞模式
    }
    public void setRegObservers(List<Object> observers) {
        for (Object observer : observers) {
//            eventBus.register(observer);
        }
    }


    public Long register(String telephone, String password) { //省略输入参数的校验代码 //省略userService.register()异常的try-catch代码
//        long userId = userService.register(telephone, password);
//        eventBus.post(userId);
        return 1234L;
    }
}

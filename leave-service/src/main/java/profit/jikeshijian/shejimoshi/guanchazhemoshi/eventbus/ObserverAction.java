package profit.jikeshijian.shejimoshi.guanchazhemoshi.eventbus;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: huangxiaogen
 * @Date: 2020/07/18/上午11:37
 * @Description:
 */

/**
 * 1.ObserverAction 类用来表示 @Subscribe 注解的方法，其中，target 表示观察者类，
 * 2.method 表示方法。它主要用在 ObserverRegistry 观察者注册表中。
 */
public class ObserverAction {
    private Object target;
    private Method method;

    public ObserverAction(Object target,Method method){
//        this.target = Preconditions.checkNotNull(target);
        this.method = method;
        this.method.setAccessible(true);
    }

    public void execute(Object event){
        try{
            method.invoke(target, event);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

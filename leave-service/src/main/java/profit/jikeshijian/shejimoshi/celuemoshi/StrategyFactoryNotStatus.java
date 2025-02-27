package profit.jikeshijian.shejimoshi.celuemoshi;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: huangxiaogen
 * @Date: 2020/07/19/下午1:44
 * @Description:
 */

/**
 * 1。一般来讲，如果策略类是无状态的，不包含成员变量，只是纯粹的算法实现，这样的策略对象是可以被共享使用的
 * 2。不需要在每次调用 getStrategy() 的时候，都创建一个新的策略对象
 * 3。针对这种情况，我们可以使用上面这种工厂类的实现方式，事先创建好每个策略对象， 缓存到工厂类中，用的时候直接返回。
 * 4下面的就是无状态的
 *
 *
 *
 */
public class StrategyFactoryNotStatus {
    private static final Map<String,Strategy> strategies = new HashMap<>();

    static {
        strategies.put("A",new ConcreteStrategyA());
        strategies.put("B",new ConcreteStrategyB());

    }

    public static Strategy getStragy(String type){
        if (type ==null||type.isEmpty()){
            throw new IllegalArgumentException("type should not be empty");
        }
        return strategies.get(type);
    }
}

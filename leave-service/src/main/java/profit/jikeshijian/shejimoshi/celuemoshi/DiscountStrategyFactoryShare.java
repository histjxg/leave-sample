package profit.jikeshijian.shejimoshi.celuemoshi;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: huangxiaogen
 * @Date: 2020/07/19/下午2:18
 * @Description:
 */
//策略的创建（共享）
public class DiscountStrategyFactoryShare {
    private static final Map<OrderType, DiscountStrategy> strategies = new HashMap<>();

    static {
//        strategies.put(OrderType.NORMAL, new NormalDiscountStrategy());
//        strategies.put(OrderType.GROUPON, new GrouponDiscountStrategy());
//        strategies.put(OrderType.PROMOTION, new PromotionDiscountStrategy());
    }
    public static DiscountStrategy getDiscountStrategy(OrderType type) {
        return strategies.get(type);
    }

}

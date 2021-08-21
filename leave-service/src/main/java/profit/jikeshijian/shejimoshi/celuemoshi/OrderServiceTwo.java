package profit.jikeshijian.shejimoshi.celuemoshi;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: huangxiaogen
 * @Date: 2020/07/19/下午2:21
 * @Description:
 */

/**
 * 分析：
 * 1。重构之后的代码就没有了 if-else 分支判断语句了。实际上，这得益于策略工厂类
 * 2。在工厂 类中，我们用 Map 来缓存策略，根据 type 直接从 Map 中获取对应的策略，从而避免 if- else 分支判断逻辑。
 * 3。等后面讲到使用状态模式来避免分支判断逻辑的时候，你会发现，它们使用的是同样的套路
 * 4。本质上都是借助“查表法”，根据 type 查表(代码中的 strategies 就是表)替代根据 type 分支判断。
 * 5。
 *
 *
 *
 *
 *
 */
public class OrderServiceTwo {

    public double discount(Order order) {
        OrderType type = order.getType();
        DiscountStrategy discountStrategy = DiscountStrategyFactoryShare.getDiscountStrategy(type
        );
        return discountStrategy.calDiscount(order);
    }


}

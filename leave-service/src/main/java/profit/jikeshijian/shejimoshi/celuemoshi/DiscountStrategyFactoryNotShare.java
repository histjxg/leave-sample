package profit.jikeshijian.shejimoshi.celuemoshi;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: huangxiaogen
 * @Date: 2020/07/19/下午2:31
 * @Description:
 */

/**
 * 这种实现方式相当于把原来的 if-else 分支逻辑，从 OrderService 类中转移到了工厂类 中，实际上并没有真正将它移除。
 */
public class DiscountStrategyFactoryNotShare {
    public static DiscountStrategy getDiscountStrategy(OrderType type) {
        if (type==null){
            throw new IllegalArgumentException("Type should not be null");
        }
        if (type.equals(OrderType.NORMAL)){
//            return new NormalDiscountStrategy();
        }else  if (type.equals(OrderType.GROUPON)){
            //            return new GrouponDiscountStrategy();
        }else  if (type.equals(OrderType.PROMOTION)){
            //            return new PromotionDiscountStrategy();
        }
        return null;
    }


}

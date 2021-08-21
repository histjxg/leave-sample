package profit.jikeshijian.shejimoshi.celuemoshi;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: huangxiaogen
 * @Date: 2020/07/19/下午2:17
 * @Description:
 */
//策略的定义
public interface DiscountStrategy {
    double calDiscount(Order order);
}

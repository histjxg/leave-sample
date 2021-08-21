package profit.jikeshijian.shejimoshi.celuemoshi;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: huangxiaogen
 * @Date: 2020/07/19/下午2:17
 * @Description:
 */
@Data
public class Order {
    private String orderNo;
    private OrderType type;
}

// 省略NormalDiscountStrategy、GrouponDiscountStrategy、PromotionDiscountStrateg

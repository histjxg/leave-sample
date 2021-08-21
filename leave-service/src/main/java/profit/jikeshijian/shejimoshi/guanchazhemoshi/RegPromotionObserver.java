package profit.jikeshijian.shejimoshi.guanchazhemoshi;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: huangxiaogen
 * @Date: 2020/07/13/下午10:15
 * @Description:
 */

public class RegPromotionObserver implements RegObserver{

    //private PromotionService promotionService; // 依赖注入
    @Override
    public void handleRegSuccess(long userId) {
//        promotionService.issueNewUserExperienceCash(userId);
    }
}

package profit.jikeshijian.shejimoshi.guanchazhemoshi;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: huangxiaogen
 * @Date: 2020/07/13/上午9:40
 * @Description:
 */

/**
 *1。虽然注册接口做了两件事情，注册和发放体验金，违反单一职责原则
 * 2。但是，如果没有扩展和修改的需求，现在的代码实现是可以接受的
 * 3。如果非得用观察者模式，就需要引入更多的类和更加复杂的代码结构，反倒是一种过度设计。
 相反 ：
 1。如果需求频繁变动，比如，用户注册成功之后，不再发放体验金，而是改为发放优惠 券
 2。并且还要给用户发送一封“欢迎注册成功”的站内信
 3。这种情况下，我们就需要频繁地 修改 register() 函数中的代码，违反开闭原则
 4。着种情况下，我们就需要频繁地 修改 register() 函数中的代码，违反开闭原则。
 *
 *
 *
 *
 */
public class UserController {
//    private UserService userService; // 依赖注入
//    private PromotionService promotionService; // 依赖注入
//    public Long register(String telephone, String password) { //省略输入参数的校验代码 //省略userService.register()异常的try-catch代码
//        long userId = userService.register(telephone, password);
    //        promotionService.issueNewUserExperienceCash(userId);
    //        return userId;
//    }
}

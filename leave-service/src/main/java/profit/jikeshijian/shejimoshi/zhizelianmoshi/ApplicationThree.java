package profit.jikeshijian.shejimoshi.zhizelianmoshi;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: huangxiaogen
 * @Date: 2020/07/19/下午4:30
 * @Description:
 */


public class ApplicationThree {
    public static void main(String[] args) {
        HandlerChainThree chain = new HandlerChainThree();
        chain.addHandler(new HandlerAThree());
        chain.addHandler(new HandlerBThree());
        chain.handle();
    }

}

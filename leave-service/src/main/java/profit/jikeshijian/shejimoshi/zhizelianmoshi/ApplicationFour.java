package profit.jikeshijian.shejimoshi.zhizelianmoshi;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: huangxiaogen
 * @Date: 2020/07/19/下午4:45
 * @Description:
 */

public class ApplicationFour {
    public static void main(String[] args) {
        HandlerChainFour chain = new HandlerChainFour();
        chain.addHandler(new HandlerAFour());
        chain.addHandler(new HandlerBFour());
        chain.handle();
    }
}

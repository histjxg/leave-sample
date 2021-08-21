package profit.jikeshijian.shejimoshi.zhizelianmoshi;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: huangxiaogen
 * @Date: 2020/07/19/下午5:01
 * @Description:
 */

/**
 *1.应用设计模式主要是为了应对代码的复杂性，让其满足开闭原则，提高代码的扩展性
 *2.这里应用职责链模式也不例外
 *
 *
 *
 *
 */
public class SensitiveWordFilterTwo {
    // return true if content doesn't contain sensitive words.
    public boolean filter(Content content){
        if (!filterSexyWord(content)){
            return false;
        }
        if (!filterAdsWord(content)){
            return false;
        }
        if (!filterPoliticalWord(content)){
            return false;
        }
        return true;
    }
    private boolean filterSexyWord(Content content) {
        return false;
        //....
    }
    private boolean filterAdsWord(Content content) {
        return false;
        //....
    }
    private boolean filterPoliticalWord(Content content) {
        return false;
        //....
    }
}

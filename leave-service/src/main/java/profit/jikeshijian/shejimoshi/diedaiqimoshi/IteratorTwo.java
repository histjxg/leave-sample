package profit.jikeshijian.shejimoshi.diedaiqimoshi;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: huangxiaogen
 * @Date: 2020/07/25/上午11:06
 * @Description:
 */

/**
 *1.返回当前元素与后移一位这两个操作
 *2.要放到同一个函 数 next() 中完成。
 *
 *
 * @param <E>
 */
//接口定义方式二
public interface IteratorTwo<E> {
    boolean hasNext();
    E next();

}

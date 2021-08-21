package profit.jikeshijian.shejimoshi.diedaiqimoshi;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: huangxiaogen
 * @Date: 2020/07/25/上午11:49
 * @Description:
 */

/**
 * 1.我们需要将待遍历的容器对象，通过构造函数传递给迭代器类
 *2.实际上，为了封装迭代器的创建细节，我们可以在容器中定义一个 iterator() 方法，来创建对应的迭代器。
 * 3.为了能实现基于接口而非实现编程，我们还需要将这个方法定义在 List 接口中。
 *
 * @param <E>
 */
public class ArrayListOne<E> implements ListOne<E> {
    //...
    @Override
    public IteratorOne iterator() {
        return new ArrayIteratorOne(this);
    }
    //...省略其他代码
}

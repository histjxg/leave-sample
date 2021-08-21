package profit.jikeshijian.shejimoshi.diedaiqimoshi;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: huangxiaogen
 * @Date: 2020/07/25/上午11:05
 * @Description:
 */

import java.nio.file.NoSuchFileException;

/**
 * 1.next() 函数用来将游标后移一位元素
 *2.currentItem() 函数用来返回当前游标指向的元素
 * @param <E>
 */


//接口定义方式一
public interface IteratorOne<E> {

    boolean hasNext();
    void next();
    E currentItem() throws NoSuchFileException;
}

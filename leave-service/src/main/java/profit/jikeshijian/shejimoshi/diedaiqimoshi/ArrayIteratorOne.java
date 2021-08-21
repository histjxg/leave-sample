package profit.jikeshijian.shejimoshi.diedaiqimoshi;

import java.nio.file.NoSuchFileException;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: huangxiaogen
 * @Date: 2020/07/25/上午11:24
 * @Description:
 */

/**
 * 迭代器实现类，我们需要将待遍历的容器对象，通过构造函数传递给迭代器类。
 * 优化点：
 * 1。实际上，为了封装迭代器的创建细节
 * 2。我们可以在容器中定义一个 iterator() 方法，来创建对应的迭代器。
 * 3。为了能实现基于接口而非实现编程，我们还需要将这个方法定义在 List 接口中
 *
 * @param <E>
 */
public class ArrayIteratorOne<E> implements IteratorOne<E> {
    private int cursor;
    private ArrayList<E> arrayList;
    private ArrayListOne<E> arrayListOne;

    public ArrayIteratorOne(ArrayList<E> arrayList){
        this.cursor = 0;
        this.arrayList = arrayList;
    }

    public ArrayIteratorOne(ArrayListOne<E> arrayListOne) {
        this.cursor = 0;
        this.arrayListOne = arrayListOne;
    }

    @Override
    public boolean hasNext() {
        return cursor != arrayList.size(); //注意这里，cursor在指向最后一个元素的时候
    }

    @Override
    public void next() {
        cursor++;
    }

    @Override
    public E currentItem() throws NoSuchFileException {
        if (cursor>=arrayList.size()){
           throw new NoSuchFileException("no file");
        }
        return arrayList.get(cursor);
    }
}

package profit.jikeshijian.shejimoshi.diedaiqimoshi;

import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: huangxiaogen
 * @Date: 2020/07/25/上午11:29
 * @Description:
 */

/**
 *
 * 分析：
 * 1。foreach 循环只是一个语法糖而已，底层是基于迭代器来实现的
 * 2。上面代码中的第二种遍历方式(foreach 循环代码)的底层实现，
 * 3。就是第三种遍历方式(迭代器遍历代码)
 *问题：
 * 1。for 循环遍历方式比起迭代器遍历方式，代码看起来更加简洁
 * 2。那我们 为什么还要用迭代器来遍历容器呢?为什么还要给容器设计对应的迭代器呢?
     * 原因一：
         * 1。首先，对于类似数组和链表这样的数据结构，遍历方式比较简单，直接使用 for 循环来遍历 就足够了
         * 2。对于复杂的数据结构(比如树、图)来说，有各种复杂的遍历方式
              例子：
                树有前中后序、按层遍历，图有深度优先、广度优先遍历等等。
         * 1。如果由客户端代码来实现这些遍历算法，势必增加开发成本，而且容易写错
         * 2。如果将这部分遍历的逻辑写到容器类中，也会导致容器类代码的复杂性。
         * 方法：
             * 拆分，我们可以将遍历操作拆分到迭代器类中
             * 比如，针对图的遍历，我们就可以定义 DFSIterator、BFSIterator 两个迭代器类
             * 让它们分别来实现深度优先遍历和广度优先遍历。
     * 原因二：
         * 1。将游标指向的当前位置等信息，存储在迭代器类中，每个迭代器独享游标信息。
         * 2。这样，我们就可以创建多个不同的迭代器，同时对同一个容器进行遍历而互不影响。
     * 原因三：
         *1。容器和迭代器都提供了抽象的接口，方便我们在开发的时候，基于接口而非具体的实现编程
         * 2。当需要切换新的遍历算法的时候，
         * 例子：
             * 从前往后遍历链表切换成从后往前遍历链表
             *客户端代码只需要将迭代器类从 LinkedIterator 切换为 ReversedLinkedIterator 即可，其他代码都不需要修改
         * 3。添加新的遍历算法，我们只需要扩展新的迭代器类，也更符合开闭原则。
 *
 *
 */
public class IteratorDemo {
    public static void main(String[] args) throws NoSuchFileException {
        ArrayList<String> names = new ArrayList<>();
        names.add("xzg");
        names.add("wang");
        names.add("zheng");
        IteratorOne<String> iterator = new ArrayIteratorOne<>(names);
        while (iterator.hasNext()){
            System.out.println(iterator.currentItem());
            iterator.hasNext();
        }

        //第一种遍历方式：
        for (int i=0;i<names.size();i++){
            System.out.println(names.get(i) + ",");
        }

        //第二种遍历方式：foreach循环
        for (String name : names) {
            System.out.println(name + ",");
        }

        //第三种遍历方式：迭代器遍历
        Iterator iterator1 = names.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator1.next()+",");
        }
    }
}

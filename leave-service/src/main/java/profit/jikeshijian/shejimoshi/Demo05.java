package profit.jikeshijian.shejimoshi;

/**
 *
 利用接口类语法
 1.Iterator 是一个接口类，定义了一个可以遍历集合数据的迭代器
 2.Array 和 LinkedList 都实现了接口类 Iterator。
 3.我们通过传递不同类型的实现类(Array、 LinkedList)到 print(Iterator iterator) 函数中
 4.支持动态的调用不同的 next()、 hasNext() 实现。


 *
 */

public class Demo05 {
    private static void print(Iterator05 iterator) {
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        } }
    public static void main(String[] args) {
        Iterator05 arrayIterator = new Array05();
        print(arrayIterator);
        Iterator05 linkedListIterator = new LinkedList05();
        print(linkedListIterator);
    }

}

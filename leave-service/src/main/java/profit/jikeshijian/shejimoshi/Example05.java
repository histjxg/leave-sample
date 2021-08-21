package profit.jikeshijian.shejimoshi;

/**
 *
 *
 *
     1.第一个语法机制是编程语言要支持父类对象可以引用子类对象,也就是可以将 SortedDynamicArray 传递给 DynamicArray。
     2.第二个语法机制是编程语言要支持继承，也就是 SortedDynamicArray 继承了 DynamicArray，才能将 SortedDyamicArray 传递给 DynamicArray。
     3.第三个语法机制是编程语言要支持子类可以重写(override)父类中的方法，也就是 SortedDyamicArray 重写了 DynamicArray 中的 add() 方法。
通过这三种语法机制
     1。我们就实现了在 test() 方法中，子类 SortedDyamicArray 替换父类 DynamicArray
     2。执行子类 SortedDyamicArray 的 add() 方法，也就是实现了多态特性。

 *
 *
 *
 *
 *
 */
public class Example05 {
    public static void test(DynamicArray05 dynamicArray) {
        dynamicArray.add(5);
        dynamicArray.add(1);
        dynamicArray.add(3);
        for (int i = 0; i < dynamicArray.size(); ++i) {
            System.out.println(dynamicArray.get(i));
        }
    }
    public static void main(String args[]) {
        DynamicArray05 dynamicArray = new SortedDynamicArray05();
        test(dynamicArray);
        // 打印结果:1、3、5
    }

}

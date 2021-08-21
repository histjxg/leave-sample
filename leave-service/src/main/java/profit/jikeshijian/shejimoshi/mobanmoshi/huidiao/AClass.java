package profit.jikeshijian.shejimoshi.mobanmoshi.huidiao;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: huangxiaogen
 * @Date: 2020/07/18/下午7:04
 * @Description:
 */

/**
 *
 *   2。A 类事先注册某个函数 F 到 B 类，A 类在调用 B 类的 P 函数的时候，B 类反过来调用 A 类注册给它的 F 函数。
 *     说明：
 *         1。这里的 F 函数就是“回调函数”。
 *         2。A 调用 B，B 反过来又调用 A，这种调用机制就叫作“回调”。
 *问题：
 *  A 类如何将回调函数传递给 B 类呢?
 * 注意：
 *  不同的编程语言，有不同的实现方法
 *  C语言可以使 用函数指针
 *  java则需要使用包裹了回调函数的类对象，我们简称为回调对象。
 *  说明：
 *     1。回调跟模板 式一样，也具有复用和扩展的功能。
 *
 */

public class AClass {
    public static void main(String[] args) {
        BClass b = new BClass();
        b.process(new ICallback() { //回调对象
            @Override
            public void methodToCallback() {
                System.out.println("Call back me.");
            } });
    }
}

package profit.jikeshijian.shejimoshi.mobanmoshi;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: huangxiaogen
 * @Date: 2020/07/18/下午5:01
 * @Description:
 */

/**
 * 1.templateMethod() 函数定义为 final，是为了避免子类重写它
 * 2.method1()和 method2() 定义为 abstract，是为了强迫子类去实现。
 * 3.不过，这些都不是必须的，在实际的项目开发中，模板模式的代码 实现比较灵活，
 * 4.待会儿讲到应用场景的时候，我们会有具体的体现
 * 5.
 *
 *
 *
 *
 */
public abstract class AbstractClass {
    public final void templateMethod(){
        //..
        method1();
        //...
        method2();
        //.....
    }

    protected abstract void method1();
    protected abstract void method2();

}

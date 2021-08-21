package profit.jikeshijian.shejimoshi.mobanmoshi.huidiao;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: huangxiaogen
 * @Date: 2020/07/18/下午7:03
 * @Description:
 */

/**
 *
 *1。上面就是 Java 语言中回调的典型代码实现。从代码实现中，我们可以看出，回调跟模板模 式一样，也具有复用和扩展的功能
 *2。除了回调函数之外，BClass 类的 process() 函数中的 逻辑都可以复用。
 * 3。如果 ICallback、BClass 类是框架代码，AClass 是使用框架的客户端代 码，我们可以通过 ICallback 定制 process() 函数
 * 4。也就是说，框架因此具有了扩展的能 力。
 * 说明：
 * 1。除了回调函数之外，BClass 类的 process() 函数中的逻辑都可以复用。
 * 2。如果 ICallback、BClass 类是框架代码，AClass 是使用框架的客户端代 码
 * 3。我们可以通过 ICallback 定制 process() 函数，也就是说，框架因此具有了扩展的能 力。
 *
 *
 *
 *
 *
 */
public class BClass {
    public void process(ICallback callback) {
        //...
        callback.methodToCallback();
        //...
    }


}

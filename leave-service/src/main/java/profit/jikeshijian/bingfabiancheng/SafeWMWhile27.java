package profit.jikeshijian.bingfabiancheng;

import java.util.concurrent.atomic.AtomicReference;

/**
 *
 *
 *
 看上去 while(!rf.compareAndSet(or, nr)) 是有终止条件的
 而且跑单线程测试一直都没有问题。
 1。实际上却存在严重的并发问题，问题就出在对or的赋值在while循环之外
 2。这样每次循环or的值都不会发生变化，所以一旦有一次循环rf.compareAndSet(or, nr)的值等于false
 3。那之后无论循环多少次，都会等于false
 4。也就是说在特定场景下，变成了while(true)问题
 5。既然找到了原因，修改就很简单了，只要把对or的赋值移到while循环之内就可以了
 6
 *
 *
 *
 *
 *
 *
 */
public class SafeWMWhile27 {
    class WMRange{
        final int upper =0;
        final int lower=0;
        WMRange(int upper,int lower){
            //省略构造函数实现
        }
    }
    final AtomicReference<WMRange>
            rf = new AtomicReference<>(
            new WMRange(0,0)
    );
    // 设置库存上限
    void setUpper(int v){
        WMRange nr;
        WMRange or;
        //原代码在这里
        //WMRange or=rf.get();
        do{
            //移动到此处
            //每个回合都需要重新获取旧值
            or = rf.get();
            // 检查参数合法性
            if(v < or.lower){
                throw new IllegalArgumentException();
            }
            nr = new
                    WMRange(v, or.lower);
        }while(!rf.compareAndSet(or, nr));
    }
}

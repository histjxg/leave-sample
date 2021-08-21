package profit.jikeshijian.bingfabiancheng;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 *
 下面我们就以 ArrayList 为例，看看如何将它变成线程安全的
 在下面的代码中
 1.SafeArrayList 内部持有一个 ArrayList 的实例 c
 2.所有访问 c 的方法我们都增加了 synchronized 关键字
 3.需要注意的是我们还增加了一个 addIfNotExist() 方法
 4.这个方法也是用 synchronized 来保证原子性 的。
 *
 *
 *
 注意：
 组合操作需要注意竞态条件问题，
 addIfNotExist() 方法就包含组合操作
 组合操作往往隐藏着竞态条件问题，即便每个操作都能保证原子性
 也并不能保证 组合操作的原子性，这个一定要注意。
 *
 *
 *
 *
 */

public class SafeArrayList20<T> {
        // 封装 ArrayList
        List<T> c = new ArrayList<>();
        // 控制访问路径
        synchronized T get(int idx){
            return c.get(idx);
        }

        synchronized void add(int idx, T t) {
            c.add(idx, t);
        }

        synchronized boolean addIfNotExist(T t){
            if(!c.contains(t)) {
                c.add(t);
                return true;
            }
            return false;
        }

}

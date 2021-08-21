package profit.jikeshijian.bingfabiancheng;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 *
 *
背景：
 1。有一个RPC框架路由表的案例，在RPC框架中， 本地路由表是要和注册中心进行信息同步的，应用启动的时候，会将应用依赖服务的路由表从注册中心同步 到本地路由表中
 2。如果应用重启的时候注册中心宕机，那么会导致该应用依赖的服务均不可用，因为找不到 依赖服务的路由表。
 3。为了防止这种极端情况出现，RPC框架可以将本地路由表自动保存到本地文件中，如果 重启的时候注册中心宕机
 4。那么就从本地文件中恢复重启前的路由表。这其实也是一种降级的方案

 实现：
 1。自动保存路由表和前面介绍的编辑器自动保存原理是一样的，也可以用Balking模式实现，
 2。不过我们这里采 用volatile来实现，实现的代码如下所示
 3。之所以可以采用volatile来实现，是因为对共享变量changed和rt的 写操作不存在原子性的要求
 4。而且采用scheduleWithFixedDelay()这种调度方式能保证同一时刻只有一个线 程执行autoSave()方法。


 *
 *
 *
 *
 *
 *
 *
 *
 */
public class RouterTableFour32 {
    //Key:接口名
    //Value:路由集合
    ConcurrentHashMap<String, CopyOnWriteArraySet<RouterImmutability29>> rt = new ConcurrentHashMap<>();
    //路由表是否发生变化
    volatile boolean changed;
    //将路由表写入本地文件的线程池
    ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor(); //启动定时任务

    //将变更后的路由表写入本地文件
    public void startLocalSaver() {
        ses.scheduleWithFixedDelay(() -> {
            autoSave();
        }, 1, 1, TimeUnit.MINUTES);
    }

    //保存路由表到本地文件
    void autoSave() {
        if (!changed) {
            return;
        }
        changed = false; //将路由表写入本地文件 //省略其方法实现
        //this.save2Local();
    }

    //删除路由
    public void remove(RouterImmutability29 router) {
        Set<RouterImmutability29> set = rt.get(router.getIface());
        if (set != null) {
            set.remove(router); //路由表已发生变化
            changed = true;
        }
    }

    //增加路由
    public void add(RouterImmutability29 router) {
        Set<RouterImmutability29> set = rt.computeIfAbsent(router.getIface(), r -> new CopyOnWriteArraySet<>());
        set.add(router);
        //路由表已发生变化
        changed = true;
    }
}

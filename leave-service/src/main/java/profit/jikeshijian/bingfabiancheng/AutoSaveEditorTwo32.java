package profit.jikeshijian.bingfabiancheng;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 *
 *
 *
 示例中的共享变量是一个状态变量，业务逻辑依赖于这个 状态变量的状态:
 当状态满足某个条件时，执行某个业务逻辑，其本质其实不过就是一个if而已，放到多线程场景里
 就是一种“多线程版本的if”。这种“多线程版本的if”的应用场景还是很多的，所以也有人把 它总结成了一种设计模式，叫做Balking模式。

 *
 *
 *
 *
 */
public class AutoSaveEditorTwo32 {
    //文件是否被修改过
    boolean changed = false; //定时任务线程池
    ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor(); //定时执行自动保存

    void startAutoSave() {
        ses.scheduleWithFixedDelay(() -> {
            autoSave();
        }, 5, 5, TimeUnit.SECONDS);
    }

    //自动存盘操作
    void autoSave() {
        synchronized (this){
            if (!changed) {
                return;
            }
            changed = false; //执行存盘操作 //省略且实现
            // this.execSave();
        }

    }

    //编辑操作
    void edit() {
        //省略编辑逻辑 ......
        synchronized (this){
            changed = true;
        }

    }
}

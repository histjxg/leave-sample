package profit.jikeshijian.bingfabiancheng;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 *
  下面的示例代码将自动保存功能代码化了
 1.很显然AutoSaveEditor这个类不是线程安全的
 2.因为对共享变量changed的读写没有使用同步，那如何保证AutoSaveEditor的线程安全性呢?
 方法：
 1。读写共享变量changed的方法autoSave()和edit()都加互斥锁就可以 了
 缺点；
 这样做虽然简单，但是性能很差，原因是锁的范围太大了
 3。
 那我们可以将锁的范围缩小，只在读写共享 变量changed的地方加锁，实现代码如下所示。

 4.
 5.




 *
 *
 *
 *
 */
public class AutoSaveEditorOne32 {
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
        if (!changed) {
            return;
        }
        changed = false; //执行存盘操作 //省略且实现
        // this.execSave();
    }

    //编辑操作
    void edit() {
        //省略编辑逻辑 ......
        changed = true;
    }

}

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
 你会发现仅仅是将edit()方法中对共享变量changed的赋值操作抽 取到了change()中
 这样的好处是将并发处理逻辑和业务逻辑分开。


 *
 *
 *
 *
 */
public class AutoSaveEditorThree32 {
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
        change();

    }
    void change(){
        synchronized (this){
            changed=true;
        }
    }
}

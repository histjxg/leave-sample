package profit.估泡.thread.synchronzed;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

//--XX:-UseCompressedOops
//https://blog.csdn.net/qq_30908729/article/details/90720745

/**
 * 查看轻量级锁
 */
public class ClassLayoutDemo {
    public static void main(String[] args) {
        ClassLayoutDemo classLayoutDemo = new ClassLayoutDemo();
        //jvm信息
        System.out.println(VM.current().details());
        System.out.println(ClassLayout.parseInstance(classLayoutDemo).toPrintable());//无锁

    }
}

package profit.估泡.thread.synchronzed;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

public class JOLExample1 {
    static  B b = new B();
    public static void main(String[] args) {
        //jvm的信息
        System.out.println(VM.current().details());
        System.out.println(ClassLayout.parseInstance(b).toPrintable());
    }
}

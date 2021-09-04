package profit.估泡.thread.synchronzed;

import org.openjdk.jol.info.ClassLayout;

public class JOLExample2 {
    public static void main(String[] args) throws Exception {
        B b = new B();
        System.out.println("befor hash");
        //没有计算HASHCODE之前的对象头
        System.out.println(ClassLayout.parseInstance(b).toPrintable());//无锁
        //JVM 计算的hashcode
        System.out.println("jvm------------0x"+Integer.toHexString(b.hashCode()));
        HashUtil.countHash(b);
        //当计算完hashcode之后，我们可以查看对象头的信息变化
        System.out.println("after hash");
        System.out.println(ClassLayout.parseInstance(b).toPrintable());

    }
}

package profit.jvm;

import java.util.ArrayList;
import java.util.List;

public class RunTimeConstantPoolOOM {
    public static void main(String[] args) {
        //jdk1。7  -XX:PermSize=10M -XX:MaxPermSize=10M
        //jdk1。8 -XX:MetaspaceSize=5M -XX:MaxMetaspaceSize=7M
        //使用list 保持着常量池引用过，避免full gc回收常量池行为
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true){
            list.add(String.valueOf(i++).intern());
        }

    }
}

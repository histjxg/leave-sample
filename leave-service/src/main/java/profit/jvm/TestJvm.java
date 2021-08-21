package profit.jvm;

import java.lang.reflect.Method;

public class TestJvm {
    public static void target(int i) {
        new Exception("#" + i).printStackTrace();
    }

    public static void main(String[] args) throws Exception {
        Class<?> klass = Class.forName("profit.jvm.TestJvm");
        Method method = klass.getMethod("target", int.class);
        method.invoke(null, 0);
    }
}

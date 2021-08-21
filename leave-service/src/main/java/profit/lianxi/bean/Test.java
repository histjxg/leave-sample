package profit.lianxi.bean;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

class User {
    private String name = "";
    private int age = 0;
    public User() {
        this.name = "test";
        this.age = 22;
    }

    @Override
    public String toString() {
        return name+" :"+age;
    }
}

public class Test{
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        //通过反射得到theUsafe对应的field对象
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        //设置Field为可访问
        field.setAccessible(true);
        // 通过Field得到该Field对应的具体对象，传入null是因为该Field为static的
        Unsafe unsafe = (Unsafe)field.get(null);
        User user =(User) unsafe.allocateInstance(User.class);
        System.out.println(user);
        User userFromNormal = new User();
        System.out.println(userFromNormal);

    }
}

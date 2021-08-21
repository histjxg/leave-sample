package profit.jikeshijian.xiengnengyouhua;

public class JVMCase20 {
    // 常量
    public final static String MAN_SEX_TYPE = "man";

    // 静态变量
    public static String WOMAN_SEX_TYPE = "woman";

    public static void main(String[] args) {

        Student18 stu = new Student18();
        stu.setName("nick");
        stu.setSexType(MAN_SEX_TYPE);
        stu.setAge(20);

        JVMCase20 jvmcase = new JVMCase20();

        // 调用静态方法
        print(stu);
        // 调用非静态方法
        jvmcase.sayHello(stu);
    }


    // 常规静态方法
    public static void print(Student18 stu) {
        System.out.println("name: " + stu.getName() + "; sex:" + stu.getSexType() + "; age:" + stu.getAge());
    }


    // 非静态方法
    public void sayHello(Student18 stu) {
        System.out.println(stu.getName() + "say: hello");
    }
}


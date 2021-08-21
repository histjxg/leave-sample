package profit.jikeshijian.xiengnengyouhua;

public class JVMCase {

    // 常量
    public final static String MAN_SEX_TYPE = "man";

    // 静态变量
    public static String WOMAN_SEX_TYPE = "woman";

    public static void main(String[] args) {

        People stu = new People();
        stu.setName("nick");
        stu.setSexType(MAN_SEX_TYPE);
        stu.setAge(20);

        JVMCase jvmcase = new JVMCase();

        // 调用静态方法
        print(stu);
        // 调用非静态方法
        jvmcase.sayHello(stu);
    }


    // 常规静态方法
    public static void print(People stu) {
        System.out.println("name: " + stu.getName() + "; sex:" + stu.getSexType() + "; age:" + stu.getAge());
    }


    // 非静态方法
    public void sayHello(People stu) {
        System.out.println(stu.getName() + "say: hello");
    }
}

class People{
    String name;
    String sexType;
    int age;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSexType() {
        return sexType;
    }
    public void setSexType(String sexType) {
        this.sexType = sexType;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
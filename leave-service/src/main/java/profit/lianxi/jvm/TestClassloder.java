package profit.lianxi.jvm;

public class TestClassloder {
    public static void main(String[] args) {
        Object object = new Object(); // Bootstrap加载器获得值是null
        System.out.println("********"+object.getClass().getClassLoader());
        System.out.println();


        //Object object = new Object(); // Bootstrap加载器获得值是null
      //  Class
        System.out.println("********"+object.getClass().getClassLoader());
        System.out.println();


        TestClassloder testClassloder = new TestClassloder(); //应用程序类加载器（App）Java
        //也叫系统类加载器，加载当前应用的classpath的所有类

        //双亲委派机制+沙箱机制（防止恶意代码）

        //某个特定的类加载器在接到加载类的请求时，首先将加载任务委托给父类加载器，
        // 依次递归，如果父类加载器可以完成类加载任务，就成功返回；
        // 只有父类加载器无法完成此加载任务时，才自己去加载。
        //


        System.out.println("********"+testClassloder.getClass().getClassLoader());
        System.out.println("********"+testClassloder.getClass().getClassLoader().getParent());
        System.out.println("********"+testClassloder.getClass().getClassLoader().getParent().getParent());

        System.out.println();


    }
}

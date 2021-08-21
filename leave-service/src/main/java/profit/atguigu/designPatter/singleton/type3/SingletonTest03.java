package profit.atguigu.designPatter.singleton.type3;

public class SingletonTest03 {
    public static void main(String[] args) {
        //测试
        Singleton instance =  Singleton
                .getInstance();
        Singleton instance2 =  Singleton
                .getInstance();
        System.out.println(instance==instance2);//true
        System.out.println(instance.hashCode()==instance2.hashCode());

    }
}

//懒汉式 线程不安全 不推荐使用
class  Singleton{
    private static Singleton singleton;

    private Singleton() {}

    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
}

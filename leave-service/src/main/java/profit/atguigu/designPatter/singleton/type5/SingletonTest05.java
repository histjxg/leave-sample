package profit.atguigu.designPatter.singleton.type5;

public class SingletonTest05 {
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

//懒汉式 线程安全问题（不推荐使用）同步代码快
class  Singleton{
    private static Singleton singleton;

    private Singleton() {}

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) { //同步代码快
                singleton = new Singleton();
            }
        }
        return singleton;
    }
}

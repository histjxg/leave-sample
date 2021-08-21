package profit.atguigu.designPatter.singleton.type4;

public class SingletonTest04 {
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

//懒汉式 线程安全问题（不推荐使用）同步方法
class  Singleton{
    private static Singleton singleton;

    private Singleton() {}
    //加入同步处理的代码
    public synchronized static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
}

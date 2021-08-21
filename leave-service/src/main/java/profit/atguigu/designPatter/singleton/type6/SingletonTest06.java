package profit.atguigu.designPatter.singleton.type6;

public class SingletonTest06 {
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

//双重检索，推荐使用
class  Singleton{
    private static volatile Singleton singleton;

    private Singleton() {}
  //提供一个静态的公有方法，加入双重检查代码，解决线程安全问题，同时解决懒加载问题
    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}

package profit.atguigu.designPatter.singleton.type1;

public class SingletonTest01 {
    public static void main(String[] args) {
        //测试
        Singleton instance =  Singleton.getInstance();
        Singleton instance2 =  Singleton.getInstance();
        System.out.println(instance==instance2);//true
        System.out.println(instance.hashCode()==instance2.hashCode());

    }
}

//饿汉式（静态变量）
class  Singleton{
    //本类内部类对象实例
    private final static Singleton INSTANCE = new Singleton();

    //构造器私有化
    private Singleton(){}
    //提供对外访问实例
    public static Singleton getInstance(){
        return INSTANCE;
    }
}

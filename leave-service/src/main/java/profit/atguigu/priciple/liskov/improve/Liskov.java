package profit.atguigu.priciple.liskov.improve;

public class Liskov {
    public static void main(String[] args) {


    }


    
}
//最主要把继承的关系改成组成，依赖，或者聚合，降低A和B的耦合度
class Base{
    //把更加基础的类写到B类
}
class A extends Base{
    public int func1(int a, int b){
        return a-b;
    }
}
class B extends Base{
    private A a = new A();
    //这里重写了A类的方法，可能是无意识的
    public int func1(int a, int b){
        return a+b;
    }

    public int func2(int a, int b){
        return func1(a,b)+100;
    }

    //我们仍然想使用A类的方法
    public int fun3(int a,int b){
        return this.a.func1(a, b);
    }
}

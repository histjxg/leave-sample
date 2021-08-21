package profit.lianxi.jvm;

public class StackDemo {
    public static void sayHello(){
        sayHello();
    }
  //死循环
    public static void main(String[] args) {
        sayHello();
    }
}

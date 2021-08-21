package profit.jikeshijian.JVM;

public class Foo {
    private static final int a=5;
    public static void main(String[] paramArrayOfString)
    {
        int i = 1;
        if (i != 0) {
            System.out.println("Hello, Java!");
        }
        if (i == 1) {
            System.out.println("Hello, JVM!");
        }
        print();
    }
    public static void  print(){
        System.out.println(123);
    }

}

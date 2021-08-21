package profit.atguigu.priciple.liskov;

public class Liskov {
    public static void main(String[] args) {


    }

    class A{
        public int func1(int a, int b){
            return a-b;
        }
    }
    class B extends A{
        public int func1(int a, int b){
            return a+b;
        }

        public int func2(int a, int b){
            return func1(a,b)+100;
        }
    }


}

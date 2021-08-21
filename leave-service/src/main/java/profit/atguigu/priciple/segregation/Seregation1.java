package profit.atguigu.priciple.segregation;

public class Seregation1 {
    public static void main(String[] args) {

    }
}

interface Interface1{
    void operation1();
    void operation2();
    void operation3();
    void operation4();
    void operation5();
}
interface Interface2{
    void operation1();
}
interface Interface3{
    void operation2();
    void operation3();
}
interface Interface4{
    void operation4();
    void operation5();
}
class B implements Interface1{

    @Override
    public void operation1() {
        System.out.println("B 实行了operation1");
    }

    @Override
    public void operation2() {
        System.out.println("B 实行了operation2");
    }

    @Override
    public void operation3() {
        System.out.println("B 实行了operation3");
    }

    @Override
    public void operation4() {
        System.out.println("B 实行了operation4");
    }

    @Override
    public void operation5() {
        System.out.println("B 实行了operation5");
    }
}

class D implements Interface1{

    @Override
    public void operation1() {
        System.out.println("D 实行了operation1");
    }

    @Override
    public void operation2() {
        System.out.println("D 实行了operation2");
    }

    @Override
    public void operation3() {
        System.out.println("D 实行了operation3");
    }

    @Override
    public void operation4() {
        System.out.println("D 实行了operation4");
    }

    @Override
    public void operation5() {
        System.out.println("D 实行了operation5");
    }
}

class A{
    public void depend1(Interface1 interface1){
        interface1.operation1();
    }
    public void depend2(Interface1 interface1){
        interface1.operation2();
    }
    public void depend3(Interface1 interface1){
        interface1.operation3();
    }
}

class C{
    public void depend1(Interface1 interface1){
        interface1.operation1();
    }
    public void depend4(Interface1 interface1){
        interface1.operation4();
    }
    public void depend5(Interface1 interface1){
        interface1.operation5();
    }
}


package profit.atguigu.priciple.singlersponsibility;

public class SingleResponsebility3 {
    public static void main(String[] args) {
        Vehicle2 vehicle = new Vehicle2();
        vehicle.run("摩托");
        vehicle.runAir("飞机");
        vehicle.runWater("轮船");
    }
}
//方法三的分析
//1。这种修改方法没有对原来的类做大的修改，只是增加方法
//2。这里虽然没有在类这个级别上遵守单一职责原则，但是在方法的级别上，仍然是遵守单一职责
class Vehicle2 {
    public void run(String vehicle) {
        System.out.println(vehicle + " 在公路上运行。。。。。。");
    }
    public void runAir(String vehicle) {
        System.out.println(vehicle + " 在天空上运行。。。。。。");
    }
    public void runWater(String vehicle) {
        System.out.println(vehicle + " 在水中上运行。。。。。。");
    }
}


package profit.atguigu.priciple.singlersponsibility;

//单一职责原则 ：
//1。降低类的复杂度，一个类只负责一项原则
//2。提高类的可读性，可维护性
//3。降低变更引起的风险
//4。通常情况下，我们应当遵守单一职责原则，只有逻辑足够简单，才可以在代码违反
//单一职责原则；只有类方法数量足够多，可以在方法级别保持单一职责原则；
// https://blog.csdn.net/zhengzhb/article/details/7278174
public class SingleResponsebility1 {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.run("摩托");
        vehicle.run("汽车");
        vehicle.run("飞机");
    }
}

//交通工具类
//方式1
//1。在方式1的run方法中，违反了单一职责原则
//2。解决的方案非常的简单，根据交通工具运行方法不同，分解不同的类即可
class Vehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + " 在公路上运行。。。。。。");
    }

}

package profit.atguigu.designPatter.factory.factorymethod.pizzastore.pizza;

public class BjPepperPizza extends Pizza {
    public void prepare(){
        System.out.println("开始准备北京pepperPizza");
    }
    public void bake(){
        System.out.println("正在烤北京pepperPizza");
    }
    public void cut(){
        System.out.println("正在切北京pepperPizza");
    }
    public void box(){
        System.out.println("正在打包北京pepperPizza");
    }
}

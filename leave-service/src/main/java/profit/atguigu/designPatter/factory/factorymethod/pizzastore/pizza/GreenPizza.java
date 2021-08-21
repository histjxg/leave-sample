package profit.atguigu.designPatter.factory.factorymethod.pizzastore.pizza;

public class GreenPizza extends Pizza {
    public void prepare(){
        System.out.println("开始准备GreenPiazza");
    }
    public void bake(){
        System.out.println("正在烤GreenPiazza");
    }
    public void cut(){
        System.out.println("正在切GreenPiazza");
    }
    public void box(){
        System.out.println("正在打包GreenPiazza");
    }
}

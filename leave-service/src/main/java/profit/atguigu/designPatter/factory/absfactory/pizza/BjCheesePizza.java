package profit.atguigu.designPatter.factory.absfactory.pizza;

public class BjCheesePizza extends Pizza {
    public void prepare(){
        System.out.println("开始准备北京CheesePizza");
    }
    public void bake(){
        System.out.println("正在烤北京CheesePizza");
    }
    public void cut(){
        System.out.println("正在切北京CheesePizza");
    }
    public void box(){
        System.out.println("正在打包北京CheesePizza");
    }
}

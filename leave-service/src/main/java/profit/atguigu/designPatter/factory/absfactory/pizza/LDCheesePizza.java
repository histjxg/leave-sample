package profit.atguigu.designPatter.factory.absfactory.pizza;

public class LDCheesePizza extends Pizza {
    public void prepare(){
        System.out.println("开始准备伦敦CheesePizza");
    }
    public void bake(){
        System.out.println("正在烤伦敦CheesePizza");
    }
    public void cut(){
        System.out.println("正在切伦敦CheesePizza");
    }
    public void box(){
        System.out.println("正在打包伦敦CheesePizza");
    }
}

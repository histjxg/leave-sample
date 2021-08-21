package profit.atguigu.designPatter.factory.absfactory.pizza;

public class LDPepperPizza extends Pizza {
    public void prepare(){
        System.out.println("开始准备伦敦pepperPizza");
    }
    public void bake(){
        System.out.println("正在烤伦敦pepperPizza");
    }
    public void cut(){
        System.out.println("正在切伦敦pepperPizza");
    }
    public void box(){
        System.out.println("正在打包伦敦pepperPizza");
    }
}

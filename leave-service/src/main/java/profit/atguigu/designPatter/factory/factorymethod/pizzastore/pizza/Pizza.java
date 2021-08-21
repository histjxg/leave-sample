package profit.atguigu.designPatter.factory.factorymethod.pizzastore.pizza;

public abstract class Pizza {
    //四个抽象方法
    public abstract void prepare();
    public abstract void bake();
    public abstract void cut();
    public abstract void box();
}

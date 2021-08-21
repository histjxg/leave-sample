package profit.atguigu.designPatter.factory.absfactory.order;

import profit.atguigu.designPatter.factory.absfactory.pizza.BjCheesePizza;
import profit.atguigu.designPatter.factory.absfactory.pizza.BjPepperPizza;
import profit.atguigu.designPatter.factory.absfactory.pizza.Pizza;

public class BJFactory implements AbsFactory{

    @Override
    public Pizza createPizza(String orderType) {
        System.out.println("~使用的抽象工厂模式～");
        Pizza pizza = null;
        if (orderType.equals("cheese")){
            pizza = new BjCheesePizza();
        }else if (orderType.equals("pepper")){
            pizza = new BjPepperPizza();
        }
        return pizza;
    }
}

package profit.atguigu.designPatter.factory.factorymethod.pizzastore.order;

import profit.atguigu.designPatter.factory.factorymethod.pizzastore.pizza.LDCheesePizza;
import profit.atguigu.designPatter.factory.factorymethod.pizzastore.pizza.LDPepperPizza;
import profit.atguigu.designPatter.factory.factorymethod.pizzastore.pizza.Pizza;

public class LDOrderPizza extends OrderPizza{
    @Override
    Pizza createPizza(String orderType) {
        if (orderType.equals("pepper")){
            pizza= new LDPepperPizza();
        }else if (orderType.equals("cheese")){
            pizza= new LDCheesePizza();
        }
        return pizza;
    }
}

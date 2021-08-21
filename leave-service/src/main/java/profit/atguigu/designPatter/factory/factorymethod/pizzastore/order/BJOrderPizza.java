package profit.atguigu.designPatter.factory.factorymethod.pizzastore.order;

import profit.atguigu.designPatter.factory.factorymethod.pizzastore.pizza.BjCheesePizza;
import profit.atguigu.designPatter.factory.factorymethod.pizzastore.pizza.BjPepperPizza;
import profit.atguigu.designPatter.factory.factorymethod.pizzastore.pizza.Pizza;

public class BJOrderPizza extends OrderPizza{
    @Override
    Pizza createPizza(String orderType) {
        if (orderType.equals("pepper")){
            pizza= new BjPepperPizza();
        }else if (orderType.equals("cheese")){
            pizza= new BjCheesePizza();
        }
        return pizza;
    }
}

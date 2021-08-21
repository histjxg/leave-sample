package profit.atguigu.designPatter.factory.simplefactory.pizzastore.order;

import profit.atguigu.designPatter.factory.factorymethod.pizzastore.pizza.GreenPizza;
import profit.atguigu.designPatter.factory.factorymethod.pizzastore.pizza.LDCheesePizza;
import profit.atguigu.designPatter.factory.factorymethod.pizzastore.pizza.Pizza;

//简单工厂模式
public class SimpleFactory {
    public Pizza createPizza(String orderType){
        Pizza pizza = null;
        System.out.println("使用简单工厂模式");
        if (orderType.equals("greek")){
            pizza= new GreenPizza();
        }else if (orderType.equals("cheese")){
            pizza= new LDCheesePizza();
        }else {
            return null;
        }
       return pizza;
    }

    //简单工厂模式也叫静态工厂模式

    public static Pizza createPizza2(String orderType){
        Pizza pizza = null;
        System.out.println("使用简单工厂模式");
        if (orderType.equals("greek")){
            pizza= new GreenPizza();
        }else if (orderType.equals("cheese")){
            pizza= new LDCheesePizza();
        }else {
            return null;
        }
        return pizza;
    }

}

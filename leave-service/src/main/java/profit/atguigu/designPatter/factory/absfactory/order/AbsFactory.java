package profit.atguigu.designPatter.factory.absfactory.order;

import profit.atguigu.designPatter.factory.absfactory.pizza.Pizza;

public interface AbsFactory {
    //四个抽象方法
    //定义一个抽象方法，createPizza，让各个子类
    Pizza createPizza(String orderType);
}

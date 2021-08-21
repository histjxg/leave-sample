package profit.atguigu.designPatter.factory.factorymethod.pizzastore.order;

import profit.atguigu.designPatter.factory.factorymethod.pizzastore.pizza.Pizza;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public  abstract  class OrderPizza {
    Pizza pizza= null;
    //构造器
    public OrderPizza(){
        String orderType ="";
        do {
            orderType = getType();
            pizza = createPizza(orderType);
            if (pizza!=null){
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            }else {
                System.out.println("订购pizza失败");
                break;
            }
        }while (true);
    }



    //定义一个抽象方法，createPizza，让各个子类
    abstract Pizza createPizza(String orderType);

    private String getType(){
        try {
            BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("input pizza type");
            String str  = strin.readLine();
            return str;
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }

    }
}

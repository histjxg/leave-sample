package profit.atguigu.designPatter.factory.simplefactory.pizzastore.order;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import profit.atguigu.designPatter.factory.factorymethod.pizzastore.pizza.Pizza;


public class OrderPizza {
    SimpleFactory simpleFactory;
    Pizza pizza= null;
    //构造器
    public OrderPizza(SimpleFactory simpleFactory){
        setSimpleFactory(simpleFactory);
    }
    //聚合的关系
    public void setSimpleFactory(SimpleFactory simpleFactory) {
        String orderType ="";
        this.simpleFactory = simpleFactory;
        do {
            orderType = getType();
            pizza = this.simpleFactory.createPizza(orderType);
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

    //构造器
    public OrderPizza(){
       /* Pizza pizza= null;
        String orderType; //订购披萨类型
        do {
            orderType = getType();
            if (orderType.equals("greek")){
                pizza= new GreenPizza();
            }else if (orderType.equals("cheese")){
                pizza= new CheesePizza();
            }else {
                break;
            }
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();

        }while (true);*/

    }
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

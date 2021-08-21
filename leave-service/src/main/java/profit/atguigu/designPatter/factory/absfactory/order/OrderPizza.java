package profit.atguigu.designPatter.factory.absfactory.order;

import profit.atguigu.designPatter.factory.absfactory.pizza.Pizza;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class OrderPizza {
    AbsFactory absFactory ;

    //构造器
    public OrderPizza(AbsFactory absFactory){
        setAbsFactory(absFactory);
    }

    public void setAbsFactory(AbsFactory absFactory){
        Pizza pizza =null;
        String orderType ="";
        this.absFactory = absFactory;
        do {
            orderType = getType();
            //factory 可能是北京的工厂子类，也可能是伦敦的工厂子类
            pizza =absFactory.createPizza(orderType);
            if (pizza!=null){
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            }else {
                System.out.println("订购失败");
                break;
            }
        }while (true);
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

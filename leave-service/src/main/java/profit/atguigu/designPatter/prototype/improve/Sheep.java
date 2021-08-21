package profit.atguigu.designPatter.prototype.improve;

import lombok.Data;

@Data
public class Sheep implements Cloneable{


    private String name;
    private int age;
    private String color;

    public Sheep friend; //是一个类


    public Sheep(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    //克隆该实例，使用默认的clone方法
    @Override
    protected Object clone() {
        Sheep sheep = null;
        try {
            sheep = (Sheep) super.clone();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return sheep;
    }
}

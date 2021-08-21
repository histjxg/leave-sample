package profit.atguigu.uml.composition;

import lombok.Data;

@Data
public class Computer {
    private Mouse mouse = new Mouse(); //鼠标和computer不可分离
    private Monitor monitor = new Monitor(); //显示器可以和computer不可分离

}

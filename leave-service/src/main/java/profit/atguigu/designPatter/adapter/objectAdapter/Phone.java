package profit.atguigu.designPatter.adapter.objectAdapter;

public class Phone {
    //充电
    public void charging(IVoltage5V iVoltage5V){
        if (iVoltage5V.output5V()==5){
            System.out.println("电压为5v，可以充电～～～～～");
        }else if (iVoltage5V.output5V()>5){
            System.out.println("电压大于5V，无法充电");
        }
    }
}

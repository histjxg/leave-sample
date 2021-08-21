package profit.atguigu.designPatter.adapter.objectAdapter;

/**
 * 适配器类
 */
public class VoltageAdapter implements IVoltage5V {
    private  Voltage220V voltage220V; //关联关系的聚合关系

    //通过构造器，传入一个voltage220V实例
    public VoltageAdapter(Voltage220V voltage220V) {
        this.voltage220V = voltage220V;
    }

    @Override
    public int output5V() {
        int dstV = 0;
        if (null!=voltage220V ){
            int srcV = voltage220V.output220V(); //
            System.out.println("使用对象适配器，进行适配～～～");
            dstV = srcV/44;//转成5v
            System.out.println("适配完成，输出的电压为="+dstV);

        }
        return dstV;
    }
}

package profit.atguigu.designPatter.adapter.classAdapter;

/**
 * 适配器类
 */
public class VoltageAdapter extends Voltage220V implements IVoltage5V{
    @Override
    public int output5V() {
        int srcV = output220V(); //
        int dstV = srcV/44;//转成5v
        return dstV;
    }
}

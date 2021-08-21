package profit.atguigu.JDK8;

public class SubClass /*extends MyClass*/ implements MyFun,MyFunction {
    @Override
    public String getName() {
        return MyFun.super.getName();
    }

    @Override
    public Integer getVaue(Integer num) {
        return null;
    }

    @Override
    public String getValue(String str) {
        return null;
    }
}

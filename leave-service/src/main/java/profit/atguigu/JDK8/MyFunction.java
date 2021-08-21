package profit.atguigu.JDK8;
@FunctionalInterface
//申明函数式接口，接口声明抽象方法，public String getValue(String str)
public interface MyFunction {
    default String getName(){
        return "hahha ";
    }
    public String getValue(String str);
}

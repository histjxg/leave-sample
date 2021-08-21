package profit.atguigu.JDK8;
@FunctionalInterface
public interface MyFun {
    default String getName(){
        return "hahha ";
    }
    public Integer getVaue(Integer num);
}

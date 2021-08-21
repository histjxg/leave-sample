package profit.atguigu.JDK8;
@FunctionalInterface
public interface MyFunction2<R,T> {
    public R getValue(T t1,T t2);
}

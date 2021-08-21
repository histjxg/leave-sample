package profit.atguigu.JDK8;

@FunctionalInterface
public interface MyPredicate<T> {
    public boolean test(T t);
}

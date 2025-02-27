package profit.atguigu.designPatter.bridge;

public class UpRightPhone extends Phone{

    public UpRightPhone(Brand brand) {
        super(brand);
    }
    @Override
    protected void open() {
        super.open();
        System.out.println("直立式样式的手机");
    }

    @Override
    protected void close() {
        super.close();
        System.out.println("直立式样式的手机");
    }

    @Override
    protected void call() {
        super.call();
        System.out.println("直立式样式手机");
    }
}

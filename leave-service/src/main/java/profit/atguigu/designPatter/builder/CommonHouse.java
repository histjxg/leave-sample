package profit.atguigu.designPatter.builder;

public class CommonHouse extends AbstractHouse{
    @Override
    public void buildBasic() {
        System.out.println("给普通房子打地基");
    }

    @Override
    public void bulidWalls() {
        System.out.println("给普通房子砌墙");

    }

    @Override
    public void roofed() {
        System.out.println("给普通房子封顶");

    }
}

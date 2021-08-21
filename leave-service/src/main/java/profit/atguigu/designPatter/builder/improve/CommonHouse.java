package profit.atguigu.designPatter.builder.improve;

public class CommonHouse extends HouseBuilder {
    @Override
    public void bulidBasic() {
        System.out.println("普通房子打地基5米");
    }

    @Override
    public void bulidWalls() {
        System.out.println("普通房子砌墙10cm");

    }

    @Override
    public void roofed() {
        System.out.println("普通房子盖的屋顶");

    }
}

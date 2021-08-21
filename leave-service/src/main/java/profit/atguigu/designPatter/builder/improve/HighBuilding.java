package profit.atguigu.designPatter.builder.improve;

public class HighBuilding extends HouseBuilder{
    @Override
    public void bulidBasic() {
        System.out.println("高楼的打地基100米");
    }

    @Override
    public void bulidWalls() {
        System.out.println("高楼的砌墙20cm");
    }

    @Override
    public void roofed() {
        System.out.println("高楼的透明的屋顶");
    }
}

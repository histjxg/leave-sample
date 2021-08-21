package profit.atguigu.designPatter.builder.improve;
//指挥者 这里去指定制作流程，返回产品
public class HouseDirector {
    HouseBuilder houseBuilder = null;
    //1构造器

    public HouseDirector(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    //2。set方法
    public void setHouseBuilder(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }
    //具体建造流程，如何处理建造房子的流程。交给指挥者
    public House constructHouse(){
        houseBuilder.bulidBasic();
        houseBuilder.bulidWalls();
        houseBuilder.roofed();
        return houseBuilder.buildHouse();
    }
}

package profit.atguigu.designPatter.builder;

public abstract class AbstractHouse {
    //打地基
    public abstract void buildBasic();
    //砌墙
    public abstract void bulidWalls();
    //封顶
    public abstract void roofed();
    public void bulid(){
        buildBasic();
        bulidWalls();
        roofed();
    }
}

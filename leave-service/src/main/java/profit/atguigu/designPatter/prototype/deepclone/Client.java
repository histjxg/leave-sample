package profit.atguigu.designPatter.prototype.deepclone;

public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        DeepProtoType p = new DeepProtoType();
        p.name = "宋江";
        p.deepCloneableTarget=new DeepCloneableTarget("大牛","大牛的类");

        //方式一进行深拷贝 一个一个处理太累了；
       // DeepProtoType p2 = (DeepProtoType) p.clone();
       // System.out.println("p.name="+p.name +" p.deepCloneableTaget="+p.deepCloneableTarget.hashCode());
        //System.out.println("p2.name="+p2.name +" p2.deepCloneableTaget="+p2.deepCloneableTarget.hashCode());


        //方式二，完成深拷贝
        DeepProtoType p2 =(DeepProtoType) p.deepClone();
        System.out.println("p.name="+p.name +" p.deepCloneableTaget="+p.deepCloneableTarget.hashCode());
        System.out.println("p2.name="+p2.name +" p2.deepCloneableTaget="+p2.deepCloneableTarget.hashCode());

    }
}

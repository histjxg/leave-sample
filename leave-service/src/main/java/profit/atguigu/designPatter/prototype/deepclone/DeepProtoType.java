package profit.atguigu.designPatter.prototype.deepclone;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class DeepProtoType implements Serializable,Cloneable{
    public String name;
    public DeepCloneableTarget deepCloneableTarget;//引用类型

    public DeepProtoType() {
    }
    //深拷贝 -重写clone

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object deep = null;
        //这里完成基本数据类型（属性）和String的克隆
        deep = super.clone();
        //对引用类型的属性进行单独处理
        DeepProtoType deepProtoType = (DeepProtoType) deep;
        deepProtoType.deepCloneableTarget =(DeepCloneableTarget) deepCloneableTarget.clone();
        return deepProtoType;
    }

    //深拷贝，通过对象的序列化来实现 推荐使用
    public Object deepClone(){
        //创建流对象
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        try {
            //序列化的操作
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this); // 当前的对象以流的方式输出
            //反序列化
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            DeepProtoType deepProtoType = (DeepProtoType) ois.readObject();

            return deepProtoType;

        }catch(Exception e){
            e.printStackTrace();
            return null;
        }finally {
            try{
                bos.close();
                oos.close();
                bis.close();
                ois.close();
            }catch (Exception e ){
                System.out.println(e.getMessage());
            }
        }
    }
}

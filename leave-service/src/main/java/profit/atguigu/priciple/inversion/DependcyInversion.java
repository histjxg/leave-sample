package profit.atguigu.priciple.inversion;

public class DependcyInversion {
    public static void main(String[] args) {
     Person person = new Person();
     person.receive(new Email());

    }
}

//定义接口  通过接口的方式
interface IRceiver{
    public String getInfo();
}
class Email implements IRceiver{
    public String getInfo(){
        return "电子邮件信息：hello world";
    }
}
class WeiXin implements IRceiver{
    public String getInfo(){
        return "Weixin信息：hello world";
    }
}
//完成person接收消息的功能
//方法一完成
//1.简单。比较容易想到
//2。如果我们获取的对象是微信，短信等等，则新增类，同时Person也要增加相应的接收方法
//3。解决思路：引入一个抽象的接口IReceiver，表示接收者，这样Person类与接口IReceiver发生依赖
// 因为Email，WeiXin等等属于接收的范围，它们各自实现IReceiver接口就Ok，这样我们就符号依赖倒转原则
class Person{
    public void receive(IRceiver email){
        System.out.println(email.getInfo());
    }
}


//通过构造方法的形式：
interface IOpenAndClose{
    public void open(); //抽象方法
}
interface ITV{
    public void play();
}

class OpenAndClose implements IOpenAndClose{

    public ITV itv;
    public  OpenAndClose(ITV itv) {//通过构造器的方式
        this.itv = itv;
    }

    @Override
    public void open() {
        this.itv.play();
    }
}

//方式三 通过setter方法传递
interface IOpenAndClose1{
    public void open(); //抽象方法
    public void setTv(ITV1 itv1);
}
interface ITV1{
    public void play();
}

class OpenAndClose1 implements IOpenAndClose1{

    public ITV1 itv1;
    public  OpenAndClose1(ITV1 itv) {//通过构造器的方式
        this.itv1 = itv;
    }

    @Override
    public void open() {
        this.itv1.play();
    }

    @Override
    public void setTv(ITV1 itv1) {
        this.itv1 =itv1;
    }
}


package profit.lianxi.jvm;

/**
 * Created by huangxiaogen on 2021/8/3 下午12:22
 */
public class MyTest {
    Object obj1 = new Object();
    Object obj2 = new Object();
    public void fun1(){
        synchronized (obj1){
            fun2();
        }
    }
    public void fun2(){
        synchronized (obj2){
            while (true){ //为了演示需要，该函数永不退出
                System.out.println("");
            }
        }
    }

    public static void main(String[] args) {
        MyTest aa = new MyTest();
        aa.fun1();
    }

}

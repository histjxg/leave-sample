package profit.估泡.thread.synchronzed.volatiles;

public class StoreBufferDemo {
    static int a =0,b = 0;

    //文档参考链接：https://www.bilibili.com/read/cv5131208
    public static void main(String[] args) {
        fun0();
        fun2();
    }
    static void fun0(){
        a =1;
        b=1;
        //cpu层面的重排序问题
        //b=1;
        //a=1;
    }
    static void fun2(){
        while (b==0)continue;
        assert (a==1);
    }
}

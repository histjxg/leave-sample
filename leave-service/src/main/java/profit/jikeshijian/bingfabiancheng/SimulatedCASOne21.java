package profit.jikeshijian.bingfabiancheng;

public class SimulatedCASOne21 {
    int count;
    synchronized int cas(int expect ,int newValue){
        //读目前的值
        int curValue= count;
        //比较目前count值是否==期望值
        if (curValue==expect){
            //如果是，更新count的值
            count = newValue;
        }
        return curValue;
    }
}

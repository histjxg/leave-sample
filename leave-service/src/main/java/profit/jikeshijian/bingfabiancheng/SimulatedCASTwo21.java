package profit.jikeshijian.bingfabiancheng;
/*

“CAS+ 自旋”的实现方案如下所示
    1。首先计算 newValue = count+1
    2。如果 cas(count,newValue) 返回的值不等于 count
    3。则意味着线程在执行完代码1处之后，执行代码2 处之前，count 的值被其他线程更新过
       那此时该怎么处理呢?
        1。可以采用自旋方案，就像下面代 码中展示的
        2。可以重新读 count 最新的值来计算 newValue 并尝试再次更新，直到成功。

ABA问题：
    1。假设 count 原本是 A，线程 T1 在执行完代码1处之后，执行代码2处之前
    2。有可能 count 被线程 T2 更新成 了 B，之后又被 T3 更新回了 A
    3。这样线程 T1 虽然看到的一直是 A，但是其实已经被其他线程更 新过了，这就是 ABA 问题。





 */

public class SimulatedCASTwo21 {
    volatile int count;
    //实现count+=1
    void addOne(){
        int newValue;
       do{
          newValue =count+1;
       }while (count!=cas(count,newValue));
    }
    synchronized int cas(int expect ,int newValue){
        //读目前的值
        int curValue= count;
        //比较目前count值是否==期望值
        if (curValue==expect){
            //如果是，更新count的值
            count = newValue;
        }
        //返回写入的值
        return curValue;
    }
}

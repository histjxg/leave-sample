package profit.jikeshijian.bingfabiancheng;

import lombok.Data;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 *
 *
 *
 *
 曾经写过一个RPC框架，有点类似Dubbo
 1.服务提供方是多实例分布式部署的，所以服务的客户端在调用RPC的时候
 2.会选定一个服务实例来调用，这个选定的过程本质上就是在做负载均衡
 3.而做负载均衡的前提是客户端要有全部的路由信息。
    例子：
 1。A服务的提供方有3个实例，分别是192.168.1.1、192.168.1.2和192.168.1.3
 2。客户端在调用目标服务A前，首先需要做的是负载均衡，也就是从这3个实例中选出1个来，
 3。然后再通过RPC把请求发送选中的目标实例
作用：
 RPC框架的一个核心任务就是维护服务的路由关系
 思考
 1。我们可以把服务的路由关系简化成下图所示的路由表。
 2。当服务提供方上线或者下线的时候，就需要更新客户端的这张路由表。

 问题：如何用程序实现
 1。每次RPC调用都需要通过负载均衡器来计算目标服务的IP和端口号
 2。而负载均衡器需要通过路由表获取接口的所有路由信息，
 3。访问路由表这个操作的性能要求是很高的
     原因：
        每次RPC调用都需要访问路由表
 4。过路由表对数据的一致性要求并不高，一个服务提供方从上线到反馈到客户端的路由表里，即便有5秒钟，很多时候也都是能接受的
     说明：
        5秒钟，对于以纳秒作为时钟周期的CPU来说，那何止是一万年，所以路由表对一致性的要求并不高）
     注意：
        路由表是典型的读多写少类问题，写操作的量相比于读操作，可谓是沧海一粟，少得可怜。

思路：
 1。对读的性能要求很高，读多写少，弱一致性
 2。？CopyOnWriteArrayList和CopyOnWriteArraySet天生就适用这种场景啊
 具体实现：
     1。RouteTable这个类内部我们通过ConcurrentHashMap<String, CopyOnWriteArraySet<Router>>这个数据结构来描述路由表
     2。ConcurrentHashMap的Key是接口名，Value是路由集合，这个路由集合我们用是CopyOnWriteArraySet。
设计思路：
 思考Router该如何设计
 1。服务提供方的每一次上线、下线都会更新路由信息，
 方案一：
     1。通过更新Router的一个状态位来标识
     过程：
         1。所有访问该状态位的地方都需要同步访问，这样很影响性能

 方案二：
     采用Immutability模式
     每次上线、下线都创建新的Router对象或者删除对应的Router对象
 后者是最好的选择。
     原因：
        由于上线、下线的频率很低

 RouterImmutability29的实现代码如下所示，是一种典型Immutability模式的实现
 需要你注意的是我们重写了equals方法，这样CopyOnWriteArraySet的add()和remove()方法才能正常工作。
 *
 *
 *
 *
 *
 *
 *
 */
@Data
public final class RouterImmutability29 {
    private final String  ip;
    private final Integer port;
    private final String  iface;
    //构造函数
    public RouterImmutability29(String ip,
            Integer port, String iface){
        this.ip = ip;
        this.port = port;
        this.iface = iface;
    }
    //重写equals方法
    public boolean equals(Object obj){
        if (obj instanceof RouterImmutability29) {
            RouterImmutability29 r = (RouterImmutability29)obj;
            return iface.equals(r.iface) &&
                    ip.equals(r.ip) &&
                    port.equals(r.port);
        }
        return false;
    }
    public int hashCode() {
        //省略hashCode相关代码
        return 0;
    }
}
class RouterTableImmutability29 {
    //Key:接口名
    //Value:路由集合
    ConcurrentHashMap<String, CopyOnWriteArraySet<RouterImmutability29>>
            rt = new ConcurrentHashMap<>();
    //根据接口名获取路由表
    public Set<RouterImmutability29> get(String iface){
        return rt.get(iface);
    }
    //删除路由
    public void remove(RouterImmutability29 router) {
        Set<RouterImmutability29> set=rt.get(router.getIface());
        if (set != null) {
            set.remove(router);
        }
    }
    //增加路由
    public void add(RouterImmutability29 router) {
        Set<RouterImmutability29> set = rt.computeIfAbsent(
                router.getIface(), r ->
                        new CopyOnWriteArraySet<>());
        set.add(router);
    }
}


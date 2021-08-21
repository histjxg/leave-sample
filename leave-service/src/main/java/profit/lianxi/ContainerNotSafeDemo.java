package profit.lianxi;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 集合类不安全的问题
 */
public class ContainerNotSafeDemo {
    public static void main(String[] args) {
        ////ConcurrentHashMap和hashmap的底层原码不同
        Map<String,String > map = new ConcurrentHashMap<>();
        for (int i =1;i<=30;i++){
            new Thread(() -> {
                try {

                    map.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0,8));
                    System.out.println(map);

                }catch (Exception e){
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }

    }

    private static void setNotSafe() {
        Set<String> hashSet = new HashSet<>();
        // hashSet.add("e"); hashSet底层是hashMap，只关心key不关心，value是一个常量
        // Set<String> hashSet =  Collections.synchronizedSet(new HashSet<>());
        // Set<String> hashSet = new CopyOnWriteArraySet<>();
        // List<String> hashSet = new ArrayList();
        //  List<String> hashSet = new Vector(); 解决方法一，vector方法加了锁


    /*    hashSet.add("a");
        hashSet.add("b");
        hashSet.add("c");
        for (String element:arrayList
             ) {
            System.out.println(element);
        }*/
        for (int i =1;i<=30;i++){
            new Thread(() -> {
                try {

                    hashSet.add(UUID.randomUUID().toString().substring(0,8));
                    System.out.println(hashSet);

                }catch (Exception e){
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }

    private static void listNotSafe() {
        //扩容和初始化，是否线程安全,  ConcurrentModificationException
        // new ArrayList<Integer>().add(1);
        // List<String> arrayList = Collections.synchronizedList(new ArrayList<>());
        List<String> arrayList = new CopyOnWriteArrayList<>();

        // List<String> arrayList = new ArrayList();
        //  List<String> arrayList = new Vector(); 解决方法一，vector方法加了锁

    /*    arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        for (String element:arrayList
             ) {
            System.out.println(element);
        }*/
        for (int i =1;i<=30;i++){
            new Thread(() -> {
                try {

                    arrayList.add(UUID.randomUUID().toString().substring(0,8));
                    System.out.println(arrayList);

                }catch (Exception e){
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
}
/**
 *
 * 不要只是会用，会用只是一个底层API工程师，要明白底层原理
 * 1故障现象
 *  报错ConcurrentModificationException并发修改异常
 *
 * 2。导致原因
 *  并发争夺修改导致，参考我们的花名册修改导致
 *  一个人正在写入，另外一个同学过来抢夺，导致数据不一致异常
 *
 *
 *
 *
 * 3解决方案
 *  3.1 new Vector
 *  3.2 Collections.synchronizedList(new ArrayList<>())
 *  3.3 CopyOnWriteArrayList这个东西 参考篇博客 https://www.jianshu.com/p/5f570d2f81a2
 *
 *
 *
 * 4优化建议（保证不犯第二次错误）
 */

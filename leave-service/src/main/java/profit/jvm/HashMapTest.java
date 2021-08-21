package profit.jvm;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
    public static void main(String[] args) {
        //数据结构，数组+链表+红黑树
        //数组：Arraylist
        //链表：linkedList 双向链表
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"jack");
        System.out.println("jack".hashCode());

    }
}

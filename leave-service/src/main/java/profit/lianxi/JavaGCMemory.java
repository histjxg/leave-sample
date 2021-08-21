package profit.lianxi;

import java.util.HashMap;

/**
 * Created by huangxiaogen on 2021/8/12 下午1:59
 */
public class JavaGCMemory {
    public static void main(String[] args) {
        HashMap mapobj = new HashMap(); //全局变量
        String obj1 = new String("abcd");
        mapobj.put(obj1,obj1);
        obj1=null;
        System.out.println("mapobj"+ mapobj.toString());
    }
}

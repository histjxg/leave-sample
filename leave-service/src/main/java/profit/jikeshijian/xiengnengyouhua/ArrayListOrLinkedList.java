package profit.jikeshijian.xiengnengyouhua;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ArrayListOrLinkedList {
    public static void main(String[] args)
    {
//        HashMap
        ArrayList<String> list = new ArrayList<String>();
        list.add("a");
        list.add("a");
        list.add("b");
        list.add("b");
        list.add("c");
        list.add("c");
//        remove(list);// 删除指定的“b”元素
//        remove1(list);// 删除指定的“b”元素
        remove2(list);// 删除指定的“b”元素

        for(int i=0; i<list.size(); i++)
        {
            System.out.println("element : " + list.get(i));
        }
    }

    public static void remove(ArrayList<String> list)
    {
        Iterator<String> it = list.iterator();

        while (it.hasNext()) {
            String str = it.next();

            if (str.equals("b")) {
                it.remove();
            }
        }

    }
    public static void remove1(ArrayList<String> list)
    {
        for (String s : list)
        {
            if (s.equals("b"))
            {
                list.remove(s);
            }
        }
    }
    public static void remove2(ArrayList<String> list)
    {
        for (int i = 0; i <list.size() ; i++) {

            {
                if (list.get(i).equals("b")) {
                    list.remove(list.get(i));
                }
            }
        }
    }

}

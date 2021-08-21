package profit.jikeshijian.xiengnengyouhua;

import java.util.ArrayList;
import java.util.List;

public class StringTest {

    public static void main(String[] args) {
       /* String s1=new String("StringTest");
        System.out.println(s1.intern()==s1); //false(JDK 8)
        String s2 = new StringBuilder().append("String").append("Test").toString();
        System.out.println(s2.intern() == s2);//true(JDK 8)
        String s3 = new StringBuilder("StringTest").toString();
        System.out.println(s3.intern() == s3);*/
      /* String c="A"+"B";
        System.out.println("A"+"B");*/
        List list = new ArrayList();
        list.add(1);
        list.stream().forEach((a)->{
            System.out.println(12);
        });

    }



}

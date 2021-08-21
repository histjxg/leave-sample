package profit.lianxi.jvm;

import java.util.ArrayList;
import java.util.List;

public class Test03 {

    byte[] byteArray = new byte[1*1024*1024];

    public static void main(String[] args) {
        List<Test03> list = new ArrayList<>();
        try{
            for (int i = 0; i <40; i++) {
                list.add(new Test03());
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}

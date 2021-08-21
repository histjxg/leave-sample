package profit.jikeshijian.shejimoshi.celuemoshi;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: huangxiaogen
 * @Date: 2020/07/19/下午3:31
 * @Description:
 */

public class SortAlgFactory {
    private static final Map<String ,ISortAlg> algs= new HashMap();
    static {
        algs.put("QucikSort",new QuickSort());
        algs.put("ExternalSort",new ExternalSort());
        algs.put("ConcurrentExternalSort",new ConcurrentExternalSort());
        algs.put("MapReduceSort",new MapReduceSort());
    }

    public static ISortAlg getSortAlg(String type){
        if(type==null||type.isEmpty()){
            throw new IllegalArgumentException("type should noot be empty");
        }
        return algs.get(type);
    }



}

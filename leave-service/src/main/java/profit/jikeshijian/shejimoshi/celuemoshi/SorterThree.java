package profit.jikeshijian.shejimoshi.celuemoshi;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: huangxiaogen
 * @Date: 2020/07/19/下午3:35
 * @Description:
 */

/**
 *1.经过上面两次重构之后，现在的代码实际上已经符合策略模式的代码结构了
 * 2.我们通过策略模式将策略的定义、创建、使用解耦，让每一部分都不至于太复杂。
 * 3.不过，Sorter 类中的 sortFile() 函数还是有一堆 if-else 逻辑。
 * 4.这里的 if-else 逻辑分支不多、也不复杂，这样写 完全没问题。
 * 5.但如果你特别想将 if-else 分支判断移除掉，那也是有办法的。我直接给出代 码，你一看就能明白。
 * 6.。实际上，这也是基于查表法来解决的
 *
 *
 *
 *
 */
public class SorterThree {
    private static final long GB = 1000 * 1000 * 1000;
    public void sortFile(String filePath) { // 省略校验逻辑
        File file = new File(filePath);
        long fileSize = file.length(); ISortAlg sortAlg; if(fileSize<6*GB){//[0,6GB)
            sortAlg = SortAlgFactory.getSortAlg("QuickSort");
        } else if (fileSize < 10 * GB) { // [6GB, 10GB)
            sortAlg = SortAlgFactory.getSortAlg("ExternalSort");
        } else if (fileSize < 100 * GB) { // [10GB, 100GB)
            sortAlg = SortAlgFactory.getSortAlg("ConcurrentExternalSort");
        } else { // [100GB, ~)
            sortAlg = SortAlgFactory.getSortAlg("MapReduceSort");
        }
        sortAlg.sort(filePath);
    }




}


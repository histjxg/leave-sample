package profit.jikeshijian.shejimoshi.celuemoshi;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: huangxiaogen
 * @Date: 2020/07/19/下午3:38
 * @Description:
 */

/**
 *
 * 查表法：
 * 1。但如果你特别想将 if-else 分支判断移除掉，那也是有办法的
 * 2。我直接给出代码，你一看就能明白。
 * 3。实际上，这也是基于查表法来解决的，其中的“algs”就是“表”。
 *
 * 优点：
 * 1。现在的代码实现就更加优美了。我们把可变的部分隔离到了策略工厂类和 Sorter 类中的静 态代码段中
 * 2。当要添加一个新的排序算法时，我们只需要修改策略工厂类和 Sort 类中的静 态代码段
 * 3。其他代码都不需要修改，这样就将代码改动最小化、集中化了。
 * 4。你可能会说，即便这样，当我们添加新的排序算法的时候，还是需要修改代码，并不完全符合开闭原则。
 *
 *
 *
 */
public class SorterFour {
    private static final long GB = 1000*1000*1000;
    private static final List<AlgRange> algs = new ArrayList<>();

    static {
        algs.add(new AlgRange(0, 6 * GB, SortAlgFactory.getSortAlg("QuickSort")));
        algs.add(new AlgRange(6 * GB, 10 * GB, SortAlgFactory.getSortAlg("ExternalSort")));
        algs.add(new AlgRange(10 * GB, 100 * GB, SortAlgFactory.getSortAlg("ConcurrentExternalSort")));
        algs.add(new AlgRange(100 * GB, Long.MAX_VALUE, SortAlgFactory.getSortAlg("MapReduceSort")));
    }
    public void sortFile(String filePath) {
        // 省略校验逻辑
        File file = new File(filePath);
        long fileSize = file.length();

        ISortAlg sortAlg = null;
        for (AlgRange algRange : algs) {
            if (algRange.inRange(fileSize)) {
                sortAlg = algRange.getAlg();
                break;
            }
        }
        sortAlg.sort(filePath);
    }


    //构造的一张内部表
    private static class AlgRange {
        private long start;
        private long end;
        private ISortAlg alg;

        public AlgRange(long start, long end, ISortAlg alg) {
            this.start = start;
            this.end = end;
            this.alg = alg;
        }

        public ISortAlg getAlg() {
            return alg;
        }

        public boolean inRange(long size) {
            return size >= start && size < end;
        }
    }

}

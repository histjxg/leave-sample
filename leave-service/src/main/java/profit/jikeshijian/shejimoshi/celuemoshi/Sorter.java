package profit.jikeshijian.shejimoshi.celuemoshi;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: huangxiaogen
 * @Date: 2020/07/19/下午3:02
 * @Description:
 */

/**
 *
 * 1。在“编码规范”那一部分我们讲过，函数的行数不能过多，最好不要超过一屏的大小
 * 2。所以，为了避免 sortFile() 函数过长，我们把每种排序算法从 sortFile() 函数中抽离出来，拆分成 4 个独立的排序函数。
 * 3。分析：
 * 1。如果只是开发一个简单的工具，那上面的代码实现就足够了。
 * 2。毕竟，代码不多，后续修改、扩展的需求也不多，怎么写都不会导致代码不可维护
 * 3。如果我们是在开发一个大型项目，排序文件只是其中的一个功能模块，那我们就要在代码设计、代码质量上下点儿功夫了
 *4。只有每个小的功能模块都写好，整个项目的代码才能不差。
 * 5。我们并没有给出每种排序算法的代码实现
 *6。每种排序算法的实现逻辑都比较复杂，代码行数都比较多。
 * 7。所有排序算法的代码实现都堆在 Sorter 一个类中，这就会导致这个类的代码很多
 * 8。而在“编码规范”那一部分中，我们也讲到，一个类的代码太多也会影响到可读性、可维护性
 * 9。除此之外，所有的 排序算法都设计成 Sorter 的私有函数，也会影响代码的可复用性。
 *
 */
public class Sorter {
    private static final long GB = 1000 * 1000 * 1000;

    public void sortFile(String filePath) { // 省略校验逻辑
        File file = new File(filePath);
        long fileSize = file.length();
        if (fileSize < 6 * GB) {//[0,6GB) quickSort(filePath);
        } else if (fileSize < 10 * GB) { // [6GB, 10GB)
            externalSort(filePath);
        } else if (fileSize < 100 * GB) { // [10GB, 100GB)
            concurrentExternalSort(filePath);
        } else { // [100GB, ~)
            mapreduceSort(filePath);
        }
    }
    private void quickSort(String filePath) { // 快速排序
    }
    private void externalSort(String filePath) { // 外部排序
    }
    private void concurrentExternalSort(String filePath) { // 多线程外部排序
    }
    private void mapreduceSort(String filePath) { // 利用MapReduce多机排序
    }


}

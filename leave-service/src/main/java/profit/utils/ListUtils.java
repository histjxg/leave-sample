package profit.utils;

import java.util.ArrayList;
import java.util.List;
/**
 * 工具类
 * 
 * @author: liguang[li_guang@suixingpay.com]
 * @date: 2019年5月16日 下午3:59:48
 * @version: V1.0
 * @review: liguang[li_guang@suixingpay.com]/2019年5月16日 下午3:59:48
 */
public class ListUtils {
    public static <T> List<List<T>> splitList(List<T> list, int pageSize) {
        int listSize = list.size(); // list的大小
        int page = (listSize + (pageSize - 1)) / pageSize;// 页数
        List<List<T>> listArray = new ArrayList<>();// 创建list数组,用来保存分割后的list
        for (int i = 0; i < page; i++) { // 按照数组大小遍历
            List<T> subList = new ArrayList(); // 数组每一位放入一个分割后的list
            for (int j = 0; j < listSize; j++) { // 遍历待分割的list
                int pageIndex = ((j + 1) + (pageSize - 1)) / pageSize;// 当前记录的页码(第几页)
                if (pageIndex == (i + 1)) { // 当前记录的页码等于要放入的页码时
                    subList.add(list.get(j)); // 放入list中的元素到分割后的list(subList)
                }
                if ((j + 1) == ((j + 1) * pageSize)) { // 当放满一页时退出当前循环
                    break;
                }
            }
            listArray.add(subList); // 将分割后的list放入对应的数组的位中
        }
        return listArray;
    }
}

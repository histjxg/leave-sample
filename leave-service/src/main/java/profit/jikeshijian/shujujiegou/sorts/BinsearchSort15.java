package profit.jikeshijian.shujujiegou.sorts;

/**
 * Created by wangzheng on 2018/10/16.
 */
public class BinsearchSort15 {
  /**
   *
   *
   *
   *
  解释：
   1。low、high、mid都是指数组下标，其中low和high表示当前查找的区间范围
   2。初始low=0， high=n-1。mid表示[low, high]的中间位置
   3。通过对比a[mid]与value的大小，来更新接下来要查找的区间范围，直到找到或者区间缩小为0，就退出
   4。如果你有一些编程基础，看懂这些应该不成问题。
   */
 public int bSearch(int[] a,int n,int value){
   int low =0;
   int high = n-1;
   while (low<=high){
     int mid = (low+high)/2;
     if (a[mid]==value){
       return mid;
     }else if (a[mid]<value){
       low = mid+1;
     }else {
       high = mid-1;
     }
   }
   return -1;
 }

  /**
   *
  递归二分查找
   */
  public int bsearch02(int[] a, int n, int val) {
    return bsearchInternally(a, 0, n - 1, val);
  }

  private int bsearchInternally(int[] a, int low, int high, int value) {
    if (low > high)
      return -1;
    int mid = low + ((high - low) >> 1);
    if (a[mid] == value) {
      return mid;
    } else if (a[mid] < value) {
      return bsearchInternally(a, mid + 1, high, value);
    } else {
      return bsearchInternally(a, low, mid - 1, value);
    }
  }

  /**
   *
   变体一：查找第一个值等于给定值的元素
   *
   */
  //难理解的
  public int bsearch03(int[] a, int n, int value) {
    int low = 0;
    int high = n - 1;
    while (low <= high) {
      int mid = low + ((high - low) >> 1);
      if (a[mid] >= value) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    if (low < n && a[low] == value)
      return low;
    else
      return -1;
  }
  //更容易理解的

  /**
   *
  1.a[mid]跟要查找的value的大小关系有三种情况:大于、小于、等于
   2.对于a[mid]>value的情况，我们需要更新high= mid-1
   3.对于a[mid]<value的情况，我们需要更新low=mid+1
  问题：
    那当a[mid]=value的时候应该如何处理呢?
   答案：
   1。如果我们查找的是任意一个值等于给定值的元素，当a[mid]等于要查找的值时，a[mid]就是我们要找的元素
   2。如果我们求解的是第一个值等于给定值的元素，当a[mid]等于要查找的值时，我们就需要确认一下这个a[mid]是不是第一个值等于给定值的元素。
   3。

   */
  public int bsearch04(int[] a, int n, int value) {
    int low = 0;
    int high = n - 1;
    while (low <= high) {
      int mid = low + ((high - low) >> 1);
      if (a[mid] > value) {
        high = mid - 1;
      } else if (a[mid] < value) {
        low = mid + 1;
      } else {
        if ((mid == 0) || (a[mid - 1] != value))
          return mid;
        else
          high = mid - 1;
      }
    }
    return -1;
  }
  //查找最后一个值等于给定值的元素
  public int bsearch05(int[] a, int n, int value) {
    int low = 0;
    int high = n - 1;
    while (low <= high) {
      int mid = low + ((high - low) >> 1);
      if (a[mid] > value) {
        high = mid - 1;
      } else if (a[mid] < value) {
        low = mid + 1;
      } else {
        if ((mid == n - 1) || (a[mid + 1] != value))
          return mid;
        else low = mid + 1;
      }
    }
    return -1;
  }
  //查找第一个大于等于给定值的元素
  public int bsearch06(int[] a, int n, int value) {
    int low = 0;
    int high = n - 1;
    while (low <= high) {
      int mid = low + ((high - low) >> 1);
      if (a[mid] >= value) {
        if ((mid == 0) || (a[mid - 1] < value))
          return mid;
        else
          high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return-1;
  }
  //查找最后一个小于等于给定值的元素
  public int bsearch07(int[] a, int n, int value) {
    int low = 0;
    int high = n - 1;
    while (low <= high) {
      int mid = low + ((high - low) >> 1);
      if (a[mid] > value) {
        high = mid - 1;
      } else {
        if ((mid == n - 1) || (a[mid + 1] > value))
          return mid;
        else
          low = mid + 1;
      }
    }
    return -1;
  }


}

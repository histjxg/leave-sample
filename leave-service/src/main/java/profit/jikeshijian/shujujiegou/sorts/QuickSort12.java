package profit.jikeshijian.shujujiegou.sorts;

/**
 原理：
 1。如果要排序数组中下标从p到r之间的一组数据，我们选择p到r之间的任意一个数据作为pivot(分区点)。
 2。我们遍历p到r之间的数据，将小于pivot的放到左边，将大于pivot的放到右边，将pivot放到中间
 3。经过这一步骤之后，数组p到r之间的数据就被分成了三个部分
   前面：p到q-1之间都是小于pivot的
   中间：是pivot的
   后面：q+1到r之间是大于pivot的
方法一：
 1。如果我们不考虑空间消耗的话，partition()分区函数可以写得非常简单
 2。我们申请两个临时数组X和Y，遍历A[p...r]，将小于pivot的元素都拷贝到临时数组X
 3。将大于pivot的元素都拷贝到临时数组Y，最后再将数组X和数组Y中数据顺序拷贝到A[p...r]。
 缺点：
 1。partition()函数就需要很多额外的内存空间，所以快排就不是原地排序算法了
方法二：
 1。如果我们希望快排是原地排序算法，那它的空 间复杂度得是O(1)
 2。那partition()分区函数就不能占用太多额外的内存空间，我们就需要在A[p...r]的原地完成分区操作
 3。我们通过游标i把A[p...r-1]分成两部分。A[p...i-1]的元素都是小于pivot的，
  我们暂且叫它“已处理区间”，A[i...r-1]是“未处理区 间”
 4。我们每次都从未处理的区间A[i...r-1]中取一个元素A[j]，与pivot对比
 5。如果小于pivot，则将其加入到已处理区间的尾部，也就是A[i]的位置。
 6。
 */
public class QuickSort12 {

  // 快速排序，a是数组，n表示数组的大小
  public static void quickSort(int[] a, int n) {
    quickSortInternally(a, 0, n-1);
  }

  // 快速排序递归函数，p,r为下标
  private static void quickSortInternally(int[] a, int p, int r) {
    if (p >= r) return;

    int q = partition(a, p, r); // 获取分区点
    quickSortInternally(a, p, q-1);
    quickSortInternally(a, q+1, r);
  }

  private static int partition(int[] a, int p, int r) {
    int pivot = a[r];
    int i = p;
    for(int j = p; j < r; ++j) {
      if (a[j] < pivot) {
        if (i == j) {
          ++i;
        } else {
          int tmp = a[i];
          a[i++] = a[j];
          a[j] = tmp;
        }
      }
    }

    int tmp = a[i];
    a[i] = a[r];
    a[r] = tmp;

    System.out.println("i=" + i);
    return i;
  }
}

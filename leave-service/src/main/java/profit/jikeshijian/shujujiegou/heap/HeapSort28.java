package profit.jikeshijian.shujujiegou.heap;

/**
 * 堆排序
 */
public class HeapSort28 {

    /**
     * 排序
     * <p>
     * 堆元素是从数组下标0开始
     *
     * @param arr
     */
    public static void sort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }

        // 1、建堆
        buildHeap(arr);

        // 2、排序
        int k = arr.length - 1;
        while (k > 0) {
            // 将堆顶元素（最大）与最后一个元素交换位置
            swap(arr, 0, k);
            // 将剩下元素重新堆化，堆顶元素变成最大元素
            heapify(arr, --k, 0);
        }
    }

    /**
     * 建堆
     *
     * @param arr
     */
    private static void buildHeap(int[] arr) {
        // (arr.length - 1) / 2 为最后一个叶子节点的父节点
        // 也就是最后一个非叶子节点，依次堆化直到根节点
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            heapify(arr, arr.length - 1, i);
        }
    }

    /**
     * 堆化
     *
     * @param arr 要堆化的数组
     * @param n   最后堆元素下标
     * @param i   要堆化的元素下标
     */
    private static void heapify(int[] arr, int n, int i) {
        while (true) {
            // 最大值位置
            int maxPos = i;
            // 与左子节点（i * 2 + 1）比较，获取最大值位置
            if (i * 2 + 1 <= n && arr[i] < arr[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }
            // 最大值与右子节点（i * 2 + 2）比较，获取最大值位置
            if (i * 2 + 2 <= n && arr[maxPos] < arr[i * 2 + 2]) {
                maxPos = i * 2 + 2;
            }
            // 最大值是当前位置结束循环
            if (maxPos == i) {
                break;
            }
            // 与子节点交换位置
            swap(arr, i, maxPos);
            // 以交换后子节点位置接着往下查找
            i = maxPos;
        }
    }

    public static int bF(String a,String b) {
        int m=a.length(),n=b.length(),k;
        char[] a1=a.toCharArray();
        char[] b1=b.toCharArray();
        for(int i=0;i<=m-n;i++) {
            k=0;
            for(int j=0;j<n;j++) {
                if(a1[i+j]==b1[j]) {
                    k++;
                }
                else
                    break;
            }
            if(k==n) {
                return i;
            }
        }
        return -1;
    }
    public static int rK(String a,String b) {
        int m=a.length(),n=b.length(),s,j;
        int[] hash=new int[m-n+1];
        int[] table=new int[26];
        char[] a1=a.toCharArray();
        char[] b1=b.toCharArray();
        s=1;
        //将26的次方存储在一个表里，取的时候直接用,虽然溢出，但没啥问题
        for(j=0;j<26;j++) {
            table[j]=s;
            s*=26;
        }
        for(int i=0;i<=m-n;i++) {
            s=0;
            for(j=0;j<n;j++) {
                s+=(a1[i+j]-'a')*table[n-1-j];
            }
            hash[i]=s;
        }
        s=0;
        for(j=0;j<n;j++) {
            s+=(b1[j]-'a')*table[n-1-j];
        }
        for(j=0;j<m-n+1;j++) {
            if(hash[j]==s) {
                return j;
            }
        }
        return -1;
    }

    private static void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }

        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
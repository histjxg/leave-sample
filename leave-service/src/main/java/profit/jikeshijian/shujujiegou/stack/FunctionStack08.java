package profit.jikeshijian.shujujiegou.stack;

/**
 *
 函数调用栈：
 1。从代码中我们可以看出，main()函数调用了add()函数，获取计算结果
 2。并且与临时变量a相加，最后打印res的值
 3。
 *
 *
 *
 *
 */
public class FunctionStack08 {
    public static void main(String[] args) {
        {
            int a = 1;
            int ret = 0;
            int res = 0;
            ret = add(3, 5);
            res = a + ret;
            System.out.println("%d" + res);
        }
    }

    static int add(int x, int y) {
        int sum = 0;
        sum = x + y;
        return sum;
    }
}

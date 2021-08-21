package profit.jikeshijian.shujujiegou.String;

public class Dynamic40 {
    // 回溯算法实现。注意:我把输入的变量都定义成了成员变量。
    private int maxW = Integer.MIN_VALUE; // 结果放到maxW中
    private int[] weight = { 2, 2, 4, 6, 3 }; // 物品重量
    private int n = 5; // 物品个数
    private int w = 9; // 背包承受的最大重量

    public void f1(int i, int cw) { // 调用f(0, 0)
        if (cw == w || i == n) { // cw==w表示装满了，i==n表示物品都考察完了
            if (cw > maxW)
                maxW = cw;
            return;
        }
        f1(i + 1, cw); // 选择不装第i个物品
        if (cw + weight[i] <= w) {
            f1(i + 1, cw + weight[i]); // 选择装第i个物品
        }
    }



    private boolean[][] mem = new boolean[5][10]; // 备忘录，默认值false

    /**
     *
     1.从递归树中，你应该能会发现，有些子问题的求解是重复的
     2.比如图中f(2, 2)和f(3,4)都被重复计算了两次。我们可以借助递归那一节讲的“备忘录”的解决方式，
     3.记录已经计算好的f(i, cw)，当再次计算到重复的f(i, cw)的时候
     4.可以直接从备忘录中取出来用，就不用再递归计算了，这样就可以避免冗余计算。
     */
    public void f(int i, int cw) { // 调用f(0, 0)
        if (cw == w || i == n) { // cw==w表示装满了，i==n表示物品都考察完了
            if (cw > maxW)
                maxW = cw;
            return;
        }

        if (mem[i][cw])
            return; // 重复状态
        mem[i][cw] = true; // 记录(i, cw)这个状态
        f(i + 1, cw); // 选择不装第i个物品
        if (cw + weight[i] <= w) {
            f(i + 1, cw + weight[i]); // 选择装第i个物品
        }
    }

    //weight:物品重量，n:物品个数，w:背包可承载重量
    public int knapsack(int[] weight, int n, int w) {
        boolean[][] states = new boolean[n][w + 1]; // 默认值false
        states[0][0] = true; // 第一行的数据要特殊处理，可以利用哨兵优化
        states[0][weight[0]] = true;
        for (int i = 1; i < n; ++i) { // 动态规划状态转移
            for (int j = 0; j <= w; ++j) {// 不把第i个物品放入背包
                if (states[i - 1][j] == true)
                    states[i][j] = states[i - 1][j];
            }

            for (int j = 0; j <= w - weight[i]; ++j) {//把第i个物品放入背包
                if (states[i - 1][j] == true)
                    states[i][j + weight[i]] = true;
            }
        }

        for (int i = w; i >= 0; --i) { // 输出结果
            if (states[n - 1][i] == true)
                return i;
        }
        return 0;
    }

    /**
     *
        优化：
     */
    //我们只需要一个大小为w+1的一维数组就可以解决这个问题。
    // 动态规划状态转移的过程，都可以基于这个一维数组来操作
    public static int knapsack2(int[] items, int n, int w) {
        boolean[] states = new boolean[w + 1]; // 默认值false
        states[0] = true; // 第一行的数据要特殊处理，可以利用哨兵优化
        states[items[0]] = true;
        for (int i = 1; i < n; ++i) { // 动态规划
            for (int j = w - items[i]; j >= 0; --j) {//把第i个物品放入背包
                if (states[j] == true)
                    states[j + items[i]] = true;
            }
        }
        for (int i = w; i >= 0; --i) { // 输出结果
            if (states[i] == true)
                return i;
        }
        return 0;
    }

    /**
     * 背包问题升级优化
     *1。对于一组不同重量、不同价值、不可分割的物品，我们选择将某些物品装入背包，
     *2。在满足背包最大重量限制的前提下，背包中可装入物品的总价值最大是多少呢?
     *
     *
     */
    //回溯方法
    /**
     * 1.在递归树中，每个节点表示一个状态。现在我们需要3个变量(i, cw, cv)来表示一个状态
     * 2.其中，i表示即将要决策 第i个物品是否装入背包，cw表示当前背包中物品的总重量，cv表示当前背包中物品的总价值。
     * 3. 我们发现，在递归树中，有几个节点的i和cw是完全相同的，比如f(2,2,4)和f(2,2,3)。
     * 4.在背包中物品总重量一样的情况下，f(2,2,4)这种状态对应的物品总价值更大， 我们可以舍弃f(2,2,3)这种状态，
     * 5.只需要沿着f(2,2,4)这条决策路线继续往下决策就可以。
      */

    private int maxV = Integer.MIN_VALUE; // 结果放到maxV中
    private int[] value = { 3, 4, 8, 9, 6 }; // 物品的价值

    public void f2(int i, int cw, int cv) { // 调用f(0, 0, 0)
        if (cw == w || i == n) { // cw==w表示装满了，i==n表示物品都考察完了
            if (cv > maxV)
                maxV = cv;
            return;
        }
        f2(i + 1, cw, cv); // 选择不装第i个物品
        if (cw + weight[i] <= w) {
            f2(i + 1, cw + weight[i], cv + value[i]); // 选择装第i个物品
        }
    }
    /**
     * 动态规划
     */
    public static int knapsack3(int[] weight, int[] value, int n, int w) {
        int[][] states = new int[n][w + 1];
        for (int i = 0; i < n; ++i) { // 初始化states
            for (int j = 0; j < w + 1; ++j) {
                states[i][j] = -1;
            }
        }

        states[0][0] = 0;
        states[0][weight[0]] = value[0];
        for (int i = 1; i < n; ++i) { //动态规划，状态转移
            for (int j = 0; j <= w; ++j) { // 不选择第i个物品
                if (states[i - 1][j] >= 0)
                    states[i][j] = states[i - 1][j];
            }

            for (int j = 0; j <= w - weight[i]; ++j) { // 选择第i个物品
                if (states[i - 1][j] >= 0) {
                    int v = states[i - 1][j] + value[i];
                    if (v > states[i][j + weight[i]]) {
                        states[i][j + weight[i]] = v;
                    }
                }
            }
        }

        // 找出最大值
        int maxvalue = -1;
        for (int j = 0; j <= w; ++j) {
            if (states[n - 1][j] > maxvalue)
                maxvalue = states[n - 1][j];
        }

        return maxvalue;
    }



    // items商品价格，n商品个数, w表示满减条件，比如200
    public static void double11advance(int[] items, int n, int w) {
        boolean[][] states = new boolean[n][3 * w + 1];//超过3倍就没有薅羊毛的价值了
        states[0][0] = true; // 第一行的数据要特殊处理
        states[0][items[0]] = true;
        for (int i = 1; i < n; ++i) { // 动态规划
            for (int j = 0; j <= 3 * w; ++j) {// 不购买第i个商品
                if (states[i - 1][j] == true)
                    states[i][j] = states[i - 1][j];
            }
            for (int j = 0; j <= 3 * w - items[i]; ++j) {//购买第i个商品
                if (states[i - 1][j] == true)
                    states[i][j + items[i]] = true;
            }
        }
        int j;
        for (j = w; j < 3 * w + 1; ++j) {
            if (states[n - 1][j] == true)
                break; // 输出结果大于等于w的最小值
        }

        if (j == -1)
            return; // 没有可行解
        for (int i = n - 1; i >= 1; --i) { // i表示二维数组中的行，j表示列
            if (j - items[i] >= 0 && states[i - 1][j - items[i]] == true) {
                System.out.print(items[i] + " "); // 购买这个商品
                j = j - items[i];
            }
        } // else 没有购买这个商品，j不变。
        if (j != 0)
            System.out.print(items[0]);
    }
}

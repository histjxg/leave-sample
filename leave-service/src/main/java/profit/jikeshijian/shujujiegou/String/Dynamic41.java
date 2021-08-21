package profit.jikeshijian.shujujiegou.String;

public class Dynamic41 {
    private int minDist = Integer.MAX_VALUE; // 全局变量或者成员变量 // 调用方式:minDistBacktracing(0, 0, 0, w, n);

    public void minDistBT(int i, int j, int dist, int[][] w, int n) {
        // 到达了n-1, n-1这个位置了,这里看着有点奇怪哈,你自己举个例子看下
        if (i == n && j == n) {
            if (dist < minDist)
                minDist = dist;
            return;
        }

        if (i < n) { // 往下走,更新i=i+1, j=j
            minDistBT(i + 1, j, dist + w[i][j], w, n);
        }

        if (j < n) { // 往右走,更新i=i, j=j+1
            minDistBT(i, j + 1, dist + w[i][j], w, n);
        }
    }

    /**
     *
        状态转移表法解决矩阵问题
     */
    public int minDistDP(int[][] matrix, int n) {
        int[][] states = new int[n][n];
        int sum = 0;
        for (int j = 0; j < n; ++j) { // 初始化states的第一行数据
            sum += matrix[0][j];
            states[0][j] = sum;
        }

        sum = 0;
        for (int i = 0; i < n; ++i) { // 初始化states的第一列数据
            sum += matrix[i][0];
            states[i][0] = sum;
        }

        for (int i = 1; i < n; ++i) {
            for (int j = 1; j < n; ++j) {
                states[i][j] = matrix[i][j] + Math.min(states[i][j - 1], states[i - 1][j]);
            }
        }
        return states[n - 1][n - 1];
    }

    private int[][] matrix = { { 1, 3, 5, 9 }, { 2, 1, 3, 4 }, { 5, 2, 6, 7 }, { 6, 8, 4, 3 } };
    private int n = 4;
    private int[][] mem = new int[4][4];

    /**
     * 状态转移方程法
     * @param i
     * @param j
     * @return
     */
    public int minDist(int i, int j) { // 调用minDist(n-1, n-1);
        if (i == 0 && j == 0)
            return matrix[0][0];
        if (mem[i][j] > 0)
            return mem[i][j];
        int minLeft = Integer.MAX_VALUE;
        if (j - 1 >= 0) {
        }
        minLeft = minDist(i, j - 1);
        int minUp = Integer.MAX_VALUE;
        if (i - 1 >= 0) {
        }
        minUp = minDist(i - 1, j);
        int currMinDist = matrix[i][j] + Math.min(minLeft, minUp);
        mem[i][j] = currMinDist;
        return currMinDist;
    }

}

package profit.jikeshijian.shujujiegou.graph;

import java.util.LinkedList;

public class DFS31 {
    private int v; // 顶点的个数
    private LinkedList<Integer> adj[]; // 邻接表
    boolean found = false; // 全局变量或者类成员变量

    /**
     *
    1。深度优先搜索代码实现也用到了prev、visited变量以及print()函数，它们跟广度优先搜索代码 实现里的作用是一样的
     2。深度优先搜索代码实现里，有个比较特殊的变量found
     作用：
         当我们已经找到终止顶点t之后，我们就不再递归地继续查找 了。
     4。
     5。



     */
    public void dfs(int s, int t) {
        found = false;
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }

        recurDfs(s, t, visited, prev);
        print(prev, s, t);
    }

    private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
        if (found == true)
            return;
        visited[w] = true;
        if (w == t) {
            found = true;
            return;
        }

        for (int i = 0; i < adj[w].size(); ++i) {
            int q = adj[w].get(i);
            if (!visited[q]) {
                prev[q] = w;
                recurDfs(q, t, visited, prev);
            }
        }
    }

    private void print(int[] prev, int s, int t) { // 递归打印s->t的路径
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }

        System.out.print(t + " ");
    }
}

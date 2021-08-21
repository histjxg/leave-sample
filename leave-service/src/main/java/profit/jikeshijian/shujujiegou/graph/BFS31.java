package profit.jikeshijian.shujujiegou.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 注意：
 * 参考：profit.jikeshijian.shujujiegou.graph.Graph30
 */
public class BFS31 {
    private int v; // 顶点的个数
    private LinkedList<Integer> adj[]; // 邻接表

    /*
    里面有三个重要的辅助变量visited、queue、prev。只要理解这三个变量，读懂这段代码估计就没什么问题了。
        1。visited
            作用：
                用来记录已经被访问的顶点，用来避免顶点被重复访问；
            现象：
                如果顶点q被访问，那相应的visited[q]会被设置为true。
        2。queue
            概念：
                是一个队列，用来存储已经被访问、但相连的顶点还没有被访问的顶点。
                原因：
                    1。广度优先搜索是逐层访问的，也就是说，我们只有把第k层的顶点都访问完成之后，才能访问第k+1层的顶点
                    2。当我们访问到第k层的顶点的时候，我们需要把第k层的顶点记录下来，稍后才能通过第k层的顶点来找第k+1层的顶点
        3。prev
            作用：
                用来记录搜索路径。
            例子：
                1。当我们从顶点s开始，广度优先搜索到顶点t后，prev数组中存储的就是搜索的路径。不过，这个路径是反向存储的
                2。prev[w]存储的是，顶 点w是从哪个前驱顶点遍历过来的。
                3。比如，我们通过顶点2的邻接表访问到顶点3，那prev[3]就等于2。
                4。为了正向打印出路径，我们需要递归地来打印，你可以看 下print()函数的实现方式。
    参考：
        com/suixingpay/profit/document/数据结构/图片/第31讲广度优先搜索的分解图.png

     */
    public void bfs(int s, int t) {
        if (s == t)
            return;
        boolean[] visited = new boolean[v];
        visited[s] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        int[] prev = new int[v];
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }

        while (queue.size() != 0) {
            int w = queue.poll();
            for (int i = 0; i < adj[w].size(); ++i) {
                int q = adj[w].get(i);
                if (!visited[q]) {
                    prev[q] = w;
                    if (q == t) {
                        print(prev, s, t);
                        return;
                    }

                    visited[q] = true;
                    queue.add(q);
                }
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

package profit.jikeshijian.shujujiegou.graph;

import java.util.LinkedList;

/*
    我们要求解的问题就转化为，在一个有向有权图中，求两个顶点间的最短路径。
 */
public class Graph44 {
    private LinkedList<Edge> adj[]; // 邻接表
    private int v; // 顶点个数

    public Graph44(int v) {
        this.v = v;
        this.adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            this.adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t, int w) { // 添加一条边
        this.adj[s].add(new Edge(s, t, w));
    }

    private class Edge {
        public int sid; // 边的起始顶点编号
        public int tid; // 边的终止顶点编号
        public int w; // 权重

        public Edge(int sid, int tid, int w) {
            this.sid = sid;
            this.tid = tid;

            this.w = w;
        }
    }

    // 下面这个类是为了dijkstra实现用的
    private class Vertex {
        public int id; // 顶点编号ID
        public int dist; // 从起始顶点到这个顶点的距离

        public Vertex(int id, int dist) {
            this.id = id;
            this.dist = dist;
        }
    }

    /*
        1.最短路径算法:是单源最短路径算法(一个顶点到一个顶点)
        2.提到最短路径算法，最出名的莫过 于Dijkstra算法了
     */
    // 因为Java提供的优先级队列，没有暴露更新数据的接口，所以我们需要重新实现一个
    private class PriorityQueue { // 根据vertex.dist构建小顶堆
        private int count;
        private Vertex[] nodes;

        public PriorityQueue(int v) {
            this.nodes = new Vertex[v + 1];
            this.count = v;
        }

        public Vertex poll() {
            // TODO: 留给读者实现...
            return new Vertex(1, 2);
        }

        public void add(Vertex vertex) { // TODO: 留给读者实现...
        }

        // 更新结点的值，并且从下往上堆化，重新符合堆的定义。时间复杂度O(logn)。
        public void update(Vertex vertex) { // TODO: 留给读者实现...

        }

        public boolean isEmpty() { // TODO: 留给读者实现...
            return true;
        }
    }



    /*
        分析：
        第一步：：
            用vertexes数组：
                1。记录从起始顶点到每个顶点的距离(dist)
                2。起初，我们把所有顶点的dist都初始化为无穷大(也就是代码中的Integer.MAX_VALUE)
                3。我们把起始顶点的dist值初始化为0
                4。然后将其放到优先级队列中。
        第二步
            1。我们从优先级队列中取出dist最小的顶点minVertex
        第三步
            1。然后考察这个顶点可达的所有顶点(代码中的nextVertex)
            情形一：
                1。如果minVertex的dist值加上minVertex与nextVertex之间边的权重w小于nextVertex当前的dist值
                2。存在另一条更短的路径，它经过minVertex到达nextVertex。
                3。那我们就 把nextVertex的dist更新为minVertex的dist值加上w。
                4。然后，我们把nextVertex加入到优先级队列中
                5。重复这个过程，直到找到终止顶点t或者队列为空。
        predecessor数组：
            作用：
            ·   1。为了还原最短路径，它记录每个顶点的前驱顶点。最后，我们通过递归的方式，将这个路径打印出来
        inqueue数组是：
        作用：
            1。为了避免将一个顶点多次添加到优先级队列中
            2。我们更新了某个顶点的dist值之后，如果这个顶点已经在优先级队列中了，就不要再将它重复添加进 去了。

     */
    public void dijkstra(int s, int t) { // 从顶点s到顶点t的最短路径
        int[] predecessor = new int[this.v]; // 用来还原最短路径
        Vertex[] vertexes = new Vertex[this.v];
        for (int i = 0; i < this.v; ++i) {
            vertexes[i] = new Vertex(i, Integer.MAX_VALUE);
        }
        PriorityQueue queue = new PriorityQueue(this.v);// 小顶堆
        boolean[] inqueue = new boolean[this.v]; // 标记是否进入过队列
        vertexes[s].dist = 0;
        queue.add(vertexes[s]);
        inqueue[s] = true;
        while (!queue.isEmpty()) {
            Vertex minVertex = queue.poll(); // 取堆顶元素并删除
            if (minVertex.id == t)
                break; // 最短路径产生了
            for (int i = 0; i < adj[minVertex.id].size(); ++i) {
                Edge e = adj[minVertex.id].get(i); // 取出一条minVetex相连的边
                Vertex nextVertex = vertexes[e.tid]; // minVertex-->nextVertex
                if (minVertex.dist + e.w < nextVertex.dist) { // 更新next的dist
                    nextVertex.dist = minVertex.dist + e.w;
                    predecessor[nextVertex.id] = minVertex.id;
                    if (inqueue[nextVertex.id] == true) {
                        queue.update(nextVertex); // 更新队列中的dist值
                    } else {
                        queue.add(nextVertex);
                        inqueue[nextVertex.id] = true;
                    }
                }
            }
        }
        // 输出最短路径
        System.out.print(s);
        print(s, t, predecessor);
    }

    private void print(int s, int t, int[] predecessor) {
        if (s == t)
            return;
        print(s, predecessor[t], predecessor);
        System.out.print("->" + t);
    }
}

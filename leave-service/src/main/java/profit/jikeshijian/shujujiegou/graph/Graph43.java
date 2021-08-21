package profit.jikeshijian.shujujiegou.graph;

import java.util.HashSet;
import java.util.LinkedList;

public class Graph43 {//有向无环图
    private int v; // 顶点的个数
    private LinkedList<Integer> adj[]; // 邻接表

    public Graph43(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t) {  // s先于t，边s->t
        adj[s].add(t);

    }

    /*
        拓扑排序：Kahn算法
     */
    public void topoSortByKahn() {
        int[] inDegree = new int[v]; // 统计每个顶点的入度
        for (int i = 0; i < v; ++i) {
            for (int j = 0; j < adj[i].size(); ++j) {
                int w = adj[i].get(j); // i->w
                inDegree[w]++;
            }
        }

        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < v; ++i) {
            if (inDegree[i] == 0)
                queue.add(i);
        }

        while (!queue.isEmpty()) {
            int i = queue.remove();
            System.out.print("->" + i);
            for (int j = 0; j < adj[i].size(); ++j) {
                int  k = adj[i].get(j);
                inDegree[k]--;
                if(inDegree[k]==0)queue.add(k);
            }
        }
    }

    /**
     * DFS算法,拓扑排序
     * 这个算法包含两个关键部分。
     *第一部分：
         * 1。通过邻接表构造逆邻接表
         * 2。邻接表中，边s->t表示s先于t执行，也就是t要依赖s。
         * 3。在逆邻接表中，边s->t表示s依赖于t，s后于t执行。为什么这么转化呢?这个跟我们这个算法的实现思想有关。
     *第二部分：
         * 1。是这个算法的核心，也就是递归处理每个顶点。
         * 2。对于顶点vertex来说，我们先输出它可达的所有顶点，也就是说，先把它依赖的所有的顶点输出了，然后再输出自己。
     *
     *
     *
     *
     *
     *
     *
     *
     */
    public void topoSortByDFS() {
        // 先构建逆邻接表，边s->t表示，s依赖于t，t先于s
        LinkedList<Integer> inverseAdj[] = new LinkedList[v];
        for (int i = 0; i < v; ++i) { // 申请空间
            inverseAdj[i] = new LinkedList<>();
        }
        for (int i = 0; i < v; ++i) { // 通过邻接表生成逆邻接表
            for (int j = 0; j < adj[i].size(); ++j) {
                int w = adj[i].get(j); // i->w
                inverseAdj[w].add(i); // w->i

            }
        }
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; ++i) { // 深度优先遍历图
            if (visited[i] == false) {
                visited[i] = true;
                dfs(i, inverseAdj, visited);
            }
        }
    }

    private void dfs(int vertex, LinkedList<Integer> inverseAdj[], boolean[] visited) {
        for (int i = 0; i < inverseAdj[vertex].size(); ++i) {
            int w = inverseAdj[vertex].get(i);
            if (visited[w] == true)
                continue;
            visited[w] = true;
            dfs(w, inverseAdj, visited);
        } // 先把vertex这个顶点可达的所有顶点都打印出来之后，再打印它自己
        System.out.print("->"+vertex);
    }

    HashSet<Integer> hashTable = new HashSet<>(); // 保存已经访问过的actorId

    void findRootReferrerId(long actorId) {
        if (hashTable.contains(actorId)) { // 存在环
            return ;
        }

//        hashTable.add(actorId);
//        Long referrerId = select referrer_id from[table]where actor_id = actorId;
//        if (referrerId == null)
//            return actorId;
//        return findRootReferrerId(referrerId);
    }


}
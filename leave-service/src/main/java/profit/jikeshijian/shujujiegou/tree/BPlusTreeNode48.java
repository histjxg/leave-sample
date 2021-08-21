package profit.jikeshijian.shujujiegou.tree;

public class BPlusTreeNode48 {
    /**
     * 这是B+树非叶子节点的定义。
     * 假设keywords=[3, 5, 8, 10]
     * 4个键值将数据分为5个区间:(-INF,3), [3,5), [5,8), [8,10), [10,INF) * 5个区间分别对应:children[0]...children[4]
     * m值是事先计算得到的，计算的依据是让所有信息的大小正好等于页的大小: * PAGE_SIZE = (m-1)*4[keywordss大小]+m*8[children大小]
     */
        public static int m = 5; // 5叉树
        public int[] keywords = new int[m-1]; // 键值，用来划分数据区间
        public BPlusTreeNode48[] children = new BPlusTreeNode48[m];//保存子节点指针


}

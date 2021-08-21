package profit.jikeshijian.shujujiegou.tree;

public class BPlusTreeLeafNode48 {
    /**
     * 这是B+树中叶子节点的定义。
     * B+树中的叶子节点跟内部结点是不一样的,
     * 叶子节点存储的是值，而非区间。
     * 这个定义里，每个叶子节点存储3个数据行的键值及地址信息。
     * k值是事先计算得到的，计算的依据是让所有信息的大小正好等于页的大小: * PAGE_SIZE = k*4[keyw..大小]+k*8[dataAd..大小]+8[prev大小]+8[next大小]
     */
    public static int k = 3;
    public int[] keywords = new int[k]; // 数据的键值
    public long[] dataAddress = new long[k]; // 数据地址
    public BPlusTreeLeafNode48 prev; // 这个结点在链表中的前驱结点
    public BPlusTreeLeafNode48 next; // 这个结点在链表中的后继结
}

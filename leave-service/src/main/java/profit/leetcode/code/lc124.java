package profit.leetcode.code;
/*
 * 124. Binary Tree Maximum Path Sum
 * 题意：二叉树中找和最大的路径
 * 难度：Hard
 * 分类：Tree, Depth-first Search
 * 思路：因为二叉树只有两个节点，一条路径可以想象成倒V字，从低层的某个节点一路向上，到达一个顶点，再一路向下，理解了这一点，整道题就好解了。
 * Tips：用了一个全局变量存储最后结果，因为函数返回的是直线路径上的最优解，而不是V字路径最优解
 *      lc112, lc113, lc437, lc129, lc124, lc337, lc543, lc1026
 */
public class lc124 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    int res = Integer.MIN_VALUE;      //可能小于0
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }
    public int dfs(TreeNode root){
        if(root==null)
            return 0;
        int left = Math.max(dfs(root.left),0);
        int right = Math.max(dfs(root.right),0);
        // 后序遍历代码位置
        res = Math.max(res, left+right+root.val);   //该节点是路径上的最高层节点
        return Math.max(left,right)+root.val;
    }
}

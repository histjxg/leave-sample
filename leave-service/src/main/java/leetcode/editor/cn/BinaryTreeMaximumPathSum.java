//路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不
//一定经过根节点。 
//
// 路径和 是路径中各节点值的总和。 
//
// 给你一个二叉树的根节点 root ，返回其 最大路径和 。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3]
//输出：6
//解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6 
//
// 示例 2： 
//
// 
//输入：root = [-10,9,20,null,null,15,7]
//输出：42
//解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围是 [1, 3 * 104] 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 动态规划 二叉树 
// 👍 1152 👎 0

/**
 * @author yitiaoIT
 */
package leetcode.editor.cn;

/**
 * 124题
 */
public class BinaryTreeMaximumPathSum {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeMaximumPathSum().new Solution();
        TreeNode treeNode = new BinaryTreeMaximumPathSum().new TreeNode();
        solution.maxPathSum(treeNode);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/**
 解题思路：
 按照题意：一颗三个节点的小树的结果只可能有如下6种情况：
 根 + 左 + 右
 根 + 左
 根 + 右
 根
 左
 右
 然后使用递归，选择小树的最大路径和的情况，拼凑成一颗大树
 **/

    /**
     对于任意一个节点, 如果最大和路径包含该节点, 那么只可能是两种情况:
     1. 其左右子树中所构成的和路径值较大的那个加上该节点的值后向父节点回溯构成最大路径
     2. 左右子树都在最大路径中, 加上该节点的值构成了最终的最大路径
     **/
class Solution {
        private int maxSum = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            getMaxSum(root);
            return maxSum;

    }
        //返回当前节点的最大路径和
        public int getMaxSum(TreeNode node){
            if(node == null){
                return 0;
            }
            //该节点左子树的最大路径和,要大于0才算有贡献
            int leftMaxSum = Math.max(0,getMaxSum(node.left));
            //该节点右子树的最大路径和，要大于0才算有贡献
            int rightMaxSum = Math.max(0,getMaxSum(node.right));
            //当前时刻以来所积累的最大路径和
            maxSum = Math.max(maxSum,node.val+leftMaxSum+rightMaxSum);
            //从当前节点开始的最大路径和,节点本身肯定是要算的，无论他是否小于0，因为就是从这个节点开始的
            return node.val + Math.max(leftMaxSum,rightMaxSum);
        }


}
//leetcode submit region end(Prohibit modification and deletion)

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

}
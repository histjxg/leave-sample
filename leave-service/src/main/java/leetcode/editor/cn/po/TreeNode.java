package leetcode.editor.cn.po;

/**
 * 基本的二叉树节点，二叉树遍历框架，典型的非线性递归遍历结构：
 * 注意：
 *  你看二叉树的递归遍历方式和链表的递归遍历方式，相似不？
 */
public class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(){

    }
    TreeNode(int val){
        this.val=val;
    }
    TreeNode(int val,TreeNode left,TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * 几乎所有二叉树的题目都是一套这个框架就出来了：
     * @param root
     */
    void traverse(TreeNode root) {
        // 前序遍历代码位置
        traverse(root.left);
        // 中序遍历代码位置
        traverse(root.right);
        // 后序遍历代码位置
    }
}

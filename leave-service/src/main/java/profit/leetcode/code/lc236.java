package profit.leetcode.code;

import java.util.*;

/*
 * 236. Lowest Common Ancestor of a Binary Tree
 * 题意：二叉树上两个节点的公共祖先
 * 难度：Medium
 * 分类：Tree
 * 思路：递归，迭代两种方法
 * Tips：注意递归时怎么返回。很经典的题目。
 *
 */
public class lc236 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {//递归
        if( root==null || root==p || root==q )  //注意这个条件
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if( left!=null && right!=null ) return root;     //回溯返回。哪边不为空，返回哪边，否则返回自己。
        else if(left!=null) return left;
        else return right;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();   //用map存储节点的父亲节点，便于查找
        Stack<TreeNode> stack = new Stack<>();
        parent.put(root, null);
        stack.push(root);

        while (!parent.containsKey(p) || !parent.containsKey(q)) {  //遍历了一遍节点，把节点的父节点信息记录了一下
            TreeNode node = stack.pop();
            if (node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }
        Set<TreeNode> ancestors = new HashSet<>();
        while (p != null) {     //p的路径节点添加到hashset中
            ancestors.add(p);
            p = parent.get(p);
        }
        while (!ancestors.contains(q)) //第一个hashset中遇到的节点，就是最近公共祖先
            q = parent.get(q);
        return q;
    }
}

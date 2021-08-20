package leetcode.editor.cn.二叉搜索树;

import leetcode.editor.cn.BinaryTreeMaximumPathSum;

import java.util.ArrayList;
import java.util.List;

public class SecondTree {


    public static void main(String[] args) {

    }

    /**
     *
     * 95. 不同的二叉搜索树 II
     * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从
     * 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
        if(n < 1)
            return new ArrayList<>();
        return helper(1, n);
    }

    //思路：
    //1.如何构建一颗二叉搜索树 helperalance方法
    //2.要构建多颗二叉树，问题就在于如何选择不同的根节点，以构建不同的树和子树
    public List<TreeNode> helper(int start, int end){
        List<TreeNode> list = new ArrayList<>();

        if(start > end){
            // 如果当前子树为空，不加null行吗？
            list.add(null);
            return list;
        }

        for(int i = start; i <= end; i++){
            // 想想为什么这行不能放在这里，而放在下面？
            // TreeNode root = new TreeNode(i);
            List<TreeNode> left = helper(start, i-1);
            List<TreeNode> right = helper(i+1, end);

            // 固定左孩子，遍历右孩子
            for(TreeNode l : left){
                for(TreeNode r : right){
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    list.add(root);
                }
            }
        }
        return list;
    }

    /**
     * 构建一个二叉平衡树
     */
    public TreeNode helperalance(int start, int end){
        if(start > end)
            return null;

        // 这里可以选择从start到end的任何一个值做为根结点，
        // 这里选择它们的中点，实际上，这样构建出来的是一颗平衡二叉搜索树
        int val = (start + end) / 2;
        TreeNode root = new TreeNode(val);

        root.left = helperalance(start, val - 1);
        root.right = helperalance(val + 1, end);

        return root;
    }



    class TreeNode {
        int val;TreeNode left;
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

package leetcode.editor.cn.po;

public class TreeNode2 {
    int val;
    TreeNode2[] children;
    void traverse(TreeNode2 root) {
        for (TreeNode2 child : root.children)
            traverse(child);
    }
}

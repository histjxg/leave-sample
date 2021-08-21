package profit.jikeshijian.shujujiegou.tree;


import java.util.*;

/**
 * 前序遍历：先访问根节点，再访问左子节点，最后访问右子节点
 */
public class PreOrder23 {
    //递归实现
    public void preOrderTraverse1(TreeNode root) {
        if (root != null) {
            System.out.print(root.value + "->");
            preOrderTraverse1(root.left);
            preOrderTraverse1(root.right);
        }
    }

    //非递归实现
    public void preOrderTraverse2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.empty()) {
            if (node != null) {
                System.out.print(node.value + "->");
                stack.push(node);
                node = node.left;
            } else {
                TreeNode tem = stack.pop();
                node = tem.right;
            }
        }
    }

}

package profit.jikeshijian.shujujiegou.tree;


import java.util.*;

/**
 * 中序遍历：先访问左子节点，再访问根节点，最后访问右子节点
 */
public class InOrder23 {
    //递归实现
    public void inOrderTraverse(TreeNode root) {
        if (root != null) {
            inOrderTraverse(root.left);
            System.out.print(root.value + "->");
            inOrderTraverse(root.right);
        }
    }

    //非递归实现
    public void inOrderTraverse2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                TreeNode tem = stack.pop();
                System.out.print(tem.value + "->");
                node = tem.right;
            }
        }
    }
}

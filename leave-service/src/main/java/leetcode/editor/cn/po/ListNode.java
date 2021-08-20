package leetcode.editor.cn.po;

public class ListNode {
    int val;
    ListNode next;
    //迭代
    void traverse(ListNode head) {
        for (ListNode p = head; p != null; p = p.next) {
            // 迭代访问 p.val
        }
    }

    //递归访问
    void traverse2(ListNode head) {
        // 递归访问 head.val
        traverse(head.next);
    }
}

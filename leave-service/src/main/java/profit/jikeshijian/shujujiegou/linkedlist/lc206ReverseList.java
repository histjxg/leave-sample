package profit.jikeshijian.shujujiegou.linkedlist;
/*
 * 206. Reverse Linked List
 * 题意：链表反转
 * 难度：Easy
 * 分类：Linked List
 * 思路：2中方法：设置一个快走一步的快指针，注意赋值操作顺序。还有一种递归的方法。
 * Tips：递归的方法有点绕，多看下
 *      lc25, lc206
 *      思路：
 *      类似我们排队，整体向后转，(迭代方法)
 *      第一步，第一个人首先初始化，原先指向前面的一个人，现在指向后面的一个人，还有就是保存上下问信息，
 */
public class lc206ReverseList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public ListNode reverseList2(ListNode head) {   //递归
        return reverseListInt(head, null);
    }
    private ListNode reverseListInt(ListNode head, ListNode pre) {
        if (head == null)
            return pre;
        ListNode next = head.next;
        head.next = pre;
        return reverseListInt(next, head);  //尾递归，操作已经完成，最后返回最后结果罢了
    }
}

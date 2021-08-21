package profit.jikeshijian.shujujiegou.linkedlist;
/*
 * 141. Linked List Cycle
 * 题意：链表是否有环
 * 难度：Easy
 * 分类：Linked List, Two Pointers
 * 思路：快慢指针
 *      lc142
 */
//第一种方案：硬性方法；是否能到达有空指针
//第二种方案：通过一个set，看是否访问元素
//第三种方案：快慢指针
public class lc141HasCycle {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public boolean hasCycle(ListNode head) {
        if(head==null||head.next==null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null&&fast.next!=null){  //注意判断条件，slow一定不等于null，不用判断了
            slow = slow.next;
            fast = fast.next.next;
            if(fast==slow) return true;
        }
        return false;
    }
}

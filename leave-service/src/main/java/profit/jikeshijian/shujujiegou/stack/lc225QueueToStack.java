package profit.jikeshijian.shujujiegou.stack;

import java.util.LinkedList;
import java.util.Queue;

public class lc225QueueToStack {
    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();
    private int top;

    // Push element x onto stack.
    public void push(int x) {
        q2.add(x);
        top = x;
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }
    // Removes the element on top of the stack.
    public int pop() {
        q1.remove();
        int res = top;
        if (!q1.isEmpty()) {
            top = q1.peek();
        }
        return res;
    }
    // Returns whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty();
    }
    // Get the top element.
    public int top() {
        return top;
    }

}

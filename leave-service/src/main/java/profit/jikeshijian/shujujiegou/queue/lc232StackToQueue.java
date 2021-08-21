package profit.jikeshijian.shujujiegou.queue;

import java.util.Stack;

public class lc232StackToQueue {
    private int front;

    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    // Push element x to the back of queue.
    public void push(int x) {
        if (s1.empty())
            front = x;
        s1.push(x);
    }
    // Removes the element from in front of queue.
    //思路：只要遇到pop时，将输出的信息
    public void pop() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty())
                s2.push(s1.pop());
        }
        s2.pop();
    }
    // Return whether the queue is empty.
    public boolean empty() {
        return s1.isEmpty();
    }

    // Get the front element.
    public int peek() {
        return front;
    }



}

package 栈;

import utils.Asserts;

import java.util.Stack;

/**
 * _232_用栈实现队列
 * https://leetcode-cn.com/problems/implement-queue-using-stacks/
 */
public class MyQueue {
    private Stack<Integer> inStack;
    private Stack<Integer> outStack;
    public MyQueue() {
        inStack=new Stack<>();
        outStack=new Stack<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        checkOutStack();
        return outStack.pop();
    }

    public int peek() {
        checkOutStack();
        return outStack.peek();
    }

    public boolean empty() {
        return outStack.isEmpty()&& inStack.isEmpty();
    }


    private void checkOutStack() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        queue.push(1);
        queue.push(2);
        Asserts.test(queue.peek()==1);  // 返回 1
        Asserts.test(queue.pop()==1);   // 返回 1
        Asserts.test(queue.empty()); // 返回 false
    }
}

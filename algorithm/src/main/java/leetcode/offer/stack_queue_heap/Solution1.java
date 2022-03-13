package leetcode.offer.stack_queue_heap;

import java.util.Stack;

/**
 * 实现一个包含 min() 函数的栈，该方法返回当前栈中最小的值。
 */
public class Solution1 {
    private Stack<Integer> dataStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        dataStack.push(node);
        minStack.push(minStack.isEmpty() ? node : Math.min(minStack.peek(), node));
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }

}
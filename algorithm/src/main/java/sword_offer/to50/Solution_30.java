package sword_offer.to50;


import sword_offer.TreeNode;

import java.util.PriorityQueue;
import java.util.Stack;

public class Solution_30 {
    static class MinStack2 {
        Stack<Integer> a;
        PriorityQueue<Integer> b;
        public MinStack2() {
            a = new Stack<>();
            b = new PriorityQueue<>();
        }
        public void push(int x) {   // 压栈
            a.push(x);
            b.add(x);
        }
        public void pop() { // 出栈
            b.remove(a.pop());
        }
        public int top() {  // 查看栈顶
            return a.peek();
        }
        public int min() {  // 最小
            return b.peek();
        }
    }



}
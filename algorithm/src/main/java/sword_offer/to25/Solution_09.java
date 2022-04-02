package sword_offer.to25;


import java.util.Stack;

// 用两个栈实现一个队列。队列的声明如下，
// 请实现它的两个函数 appendTail 和 deleteHead ，
// 分别完成在队列尾部插入整数和在队列头部删除整数的功能。
// (若队列中没有元素，deleteHead 操作返回 -1 )
public class Solution_09 {
    private static class CQueue {
        private Stack<Integer> stack = new Stack<>();
        private Stack<Integer> stackTemp = new Stack<>();

        public CQueue() {
        }

        public void appendTail(int value) {
            stack.push(value);
        }

        public int deleteHead() {
            if (stack.empty()) {
                if (stackTemp.empty()) {
                    return -1;
                }
                return stackTemp.pop();
            } else {
                if (stackTemp.empty()) {
                    in2out();
                }
                return stackTemp.pop();
            }
        }

        private void in2out() {
            while (!stack.empty()) {
                stackTemp.push(stack.pop());
            }
        }

    }
}
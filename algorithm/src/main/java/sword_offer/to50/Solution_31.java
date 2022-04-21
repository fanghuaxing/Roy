package sword_offer.to50;


import java.util.Stack;

public class Solution_31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int num : pushed) {
            stack.push(num); // num 入栈
            System.out.println("push:" + num);
            while (!stack.isEmpty() && stack.peek() == popped[i]) { // 循环判断与出栈
                Integer pop = stack.pop();
                System.out.println("pop:" + pop);
                i++;
            }
        }
        return stack.isEmpty();
    }
}
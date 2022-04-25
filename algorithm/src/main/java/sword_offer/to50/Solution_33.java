package sword_offer.to50;


import org.junit.Test;

import java.util.Stack;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 */
public class Solution_33 {
    public boolean verifyPostorder(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for (int i = postorder.length - 1; i >= 0; i--) {
            if (postorder[i] > root) return false;
            while (!stack.isEmpty() && stack.peek() > postorder[i]) {
                root = stack.pop();
                System.out.println("pop:" + root);
            }
            stack.add(postorder[i]);
            System.out.println("add:" + postorder[i]);
        }
        return true;
    }

    @Test
    public void main() {
//        int[] arr = new int[]{1, 3, 2, 6, 5};
        int[] arr = new int[]{1, 2, 3, 7, 5};
        System.out.println(verifyPostorder(arr));
    }
}
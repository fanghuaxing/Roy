package sword_offer.to25;

import java.util.Stack;

// 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
public class Solution_06 {
    public int[] reversePrint(ListNode head) {
        // [1,3,2]
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] arr = new int[stack.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = stack.pop();
        }
        return arr;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}